package banco.propio.app.config;

import banco.propio.entidades.*;

public class InicializarDatos {
    public static void cargar() {

        Sucursal s1 = new Sucursal("001", "Centro");
        Sucursal s2 = new Sucursal("002", "Palermo");

        ContextoApp.getServicioCuenta().guardarSucursal(s1);
        ContextoApp.getServicioCuenta().guardarSucursal(s2);

        Usuario u1 = new Usuario("cliente1@mail.com", "1234", Rol.CLIENTE);
        Usuario u2 = new Usuario("cliente2@mail.com", "1234", Rol.CLIENTE);
        Usuario a1 = new Usuario("admin1@mail.com", "admin", Rol.ADMIN);

        ContextoApp.getServicioUsuario().guardar(u1);
        ContextoApp.getServicioUsuario().guardar(u2);
        ContextoApp.getServicioUsuario().guardar(a1);

        Cuenta c1 = Cuenta.builder()
                .id("1")
                .tipo(TipoCuenta.CA)
                .saldo(0)
                .titular(u1)
                .sucursal(s1)
                .build();

        Cuenta c2 = Cuenta.builder()
                .id("2")
                .tipo(TipoCuenta.CC)
                .saldo(0)
                .titular(u2)
                .sucursal(s2)
                .build();

        u1.setCuenta(c1);
        u2.setCuenta(c2);

        s1.agregarCuenta(c1);
        s2.agregarCuenta(c2);

        ContextoApp.getServicioCuenta().guardarCuenta(c1);
        ContextoApp.getServicioCuenta().guardarCuenta(c2);
    }
}