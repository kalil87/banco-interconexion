package banco.socio.Banco;

import banco.socio.paneles.MenuPrincipal;
import banco.socio.Proxy.Proxy;

public class Main {
    public static void main(String[] args) {

        Banco banco1 = Banco.getInstance();
        Proxy proxy = new Proxy(banco1.personas);
        MenuPrincipal interfazMenu = new MenuPrincipal(banco1, proxy);
        interfazMenu.iniciar();
    }
}