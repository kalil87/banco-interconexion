package Builder;
import Banco.Cuenta;
import Banco.Rol;

public class BuilderCuenta implements Builder{

    private Cuenta cuenta;

    public BuilderCuenta(){
        this.reset();
    }

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
    public Cuenta getCuenta(){
        Cuenta cuenta = this.cuenta;
        this.reset();
        return cuenta;
    }
}
