package banco.propio.entidades;

import banco.propio.app.App;
import banco.propio.app.config.ContextoApp;
import banco.propio.repositorios.RepositorioUsuario;
import integracion.interfaz.MediadorBanco;
import integracion.servicio.RedBancaria;

import java.util.ArrayList;
import java.util.List;

public class Banco implements MediadorBanco {
    private static Banco instancia;
    private RepositorioUsuario repoU;

    private Banco() {
    }

    public static Banco getInstance() {
        if (instancia == null) {
            instancia = new Banco();
            RedBancaria.getInstance().registrarBanco(instancia);
            instancia.repoU = ContextoApp.getRepositorioUsuario();
        }
        return instancia;
    }

    @Override
    public boolean existeCuenta(String cbu) {
        return false;
    }

    @Override
    public void recibirTransferencia(String cbuDestino, double monto) {

    }
}