package banco.socio.paneles;
import banco.socio.Banco.Cuenta;
import banco.socio.Banco.Banco;
import java.util.Scanner;

public class MenuCliente {


    public void panelCliente(Cuenta cuenta, Banco banco){
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while(opcion != 4){

            System.out.println("¡Bienvenido " + cuenta.nombre + " a la sucursal " + banco.sucursal);
            System.out.println("1. Tranferir");
            System.out.println("2. Consultar saldo de la cuenta");
            System.out.println("3. Depositar");
            System.out.println("4. Salir");
            System.out.println("Seleccione una opción");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:

                    String cbu;
                    int monto;


                    System.out.println("Ingrese el monto a transferir");
                    monto = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Escriba el CBU de la cuenta a la que desea tranferir");
                    cbu = sc.nextLine();

                    cuenta.tranferir(cbu, monto);

                    break;

                case 2:
                    System.out.println("Su saldo actual es de $" + cuenta.saldo);
                    sc.nextLine();
                    break;

                case 3:
                    System.out.println("Ingrese monto a depositar");
                    double montoDepo = sc.nextInt();
                    cuenta.deposito(montoDepo);
                    System.out.println("Deposito exitoso, su nuevo saldo es de: $" + cuenta.saldo);
                    break;
                case 4:
                    break;

                default:
                    System.out.println("Opcion invalida, intente nuevamente");
                    break;
            }
        }
    }
}
