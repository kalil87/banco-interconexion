package integracion.servicio;

import integracion.interfaz.MediadorBanco;

import java.util.ArrayList;
import java.util.List;

public class RedBancaria {
    private static RedBancaria instancia;
    private List<MediadorBanco> bancos = new ArrayList<>();

    private RedBancaria() {}

    public static RedBancaria getInstance() {
        if (instancia == null) {
            instancia = new RedBancaria();
        }
        return instancia;
    }

    public void registrarBanco(MediadorBanco banco) {
        bancos.add(banco);
    }

    public void transferir(String cbuDestino, double monto) {

        for (MediadorBanco banco : bancos) {
            if (banco.existeCuenta(cbuDestino)) {
                banco.recibirTransferencia(cbuDestino, monto);
                return;
            }
        }

        throw new RuntimeException("CBU no encontrado");
    }

}
