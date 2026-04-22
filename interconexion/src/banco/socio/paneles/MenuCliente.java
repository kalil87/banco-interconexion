package banco.socio.paneles; // Corrección: Debería haber una línea vacía después de la declaración del paquete
import banco.socio.Banco.Cuenta;
import banco.socio.Banco.Banco;
import java.util.Scanner;
// Corrección: Los imports deberían escribirse al revés: primero los componentes de Java y luego las paquetes del proyecto.
public class MenuCliente {
    public void panelCliente(Cuenta cuenta, Banco banco){
        Scanner sc = new Scanner(System.in); // Sugerencia: La variable del Scanner podría tener un nombre más descriptivo, ejemplo "teclado".

        int opcion = 0;

        while(opcion != 4){
            // Sugerencia: En vez de hacer 6 sout, podrían usar uno solo con la declaración de String multilínea """.
            System.out.println("¡Bienvenido " + cuenta.nombre + " a la sucursal " + banco.sucursal);
            System.out.println("1. Tranferir");
            System.out.println("2. Consultar saldo de la cuenta");
            System.out.println("3. Depositar");
            System.out.println("4. Salir");
            System.out.println("Seleccione una opción");
            opcion = sc.nextInt(); //nextInt sin validación de int

            switch (opcion){
                case 1:
                    String cbu;
                    int monto;

                    System.out.println("Ingrese el monto a transferir");
                    monto = sc.nextInt(); //nextInt sin validación de int
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
                    double montoDepo = sc.nextInt(); //nextInt sin validación de int //también se podría usar nextDouble
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