package banco.socio.interfaces; // Corrección: Debería haber una línea vacía después de la declaración del paquete
import banco.socio.Banco.Rol;
//Sugerencia: Los métodos están muy desordenados y comprimidos. Sugiero que se separen con una línea vacía.
public interface Builder{
    void reset();
    void setNombre(String nombre);
    void setDireccion(String direccion);
    void setTipo (String tipo);
    void setRol (Rol rol);
    void setPass (String pass);
}