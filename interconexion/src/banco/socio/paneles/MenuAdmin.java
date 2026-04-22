package banco.socio.paneles; // Corrección: Debería haber una línea vacía después de la declaración del paquete
import banco.socio.Banco.Banco;
import banco.socio.Banco.Cuenta;
// Corrección: Los imports deberían escribirse al revés: primero los componentes de Java y luego los paquetes del proyecto.
import java.util.Scanner;

public class MenuAdmin {
    public void panelAdmin(Cuenta cuenta, Banco banco){
        // Sugerencia: La variable del Scanner podría tener un nombre más descriptivo, ejemplo "teclado".
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while(opcion != 4){
            // Sugerencia: En vez de hacer 6 sout, podrían usar uno solo con la declaración de String multilínea """.
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
                    Cuenta cSaldo = buscarCuenta(nombreSaldo, banco); // Sugerencia: El nombre de la variable cSaldo es poco descriptiva, debería renombrarse a "cuentaSaldo".
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
    // Corrección: el nombre del parámero de tipo cuenta es vago y poco descriptivo, debería llamarse "cuentaNueva", "cuentaSinRegistrar", etc.
    public void modificarSaldo(Cuenta c, double nuevoSaldo){
        if (c.activo){
            c.saldo = nuevoSaldo;
            System.out.println("Saldo de " + c.nombre + " actualizado a: $" + c.saldo);
        }
        else
            System.out.println("Esta cuenta esta deshabilitada");
    }
    // Corrección: el nombre del parámero de tipo cuenta es vago y poco descriptivo, debería llamarse "cuentaNueva", "cuentaSinRegistrar", etc.
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
        for (Cuenta c : banco.personas) {// Sugerencia: La variable de iteración podría tener un nombre más descriptivo, como "bancoIterado" o "indiceBanco".
            if (c.nombre.equals(nombre)) {
                return c;
            }
        }
        return null;
    }
}