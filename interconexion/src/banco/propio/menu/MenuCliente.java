package banco.propio.menu;

import banco.propio.entidades.Cuenta;
import banco.propio.entidades.Usuario;
import banco.propio.servicios.ServicioCuenta;
import banco.propio.servicios.ServicioTransaccion;
import banco.propio.servicios.ServicioUsuario;

import java.util.Scanner;

public class MenuCliente {
    public static void iniciar(Usuario usuario, ServicioUsuario servicioUsuario,
    ServicioCuenta servicioCuenta, ServicioTransaccion servicioTransaccion) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU CLIENTE ---");
            System.out.println("1 Depositar");
            System.out.println("2 Retirar");
            System.out.println("3 Transferir");
            System.out.println("4 Consultar saldo");
            System.out.println("0 Salir");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1 -> {
                    System.out.println("Monto:");
                    double monto = sc.nextDouble();

                    Cuenta cuenta = servicioUsuario.obtenerCuenta(usuario);

                    servicioTransaccion.depositar(cuenta, monto);
                    System.out.println("Se ingresaron: $" + monto);
                    System.out.println("Su saldo actual es de: $" + servicioCuenta.obtenerSaldo(cuenta));
                }

                case 2 -> {
                    System.out.println("Monto:");
                    double monto = sc.nextDouble();

                    Cuenta cuenta = servicioUsuario.obtenerCuenta(usuario);

                    servicioTransaccion.retirar(cuenta, monto);
                    System.out.println("Se retiraron: $" + monto);
                    System.out.println("Su saldo actual es de: $" + servicioCuenta.obtenerSaldo(cuenta));
                }

                case 3 -> {
                    System.out.println("Monto:");
                    double monto = sc.nextDouble();
                    sc.nextLine();
                    Cuenta origen = servicioUsuario.obtenerCuenta(usuario);

                    System.out.println("CBU destino numero:");

                    String numero = sc.nextLine();

                    servicioTransaccion.transferir(origen, numero, monto);
                }

                case 4 -> {
                    Cuenta cuenta = servicioUsuario.obtenerCuenta(usuario);

                    double saldo = servicioCuenta.obtenerSaldo(cuenta);

                    System.out.println("\n--- SALDO ACTUAL ---");
                    System.out.println("Cuenta: " + cuenta.getId());
                    System.out.println("Saldo disponible: $" + saldo);
                }
            }

        } while (opcion != 0);
    }
}