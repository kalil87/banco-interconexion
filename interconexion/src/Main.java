import banco.propio.app.config.InicializarDatos;
import integracion.MenuGeneral;

public class Main {
    public static void main(String[] args) {
        InicializarDatos.cargar();
        MenuGeneral.iniciar();
    }
}