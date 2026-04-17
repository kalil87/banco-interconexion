package Banco;
import Builder.BuilderCuenta;
import Builder.Director;
import java.util.ArrayList;

public class Banco {
    public int sucursal;
    public ArrayList<Cuenta> personas = new ArrayList<>();
    Director director = new Director();
    BuilderCuenta builder = new BuilderCuenta();


    public Banco (int sucursal, String nombreAdm, String direcAdm, String passAdm){
        this.sucursal = sucursal;
        director.constructCuentaAdmin(builder, nombreAdm, direcAdm, passAdm);
        Cuenta admin = builder.getCuenta();
        personas.add(admin);
    }

    public void añadirCuenta(Cuenta c){
        personas.add(c);
        System.out.println("Usuario " + c.nombre + " registrado exitosamente");
    }

    public void mostrarBalance(){
        double saldoPersona;
        double saldoTotal = 0;

        if (personas.size()<=1){
            System.out.println("No hay usuarios registrados");
        }
        else{
            for (int i = 0; i < personas.size(); i++) {
                saldoPersona = personas.get(i).saldo;
                saldoTotal += saldoPersona;
            }
            System.out.println("El balance total de la sucursal es de: $" + saldoTotal);
        }
    }
}
