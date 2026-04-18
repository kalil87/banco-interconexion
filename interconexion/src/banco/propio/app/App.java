package banco.propio.app;

import banco.propio.app.config.ContextoApp;
import banco.propio.app.config.InicializarDatos;
import banco.propio.repositorios.RepositorioCuenta;
import banco.propio.repositorios.RepositorioSucursal;
import banco.propio.repositorios.RepositorioUsuario;
import banco.propio.servicios.*;

import java.util.Scanner;

public class App {

    public static void run() {
        Scanner sc = new Scanner(System.in);

        InicializarDatos.cargar();

        while (true) {

            System.out.println("1. Login");
            System.out.println("2. Exit");

            int op = sc.nextInt();

            switch (op) {
                case 1 -> NavegadorMenus.iniciar(
                        ContextoApp.getServicioUsuario(),
                        ContextoApp.getServicioCuenta(),
                        ContextoApp.getServicioTransaccion(),
                        ContextoApp.getServicioBanco(),
                        ContextoApp.getServicioSucursal()
                );
                case 2 -> {
                    return;
                }
                default -> System.out.println("Opción inválida");
            }
        }
    }
}