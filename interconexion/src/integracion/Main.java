package integracion;

import banco.propio.app.config.InicializarDatos;
import banco.propio.entidades.Banco;
import integracion.interfaz.BancoParticipante;
import integracion.servicio.RedBancaria;

public class Main {
    public static void main(String[] args) {
        InicializarDatos.cargar();

        BancoParticipante bancoKalil = Banco.getInstance();
        BancoParticipante bancoJorge = banco.socio.Banco.Banco.getInstance();
        RedBancaria red = RedBancaria.getInstance();

        red.registrarBanco(bancoKalil);
        red.registrarBanco(bancoJorge);

        MenuGeneral.iniciar();
    }
}