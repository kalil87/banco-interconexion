package banco.socio.Banco; // Corrección: Debería haber una línea vacía después de la declaración del paquete
import banco.socio.builders.BuilderCuenta;
import banco.socio.builders.Director;
import integracion.interfaz.BancoParticipante;
// Corrección: Los imports deberían escribirse al revés: primero los componentes de Java y luego las paquetes del proyecto.
import java.util.ArrayList;

public class Banco implements BancoParticipante {
    private static Banco instancia;
    public int sucursal;
    public ArrayList<Cuenta> personas = new ArrayList<>();
    Director director = new Director();
    BuilderCuenta builder = new BuilderCuenta();


    private Banco (int sucursal, String nombreAdm, String direcAdm, String passAdm, String cbuAdm){
        this.sucursal = sucursal;
        director.constructCuentaAdmin(builder, nombreAdm, direcAdm, passAdm, cbuAdm);
        Cuenta admin = builder.getCuenta();
        admin.bancoCuenta = this;
        personas.add(admin);
    }
    public static Banco getInstance() {
        if (instancia == null) {
            instancia = new Banco(1, "admin", "dire", "admin", "000");
        }
        return instancia;
    }

    public void añadirCuenta(Cuenta c){ // Corrección: El nombre del parámero de tipo cuenta es vago y poco descriptivo, debería llamarse "cuentaNueva", "cuentaSinRegistrar", etc.
        c.bancoCuenta = this;
        personas.add(c);
        System.out.println("Usuario " + c.nombre + " registrado exitosamente");
    }

    public void mostrarBalance(){
        double saldoPersona;
        double saldoTotal = 0;
        // Corrección: Actualmente, esta línea verifica si hay más de dos personas registradas en el banco, lo cual es erróneo, ya que un método que muestre el balance total del banco debería funcionar aunque solo haya una sola persona. Podría reemplazarse con if (personas.isEmpty()).
        if (personas.size()<=1){
            System.out.println("No hay usuarios registrados");
        }
        else{ // Sugerencia: Este for clásico podría reemplazarse por un for-each, ya que la variable i no cumple ninguna función que no pueda lograrse con el uso de un for-each.
            for (int i = 0; i < personas.size(); i++) {
                saldoPersona = personas.get(i).saldo;
                saldoTotal += saldoPersona;
            }
            System.out.println("El balance total de la sucursal es de: $" + saldoTotal);
        }
    }


    @Override
    public boolean esCuentaValida(String cbu) {
        for (Cuenta c : personas){ // Sugerencia: La variable de iteración podría tener un nombre más descriptivo, como "cuentaIterada" o "indiceCuenta".
            if (c.cbu.equals(cbu))
                return true;
        }
        return false;
    }

    @Override
    public void recibirTransferencia(String cbuDestino, double monto) {
        for (int i = 1 ; i <= personas.size(); i++) { // Sugerencia: Este for clásico podría reemplazarse por un for-each, ya que la variable i no cumple ninguna función que no pueda lograrse con el uso de un for-each.
            Cuenta c = personas.get(i); // Sugerencia: La variable de iteración podría tener un nombre más descriptivo, como "cuentaIterada" o "indiceCuenta".
            if (c.cbu.equals(cbuDestino)) {
                c.saldo += monto;
                return;
            }
        }
    }
}