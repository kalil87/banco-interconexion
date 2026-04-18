package banco.socio.Banco;

import banco.socio.paneles.MenuPrincipal;
import banco.socio.Proxy.Proxy;

public class Aplicacion {
    public static void run() {
        Banco banco1 = new Banco(1, "admin", "12", "123");
        Proxy proxy = new Proxy(banco1.personas);
        MenuPrincipal interfazMenu = new MenuPrincipal(banco1, proxy);
        interfazMenu.iniciar();
    }
}
