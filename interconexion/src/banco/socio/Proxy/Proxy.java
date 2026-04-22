package banco.socio.Proxy;

import banco.socio.Banco.Cuenta;
// Corrección: Los imports deberían escribirse al revés: primero los componentes de Java y luego las paquetes del proyecto.
import java.util.ArrayList;

public class Proxy{
    private ArrayList<Cuenta> cuentas;

    public Proxy(ArrayList<Cuenta> listaBanco){
        this.cuentas = listaBanco;
    }

    public Cuenta autenticacion(String nombre, String pass){
        for(Cuenta c : cuentas){ // Sugerencia: La variable de iteración podría tener un nombre más descriptivo, como "cuentaIterada" o "indiceCuenta".
            if (c.nombre.equals(nombre) && c.password.equals(pass))
                return c;
        }
        return null;
    }
}