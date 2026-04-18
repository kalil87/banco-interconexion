package banco.propio.servicios;

import banco.propio.entidades.Cuenta;
import integracion.servicio.RedBancaria;

public class ServicioTransaccion {
    private ServicioCuenta servicioCuenta;
    private RedBancaria redBancaria;

    public ServicioTransaccion(ServicioCuenta servicioCuenta) {
        this.servicioCuenta = servicioCuenta;
        this.redBancaria = RedBancaria.getInstance();
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

//    public void transferir(Cuenta origen, Cuenta destino, double monto) {
//
//        if (origen.getSaldo() < monto) {
//            throw new RuntimeException("Saldo insuficiente");
//        }
//
//        origen.setSaldo(origen.getSaldo() - monto);
//        destino.setSaldo(destino.getSaldo() + monto);
//    }

    public void transferir(Cuenta origen, String cbuDestino, double monto) {

        if (origen.getSaldo() < monto) {
            throw new RuntimeException("Saldo insuficiente");
        }

        // INTERNO
        Cuenta destino = servicioCuenta.obtenerCuentaPorId(cbuDestino);

        if (destino != null) {

            origen.setSaldo(origen.getSaldo() - monto);
            destino.setSaldo(destino.getSaldo() + monto);

        } else {

            // EXTERNO
            origen.setSaldo(origen.getSaldo() - monto);

            redBancaria.transferir(cbuDestino, monto);
        }
    }
}