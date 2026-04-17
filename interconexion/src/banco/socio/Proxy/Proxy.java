package Proxy;


import Banco.Cuenta;

import java.util.ArrayList;

public class Proxy{
    private ArrayList<Cuenta> cuentas;


    public Proxy(ArrayList<Cuenta> listaBanco){
        this.cuentas = listaBanco;
    }

    public Cuenta autenticacion(String nombre, String pass){
        for(Cuenta c : cuentas){
            if (c.nombre.equals(nombre) && c.password.equals(pass))
                return c;
        }
        return null;
    }
}
