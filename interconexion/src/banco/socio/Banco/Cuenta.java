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
    public String cbu;
    public Banco bancoCuenta;

    public void mostrarInfo(){
        if(activo)
            System.out.println("Nombre: " + nombre + " Direccion-: " + direccion + " Cuenta: " + tipoCuenta + " Saldo: $" + saldo);
        else
            System.out.println("Esta cuenta no se encuentra activa");
    }

    public void tranferir(String cbu, int monto) {

        boolean cuentaLocal = bancoCuenta.existeCuenta(cbu);

        if (!this.activo) {
            System.out.println("Tu cuenta está inhabilitada.");
            return;
        }
        if (this.saldo < monto) {
            System.out.println("Saldo insuficiente.");
            return;
        }

        if (cuentaLocal) {
            this.saldo -= monto;
            for (Cuenta c : bancoCuenta.personas) {
                if (c.cbu.equals(cbu)) {
                    c.saldo += monto;
                    System.out.println("Se realizo la transferencia correctamente, saldo actual: $" + this.saldo);
                    break;
                }
            }
        } else {
            transferenciaExterna(cbu, monto);
        }
    }
    private void transferenciaExterna(String cbu, double monto) {
        try {

            RedBancaria.getInstance().transferir(cbu, monto);
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




