package banco.socio.paneles; // Corrección: Debería haber una línea vacía después de la declaración del paquete
import banco.socio.Banco.Banco;
import banco.socio.Banco.Cuenta;
import banco.socio.builders.BuilderCuenta;
import banco.socio.builders.Director;
import banco.socio.Proxy.Proxy;
import java.util.Scanner;
// Corrección: Los imports deberían escribirse al revés: primero los componentes de Java y luego las paquetes del proyecto.
public class MenuPrincipal {
    private Banco banco; // Sugerencia: La variable debería ser final.
    private Proxy proxy; // Sugerencia: La variable debería ser final.
    private Scanner sc = new Scanner(System.in); // Sugerencia: La variable del Scanner podría tener un nombre más descriptivo, ejemplo "teclado".
    Director director = new Director();
    BuilderCuenta builder = new BuilderCuenta();
    MenuCliente interfazCliente = new MenuCliente();
    MenuAdmin interfazAdmin = new MenuAdmin();

    public MenuPrincipal(Banco banco, Proxy proxy){
        this.banco = banco;
        this.proxy = proxy;
    }

    public void iniciar(){
        int opcion = 0;

        while(opcion != 3){
            imprimirMenu();
            opcion = sc.nextInt();
            sc.nextLine();
            opciones(opcion);
        }
    }
    private void imprimirMenu(){ // Sugerencia: En vez de hacer 5 sout, podrían usar uno solo con la declaración de String multilínea """.

        System.out.println("\\--- APP BANCO ---");
        System.out.println("1. Crear cuenta");
        System.out.println("2. Loguearse");
        System.out.println("3. Salir");
        System.out.println("Seleccione una opción");
    }

    private void opciones(int opcion){
        switch (opcion){
            case 1: // Sugerencia: En vez de hacer 5 sout, podrían usar uno solo con la declaración de String multilínea """.
                System.out.println("Ingrese nombre");
                String nombre = sc.nextLine();
                System.out.println("Ingrese direccion");
                String direc = sc.nextLine();
                System.out.println("Ingrese contraseña");
                String pass = sc.nextLine();
                System.out.println("Ingrese CBU");
                String cbu = sc.nextLine();
                System.out.println("Ingrese tipo de cuenta \\ 1. Ahorro   2. Corriente");
                int optipo = sc.nextInt();

                if (optipo == 1 || optipo == 2){
                    if (optipo == 1){
                        director.constructCuentaAhorro(builder, nombre, direc, pass, cbu);
                        Cuenta usuario = builder.getCuenta();
                        banco.añadirCuenta(usuario);
                        System.out.println("Creaste tu cuenta de ahorro con exito.");
                    }
                    else{
                        director.constructCuentaCorriente(builder, nombre, direc, pass, cbu);
                        Cuenta usuario = builder.getCuenta();
                        banco.añadirCuenta(usuario);
                        System.out.println("Creaste tu cuenta corriente con exito.");
                    }
                }
                else
                    System.out.println("Opcion Incorrecta");
                break;
            case 2:
                System.out.println("Ingrese usuario");
                String usuario = sc.nextLine();
                System.out.println("Ingrese contraseña");
                String password = sc.nextLine();
                Cuenta sesionactual = proxy.autenticacion(usuario, password);

                if (sesionactual != null){
                    switch (sesionactual.rol){
                        case CLIENTE:
                            interfazCliente.panelCliente(sesionactual, banco);
                            break;
                        case ADMIN:
                            interfazAdmin.panelAdmin(sesionactual, banco);
                            break;
                    }
                }
                else
                    System.out.println("Sesion invalida.");
                break;
            case 3:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opcion invalida, intente nuevamente");

        }
    }
}