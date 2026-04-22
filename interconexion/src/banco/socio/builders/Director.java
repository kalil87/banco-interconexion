package banco.socio.builders; // Corrección: Debería haber una línea vacía después de la declaración del paquete
import banco.socio.Banco.Rol;
// Sugerencia: Para todos los métodos de construct...(), debería optarse por escribir el método entero o en Español, o en Inglés.
public class Director {
    public void constructCuentaAhorro(BuilderCuenta builder, String nombre, String direccion, String pass, String cbu){
        builder.reset();
        builder.setNombre(nombre);
        builder.setDireccion(direccion);
        builder.setTipo("Ahorro");
        builder.setRol(Rol.CLIENTE);
        builder.setPass(pass);
        builder.setCbu(cbu);
    }

    public void constructCuentaCorriente(BuilderCuenta builder, String nombre, String direccion, String pass, String cbu){
        builder.reset();
        builder.setNombre(nombre);
        builder.setDireccion(direccion);
        builder.setTipo("Corriente");
        builder.setRol(Rol.CLIENTE);
        builder.setPass(pass);
        builder.setCbu(cbu);
    }

    public void constructCuentaAdmin(BuilderCuenta builder, String nombre, String direccion, String pass, String cbu){
        builder.reset();
        builder.setNombre(nombre);
        builder.setDireccion(direccion);
        builder.setRol(Rol.ADMIN);
        builder.setPass(pass);
        builder.setCbu(cbu);
    }

}