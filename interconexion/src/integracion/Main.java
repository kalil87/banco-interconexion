package integracion;

import banco.propio.app.config.InicializarDatos;
import banco.propio.entidades.Banco;
import integracion.interfaz.MediadorBanco;
import integracion.servicio.RedBancaria;

public class Main {
    public static void main(String[] args) {
        InicializarDatos.cargar();

        MediadorBanco bancoKalil = Banco.getInstance();
        MediadorBanco j = banco.socio.Banco.Banco.getInstance();
        RedBancaria red = RedBancaria.getInstance();

        red.registrarBanco(bancoKalil);
        red.registrarBanco(j);

        MenuGeneral.iniciar();
    }
}