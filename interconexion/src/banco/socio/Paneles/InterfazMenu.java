package Paneles;
import Banco.Banco;
import Banco.Cuenta;
import Builder.BuilderCuenta;
import Builder.Director;
import Proxy.Proxy;
import java.util.Scanner;


public class InterfazMenu {

    private Banco banco;
    private Proxy proxy;
    private Scanner sc = new Scanner(System.in);
    Director director = new Director();
    BuilderCuenta builder = new BuilderCuenta();
    InterfazCliente interfazCliente = new InterfazCliente();
    InterfazAdmin interfazAdmin = new InterfazAdmin();

    public InterfazMenu (Banco banco, Proxy proxy){
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
    private void imprimirMenu(){

        System.out.println("\\--- APP BANCO ---");
        System.out.println("1. Crear cuenta");
        System.out.println("2. Loguearse");
        System.out.println("3. Salir");
        System.out.println("Seleccione una opción");
    }

    private void opciones(int opcion){
        switch (opcion){
            case 1:

                System.out.println("Ingrese nombre");
                String nombre = sc.nextLine();
                System.out.println("Ingrese direccion");
                String direc = sc.nextLine();
                System.out.println("Ingrese contraseña");
                String pass = sc.nextLine();
                System.out.println("Ingrese tipo de cuenta \\ 1. Ahorro   2. Corriente");
                int optipo = sc.nextInt();

                if (optipo == 1 || optipo == 2){
                    if (optipo == 1){
                        director.constructCuentaAhorro(builder, nombre, direc, pass);
                        Cuenta usuario = builder.getCuenta();
                        banco.añadirCuenta(usuario);
                        System.out.println("Creaste tu cuenta de ahorro con exito.");
                    }
                    else{
                        director.constructCuentaCorriente(builder, nombre, direc, pass);
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

