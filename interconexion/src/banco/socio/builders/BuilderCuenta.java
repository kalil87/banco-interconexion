package banco.socio.builders; // Corrección: Debería haber una línea vacía después de la declaración del paquete
import banco.socio.Banco.Banco;
import banco.socio.Banco.Cuenta;
import banco.socio.Banco.Rol;
import banco.socio.interfaces.Builder;

public class BuilderCuenta implements Builder {
    private Cuenta cuenta;

    public BuilderCuenta(){
        this.reset();
    }
    //Sugerencia: Los métodos están muy desordenados y comprimidos. Sugiero que se separen con una línea vacía, y que se declaren primero los gettes y luego los setters.
    public void reset(){
        this.cuenta = new Cuenta();
    }
    public void setNombre (String nombre){
        this.cuenta.nombre = nombre;
    }
    public void setDireccion (String direccion){
        this.cuenta.direccion = direccion;
    }
    public void setTipo (String tipo){
        this.cuenta.tipoCuenta = tipo;
    }
    public void setRol (Rol rol){
        this.cuenta.rol = rol;
    }
    public void setPass (String pass){
        this.cuenta.password = pass;
    }
    public void setCbu (String cbu) {this.cuenta.cbu = cbu;}
    public void setBanco (Banco banco) {this.cuenta.bancoCuenta = banco;}
    public Cuenta getCuenta(){
        Cuenta cuenta = this.cuenta;
        this.reset();
        return cuenta;
    }
}