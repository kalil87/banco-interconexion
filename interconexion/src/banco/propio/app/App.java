package banco.propio.app; //Asumo que banco propio es de Kalil?

import banco.propio.app.config.ContextoApp;
import banco.propio.servicios.*;

import java.util.Scanner;

public class App {

    public static void run() {
        Scanner sc = new Scanner(System.in);

        //InicializarDatos.cargar(); //Codigo comentado en la implementación

        while (true) { //Buena práctica es usar una booleana como "isRunning" o "seEjecuta" para documentar cuando se debería cerrar el bucle

            System.out.println("1. Login");
            System.out.println("2. Exit");

            int op = sc.nextInt(); // Sugerencia: Agregar validaciones para inputs inválidos. Si se ingresa un String en esta línea, el programa colapsa.
            //😈

            switch (op) {
                case 1 -> NavegadorMenus.iniciar(
                        ContextoApp.getServicioUsuario(),
                        ContextoApp.getServicioCuenta(),
                        ContextoApp.getServicioTransaccion(), //Me gusta este modelo desacoplado
                        ContextoApp.getServicioBanco(),
                        ContextoApp.getServicioSucursal()
                );
                case 2 -> {
                    return; //seEjecuta = false; queda mas legible y cierra el bucle de igual forma
                }
                default -> System.out.println("Opción inválida");
            }
        }
    }
}