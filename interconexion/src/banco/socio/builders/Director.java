package banco.socio.builders;
import banco.socio.Banco.Rol;



public class Director {
    public void constructCuentaAhorro(BuilderCuenta builder, String nombre, String direccion, String pass, int cbu){
        builder.reset();
        builder.setNombre(nombre);
        builder.setDireccion(direccion);
        builder.setTipo("Ahorro");
        builder.setRol(Rol.CLIENTE);
        builder.setPass(pass);
        builder.setCbu(cbu);
    }

    public void constructCuentaCorriente(BuilderCuenta builder, String nombre, String direccion, String pass, int cbu){
        builder.reset();
        builder.setNombre(nombre);
        builder.setDireccion(direccion);
        builder.setTipo("Corriente");
        builder.setRol(Rol.CLIENTE);
        builder.setPass(pass);
        builder.setCbu(cbu);
    }

    public void constructCuentaAdmin(BuilderCuenta builder, String nombre, String direccion, String pass){
        builder.reset();
        builder.setNombre(nombre);
        builder.setDireccion(direccion);
        builder.setRol(Rol.ADMIN);
        builder.setPass(pass);
    }

}
