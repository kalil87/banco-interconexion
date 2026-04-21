package integracion.servicio;

import integracion.interfaz.BancoParticipante;
import integracion.interfaz.MediadorBanco;

import java.util.ArrayList;
import java.util.List;

public class RedBancaria implements MediadorBanco {
    private static RedBancaria instancia;
    private final List<BancoParticipante> bancos = new ArrayList<>();

    private RedBancaria() {

    }

    public static RedBancaria getInstance() {
        if (instancia == null) {
            instancia = new RedBancaria();
        }
        return instancia;
    }

    @Override
    public void registrarBanco(BancoParticipante banco) {
        bancos.add(banco);
    }

    @Override
    public boolean transferir(String cbuDestino, double monto) {

        for (BancoParticipante banco : bancos) {
            if (banco.existeCuenta(cbuDestino)) {
                banco.recibirTransferencia(cbuDestino, monto);
                return true;
            }
        }

        return false;
    }
}