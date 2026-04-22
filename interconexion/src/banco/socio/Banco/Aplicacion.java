package banco.socio.Banco;

import banco.socio.paneles.MenuPrincipal;
import banco.socio.Proxy.Proxy;

public class Aplicacion {
    public static void run() {
        Banco banco1 = Banco.getInstance(); // Sugerencia: El nombre de la variable banco no debería llamarse "banco1" si no hay más de un banco. En su lugar, podría llamarse "bancoNuevo", "bancoEjecutado", "bancoPrueba", etc.
        Proxy proxy = new Proxy(banco1.personas); // Sugerencia: El nombre de la variable proxy podría ser más específico, como "proxyNuevo", "proxyPrueba", etc.
        MenuPrincipal interfazMenu = new MenuPrincipal(banco1, proxy);
        interfazMenu.iniciar();
    }
}