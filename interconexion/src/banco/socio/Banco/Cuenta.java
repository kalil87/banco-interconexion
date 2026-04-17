package Banco;


public class Cuenta {

    public String nombre;
    public String direccion;
    public String tipoCuenta;
    public String password;
    public double saldo;
    public boolean activo = true;
    public Rol rol;

    public void mostrarInfo(){
        if(activo)
            System.out.println("Nombre: " + nombre + " Direccion-: " + direccion + " Cuenta: " + tipoCuenta + " Saldo: $" + saldo);
        else
            System.out.println("Esta cuenta no se encuentra activa");
    }

    public void tranferir(Cuenta c, int monto){
        if (this.activo && c.activo && this.saldo >=monto ){
            this.saldo -= monto;
            c.saldo += monto;
            System.out.println("Se realizo la transferencia correctamente, saldo actual: $" + this.saldo);
        }
        else
            System.out.println("Saldo insuficiente para realizar esta operación o cuenta inactiva");
    }
}




