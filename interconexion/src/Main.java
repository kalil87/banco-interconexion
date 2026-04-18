import banco.propio.app.config.InicializarDatos;
import banco.propio.entidades.Banco;
import integracion.MenuGeneral;

public class Main {
    public static void main(String[] args) {
        Banco bancoKalil = Banco.getInstance();
        InicializarDatos.cargar();
        MenuGeneral.iniciar();
    }
}