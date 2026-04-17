package Banco;

import Paneles.InterfazMenu;
import Proxy.Proxy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Banco banco1 = new Banco(1, "admin", "12", "123");
        Proxy proxy = new Proxy(banco1.personas);
        InterfazMenu interfazMenu = new InterfazMenu(banco1, proxy);
        interfazMenu.iniciar();
    }
}