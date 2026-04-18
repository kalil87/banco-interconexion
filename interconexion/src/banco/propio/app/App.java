package banco.propio.app;

import banco.propio.app.config.InicializarDatos;
import banco.propio.repositorios.RepositorioCuenta;
import banco.propio.repositorios.RepositorioSucursal;
import banco.propio.repositorios.RepositorioUsuario;
import banco.propio.servicios.*;

import java.util.Scanner;

public class App {

    public static void run() {
        Scanner sc = new Scanner(System.in);
        RepositorioCuenta repoC = new RepositorioCuenta();
        RepositorioSucursal repoS = new RepositorioSucursal();
        RepositorioUsuario repoU = new RepositorioUsuario();
        ServicioCuenta servicioCuenta = new ServicioCuenta(repoC, repoS);
        ServicioUsuario servicioUsuario = new ServicioUsuario(repoU);
        ServicioBanco servicioBanco = new ServicioBanco(repoS);
        ServicioSucursal servicioSucursal = new ServicioSucursal(repoS, repoC);
        ServicioTransaccion servicioTransaccion = new ServicioTransaccion();

        InicializarDatos.cargar(servicioCuenta, servicioUsuario);

        while (true) {

            System.out.println("1. Login");
            System.out.println("2. Exit");

            int op = sc.nextInt();

            switch (op) {
                case 1 -> NavegadorMenus.iniciar(
                        servicioUsuario,
                        servicioCuenta,
                        servicioTransaccion,
                        servicioBanco,
                        servicioSucursal
                );
                case 2 -> {
                    return;
                }
                default -> System.out.println("Opción inválida");
            }
        }
    }
}