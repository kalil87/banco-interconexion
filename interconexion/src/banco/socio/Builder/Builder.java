package Builder;
import Banco.Rol;

interface Builder{
    void reset();
    void setNombre(String nombre);
    void setDireccion(String direccion);
    void setTipo (String tipo);
    void setRol (Rol rol);
    void setPass (String pass);
}
