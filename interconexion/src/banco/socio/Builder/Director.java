package Builder;
import Banco.Rol;


public class Director {
    public void constructCuentaAhorro(Builder builder, String nombre, String direccion, String pass){
        builder.reset();
        builder.setNombre(nombre);
        builder.setDireccion(direccion);
        builder.setTipo("Ahorro");
        builder.setRol(Rol.CLIENTE);
        builder.setPass(pass);
    }

    public void constructCuentaCorriente(Builder builder, String nombre, String direccion, String pass){
        builder.reset();
        builder.setNombre(nombre);
        builder.setDireccion(direccion);
        builder.setTipo("Corriente");
        builder.setRol(Rol.CLIENTE);
        builder.setPass(pass);
    }

    public void constructCuentaAdmin(Builder builder, String nombre, String direccion, String pass){
        builder.reset();
        builder.setNombre(nombre);
        builder.setDireccion(direccion);
        builder.setRol(Rol.ADMIN);
        builder.setPass(pass);
    }

}
