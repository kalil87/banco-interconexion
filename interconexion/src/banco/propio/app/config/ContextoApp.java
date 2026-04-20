package banco.propio.app.config;

import banco.propio.repositorios.*;
import banco.propio.servicios.*;
import integracion.servicio.RedBancaria;

public class ContextoApp {

        private static final RepositorioCuenta repoC = new RepositorioCuenta();
        private static final RepositorioSucursal repoS = new RepositorioSucursal();
        private static final RepositorioUsuario repoU = new RepositorioUsuario();

        private static final ServicioCuenta servicioCuenta = new ServicioCuenta(repoC, repoS);
        private static final ServicioUsuario servicioUsuario = new ServicioUsuario(repoU);
        private static final ServicioBanco servicioBanco = new ServicioBanco(repoS);
        private static final ServicioSucursal servicioSucursal = new ServicioSucursal(repoS, repoC);
        private static final ServicioTransaccion servicioTransaccion = new ServicioTransaccion(servicioCuenta, RedBancaria.getInstance());

        public static RepositorioCuenta getRepositorioCuenta() {
            return repoC;
        }

        public static RepositorioSucursal getRepositorioSucursal() {
            return repoS;
        }

        public static RepositorioUsuario getRepositorioUsuario() {
            return repoU;
        }

        public static ServicioCuenta getServicioCuenta() {
            return servicioCuenta;
        }

        public static ServicioUsuario getServicioUsuario() {
            return servicioUsuario;
        }

        public static ServicioBanco getServicioBanco() {
            return servicioBanco;
        }

        public static ServicioSucursal getServicioSucursal() {
            return servicioSucursal;
        }

        public static ServicioTransaccion getServicioTransaccion() {
            return servicioTransaccion;
        }
}