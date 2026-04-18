package banco.socio.Banco;
import integracion.servicio.RedBancaria;

public class Cuenta {

    public String nombre;
    public String direccion;
    public String tipoCuenta;
    public String password;
    public double saldo;
    public boolean activo = true;
    public Rol rol;
    public int cbu;

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

    private void transferenciaExterna(int cbuDestino, double monto) {
        try {

            RedBancaria.getInstance().transferir(String.valueOf(this.cbu), String.valueOf(cbuDestino), monto);
            this.saldo -= monto;
            System.out.println("Transferencia enviada. Su saldo actual es de: $" + this.saldo);

        } catch (RuntimeException e) {
            System.out.println("Error red bancaria: " + e.getMessage());
        }
    }


    public void deposito(double monto){
        if (monto >= 0){
            saldo +=monto;
            System.out.println("Deposito exitoso");
        }
        else
            System.out.println("lol");
    }
}




