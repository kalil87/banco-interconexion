package banco.propio.servicios;

import banco.propio.entidades.Cuenta;
import integracion.interfaz.MediadorBanco;
import integracion.servicio.RedBancaria;

public class ServicioTransaccion {
    private ServicioCuenta servicioCuenta;
    private MediadorBanco mediador;

    public ServicioTransaccion(ServicioCuenta servicioCuenta, MediadorBanco mediador) {
        this.servicioCuenta = servicioCuenta;
        this.mediador = mediador;
    }

    public void depositar(Cuenta cuenta, double monto) {
        cuenta.setSaldo(cuenta.getSaldo() + monto);
    }

    public void retirar(Cuenta cuenta, double monto) {

        if (cuenta.getSaldo() < monto) {
            throw new RuntimeException("Saldo insuficiente");
        }

        cuenta.setSaldo(cuenta.getSaldo() - monto);
    }

    /**
     * Realiza una transferencia interna o externa.
     * Si la cuenta destino existe en el banco → interna.
     * Si no existe → delega la transferencia al mediador.
     *
     * @param origen Cuenta origen
     * @param cbuDestino CBU destino
     * @param monto Monto a transferir
     */
    public void transferir(Cuenta origen, String cbuDestino, double monto) {

        if (origen.getSaldo() < monto) {
            System.out.println("Saldo insuficiente");
            return;
        }


        // INTERNO
        Cuenta destino = servicioCuenta.obtenerCuentaPorId(cbuDestino);

        if (destino != null) {

            origen.setSaldo(origen.getSaldo() - monto);
            destino.setSaldo(destino.getSaldo() + monto);

            System.out.println("Se transfirieron: $" + monto + " a la cuenta numero " + cbuDestino);
            System.out.println("Su saldo actual es de: $" + servicioCuenta.obtenerSaldo(origen));

        } else {

            // EXTERNO

            boolean ok = mediador.transferir(cbuDestino, monto);

            if (ok) {
                origen.setSaldo(origen.getSaldo() - monto);

                System.out.println("Se transfirieron: $" + monto + " a la cuenta numero " + cbuDestino);
                System.out.println("Su saldo actual es de: $" + servicioCuenta.obtenerSaldo(origen));
            } else {
                System.out.println("CBU no encontrado");
            }
        }
    }
}