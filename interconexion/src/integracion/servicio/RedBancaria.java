package integracion.servicio;
// Corrección: Los imports deberían escribirse al revés: primero los componentes de Java y luego los paquetes del proyecto.
import integracion.interfaz.BancoParticipante;
import integracion.interfaz.MediadorBanco;

import java.util.ArrayList;
import java.util.List;

public class RedBancaria implements MediadorBanco {
    private static RedBancaria instancia;
    private final List<BancoParticipante> bancos = new ArrayList<>();
    // Corrección: Si el constructor no toma parámetros, no asigna valores a variables ni realiza ninguna otra operación o función, es completamente irrelevante. Debería eliminarse.
    private RedBancaria() {

    }

    public static RedBancaria getInstance() {
        if (instancia == null) {
            instancia = new RedBancaria();
        }
        return instancia;
    }
    // Sugerencia: el nombre de la variable banco podría ser más descriptivo, como por ejemplo "bancoNuevo", "bancoSinRegsitrar", etc.
    @Override
    public void registrarBanco(BancoParticipante banco) {
        bancos.add(banco);
    }
    // Corrección: Errores de ortografía en la documentación del método.
    /**
     * Busca el banco que contiene la cuenta destino y delega la recepcion de transferencia.
     *
     * @param cbuDestino CBU destino
     * @param monto Monto a transferir
     * @return true si se encontró la cuenta y se transfirió, false si no existe o no esta habilitada
     */
    @Override
    public boolean transferir(String cbuDestino, double monto) {
        // Sugerencia: La variable de iteración podría tener un nombre más descriptivo, como "bancoIterado" o "indiceBanco".
        for (BancoParticipante banco : bancos) {
            if (banco.esCuentaValida(cbuDestino)) {
                banco.recibirTransferencia(cbuDestino, monto);
                return true;
            }
        }

        return false;
    }
}