package banco.propio.entidades;

import banco.propio.app.config.ContextoApp;
import banco.propio.servicios.*;
import integracion.interfaz.BancoParticipante;

public class Banco implements BancoParticipante {
    private static Banco instancia;
    private String id;
    private final ServicioCuenta serviC;
    private final ServicioTransaccion serviT;

    private Banco() {
        this.id = "0123";
        this.serviC = ContextoApp.getServicioCuenta();
        this.serviT = ContextoApp.getServicioTransaccion();
    }

    public static Banco getInstance() {
        if (instancia == null) {
            instancia = new Banco();
        }
        return instancia;
    }

    @Override
    public boolean esCuentaValida(String cbu) {
        return serviC.obtenerCuentaPorId(cbu) != null;
    }

    @Override
    public void recibirTransferencia(String cbuDestino, double monto) {
        Cuenta cuenta = serviC.obtenerCuentaPorId(cbuDestino);

        serviT.depositar(cuenta, monto);
    }
}