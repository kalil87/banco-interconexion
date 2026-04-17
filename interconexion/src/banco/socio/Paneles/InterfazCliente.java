package Paneles;
import Banco.Cuenta;
import Banco.Banco;
import java.util.Scanner;

public class InterfazCliente {


    public void panelCliente(Cuenta cuenta, Banco banco){
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while(opcion != 3){

            System.out.println("¡Bienvenido " + cuenta.nombre + " a la sucursal " + banco.sucursal);
            System.out.println("1. Tranferir");
            System.out.println("2. Consultar saldo de la cuenta");
            System.out.println("3. Salir");
            System.out.println("Seleccione una opción");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:

                    String destinatario;
                    int monto;
                    boolean transferir = false;

                    System.out.println("Ingrese el monto a transferir");
                    monto = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Escriba el nombre de la cuenta a la que desea tranferir");
                    destinatario = sc.nextLine();

                    for (Cuenta c : banco.personas){
                        if (c.nombre.equals(destinatario)) {
                            transferir = true;
                            cuenta.tranferir(c, monto);
                        }
                    }
                    if (!transferir)
                        System.out.println("Cuenta no encontrada, intente nuevamente");
                    break;

                case 2:
                    System.out.println("Su saldo actual es de $" + cuenta.saldo);
                    sc.nextLine();
                    break;

                case 3:
                    break;

                default:
                    System.out.println("Opcion invalida, intente nuevamente");
                    break;
            }
        }
    }
}
