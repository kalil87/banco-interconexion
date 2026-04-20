package banco.socio.Banco;
import banco.socio.builders.BuilderCuenta;
import banco.socio.builders.Director;
import integracion.interfaz.MediadorBanco;
import integracion.servicio.RedBancaria;

import java.util.ArrayList;

public class Banco implements MediadorBanco {
    private static Banco instancia;
    public int sucursal;
    public ArrayList<Cuenta> personas = new ArrayList<>();
    Director director = new Director();
    BuilderCuenta builder = new BuilderCuenta();


    private Banco (int sucursal, String nombreAdm, String direcAdm, String passAdm, String cbuAdm){
        this.sucursal = sucursal;
        director.constructCuentaAdmin(builder, nombreAdm, direcAdm, passAdm, cbuAdm);
        Cuenta admin = builder.getCuenta();
        admin.bancoCuenta = this;
        personas.add(admin);
    }
    public static Banco getInstance() {
        if (instancia == null) {
            instancia = new Banco(1, "admin", "dire", "admin", "000");
        }
        return instancia;
    }

    public void añadirCuenta(Cuenta c){
        c.bancoCuenta = this;
        personas.add(c);
        System.out.println("Usuario " + c.nombre + " registrado exitosamente");
    }

    public void mostrarBalance(){
        double saldoPersona;
        double saldoTotal = 0;

        if (personas.size()<=1){
            System.out.println("No hay usuarios registrados");
        }
        else{
            for (int i = 0; i < personas.size(); i++) {
                saldoPersona = personas.get(i).saldo;
                saldoTotal += saldoPersona;
            }
            System.out.println("El balance total de la sucursal es de: $" + saldoTotal);
        }
    }


    @Override
    public boolean existeCuenta(String cbu) {
        for (Cuenta c : personas){
            if (c.cbu.equals(cbu))
                return true;
        }
        return false;
    }

    @Override
    public void recibirTransferencia(String cbuDestino, double monto) {
        for (Cuenta c : personas) {
            if (c.cbu.equals(cbuDestino)) {
                c.saldo += monto;
                System.out.println("Se realizo la transferencia correctamente.");
                break;
            }
            else {
                System.out.println("Cuenta no encontrada");
            }
        }
    }



}
