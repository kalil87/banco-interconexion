package banco.propio.app;

import banco.propio.entidades.Rol;
import banco.propio.entidades.Usuario;
import banco.propio.menu.MenuAdmin;
import banco.propio.menu.MenuCliente;
import banco.propio.menu.MenuLogin;
import banco.propio.servicios.*;

public class NavegadorMenus {

    public static void iniciar(
            ServicioUsuario servicioUsuario,
            ServicioCuenta servicioCuenta,
            ServicioTransaccion servicioTransaccion,
            ServicioResumenBanco servicioBanco,
            ServicioSucursal servicioSucursal) {

        Usuario usuario = MenuLogin.iniciar(servicioUsuario);

        if (usuario == null) {
            return;
        }

        if (usuario.getRol() == Rol.ADMIN) {
            MenuAdmin.iniciar(servicioCuenta, servicioUsuario, servicioBanco, servicioSucursal);
        } else if (usuario.getRol() == Rol.CLIENTE) {
            MenuCliente.iniciar(usuario, servicioUsuario, servicioCuenta, servicioTransaccion);
        } else {
            System.out.println("Rol no reconocido");
        }
    }
}