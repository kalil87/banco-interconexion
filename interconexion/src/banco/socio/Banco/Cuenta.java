package banco.socio.Banco; // Corrección: Debería haber una línea vacía después de la declaración del paquete
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

    public void mostrarInfo() { // Corrección: Este método solo muestra datos por consola, por lo que debería estar por fuera de la clase, que encapsula la lógica, o, alternativamente, transformarse en un método toString().
        if (activo)
            System.out.println("Nombre: " + nombre + " Direccion-: " + direccion + " Cuenta: " + tipoCuenta + " Saldo: $" + saldo);
        else
            System.out.println("Esta cuenta no se encuentra activa");
    }

    // Sugerencia: En vez de hacer return y no devolver nada, el método podría devolver un booleano que indique si se pudo o no completar la operación, y luego pasárselo por parámetro a un método que imprima mensajes de éxito o error, para liberar a la clase de líneas que muestren datos por consola y respetar el encapsulamiento.
    public void tranferir(String cbu, int monto) {

        boolean cuentaLocal = bancoCuenta.esCuentaValida(cbu);

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
                if (c.cbu.equals(cbu)) { // Sugerencia: La variable de iteración podría tener un nombre más descriptivo, como "cuentaIterada" o "indiceCuenta".
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
            // Sugerencia: La variable ok tiene un nombre poco descriptivo, podría mejorarse si se llamara "transferenciaValida".
            boolean ok = RedBancaria.getInstance().transferir(cbu, monto);
            if (ok) {
                this.saldo -= monto;
                System.out.println("Transferencia enviada. Su saldo actual es de: $" + this.saldo);

            } else
                System.out.println("Cuenta no encontrada");


        } catch (RuntimeException e) {
            System.out.println("Error red bancaria: " + e.getMessage());
        }
    }


    public void deposito(double monto) {
        if (monto >= 0) {
            saldo += monto;
            System.out.println("Deposito exitoso");
        } else {
            System.out.println("lol"); // Corrección: Mensaje de error poco descriptivo. Podría mejorarse, como por ejemplo "Depósito fallido".
        }
    }
}