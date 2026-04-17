package Paneles;
import Banco.Banco;
import Banco.Cuenta;

import java.util.Scanner;

public class InterfazAdmin {
    public void panelAdmin(Cuenta cuenta, Banco banco){

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while(opcion != 4){

            System.out.println("Bienvenido " + cuenta.nombre + " a la sucursal " + banco.sucursal);
            System.out.println("1. Modificar saldo");
            System.out.println("2. Mostrar balance del banco");
            System.out.println("3. Dar de baja cuentas");
            System.out.println("4. Salir");
            System.out.println("Seleccione una opción");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    System.out.print("Nombre de la cuenta: ");
                    String nombreSaldo = sc.nextLine();
                    sc.nextLine();
                    Cuenta cSaldo = buscarCuenta(nombreSaldo, banco);
                    if(cSaldo != null){
                        System.out.print("Ingrese el nuevo saldo de la cuenta: ");
                        double nuevoSaldo = sc.nextDouble();
                        modificarSaldo(cSaldo, nuevoSaldo);
                        sc.nextLine();
                    } else {
                        System.out.println("Cuenta no encontrada, intente nuevamente.");
                        sc.nextLine();
                    }
                    break;
                case 2:
                    banco.mostrarBalance();
                    sc.nextLine();
                    break;
                case 3:
                    System.out.print("Nombre de la cuenta: ");
                    String nombreEstado = sc.nextLine();
                    Cuenta cEstado = buscarCuenta(nombreEstado, banco);
                    if(cEstado != null){
                        cambiarEstadoCuenta(cEstado);
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opcion invalida, intente nuevamente");
                    sc.nextLine();
                    break;
            }
        }
    }

    public void modificarSaldo(Cuenta c, double nuevoSaldo){
        if (c.activo){
            c.saldo = nuevoSaldo;
            System.out.println("Saldo de " + c.nombre + " actualizado a: $" + c.saldo);
        }
        else
            System.out.println("Esta cuenta esta deshabilitada");
    }

    public void cambiarEstadoCuenta(Cuenta c) {
        if (c.activo) {
            c.activo = false;
            System.out.println("Cuenta de " + c.nombre + " deshabilitada.");
        } else {
            c.activo = true;
            System.out.println("Cuenta de " + c.nombre + " habilitada.");
        }
    }
    private Cuenta buscarCuenta(String nombre, Banco banco) {
        for (Cuenta c : banco.personas) {
            if (c.nombre.equals(nombre)) {
                return c;
            }
        }
        return null;
    }
}
