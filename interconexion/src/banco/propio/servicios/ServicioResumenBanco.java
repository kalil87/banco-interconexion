package banco.propio.servicios;

import banco.propio.entidades.Sucursal;
import banco.propio.repositorios.RepositorioSucursal;

public class ServicioResumenBanco {
    private RepositorioSucursal repoSucursal;

    public ServicioResumenBanco(RepositorioSucursal repoSucursal) {
        this.repoSucursal = repoSucursal;
    }

    public double balanceGlobal() {
        return repoSucursal.obtenerTodas().stream()
                .flatMap(s -> s.getCuentas().stream())
                .mapToDouble(c -> c.getSaldo())
                .sum();
    }

    public double balancePorSucursal(String numero) {
        Sucursal sucursal = repoSucursal.buscarPorId(numero);

        if (sucursal == null) {
            throw new RuntimeException("Sucursal no válida");
        }

        return sucursal.getCuentas().stream()
                .mapToDouble(c -> c.getSaldo())
                .sum();
    }
}