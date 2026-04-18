package banco.propio.entidades;

import banco.propio.app.config.ContextoApp;
import banco.propio.repositorios.RepositorioCuenta;
import banco.propio.repositorios.RepositorioSucursal;
import banco.propio.repositorios.RepositorioUsuario;
import banco.propio.servicios.*;
import integracion.interfaz.MediadorBanco;
import integracion.servicio.RedBancaria;

public class Banco implements MediadorBanco {
    private static Banco instancia;
    private RepositorioUsuario repoU;
    private RepositorioSucursal repoS;
    private RepositorioCuenta repoC;
    private ServicioUsuario serviU;
    private ServicioSucursal serviS;
    private ServicioCuenta serviC;
    private ServicioTransaccion serviT;
    private ServicioBanco serviB;

    private Banco() {
    }

    public static Banco getInstance() {
        if (instancia == null) {
            instancia = new Banco();
            instancia.repoU = ContextoApp.getRepositorioUsuario();
            instancia.repoS = ContextoApp.getRepositorioSucursal();
            instancia.repoC = ContextoApp.getRepositorioCuenta();
            instancia.serviU = ContextoApp.getServicioUsuario();
            instancia.serviS = ContextoApp.getServicioSucursal();
            instancia.serviC = ContextoApp.getServicioCuenta();
            instancia.serviT = ContextoApp.getServicioTransaccion();
            instancia.serviB = ContextoApp.getServicioBanco();
            RedBancaria.getInstance().registrarBanco(instancia);
        }
        return instancia;
    }

    @Override
    public boolean existeCuenta(String cbu) {
        return serviC.obtenerCuentaPorId(cbu) != null;
    }

    @Override
    public void recibirTransferencia(String cbuDestino, double monto) {
        Cuenta cuenta = serviC.obtenerCuentaPorId(cbuDestino);

        serviT.depositar(cuenta, monto);
    }
}