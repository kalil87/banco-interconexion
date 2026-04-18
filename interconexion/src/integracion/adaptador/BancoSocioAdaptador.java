package integracion.adaptador;


import banco.socio.Banco.Banco;
import banco.socio.Banco.Cuenta;
import integracion.dto.DatosTransferencia;
import integracion.interfaz.BancoExterno;

public class BancoSocioAdaptador implements BancoExterno {
    private Banco banco;

    public BancoSocioAdaptador(Banco banco){
        this.banco = banco;
    }

    @Override

    public void depositoExterno(DatosTransferencia datosTransferencia) {
        int cbu = datosTransferencia.getNumcuenta();
        double monto = datosTransferencia.getMonto();

        for (Cuenta c : banco.personas){
            if (c.cbu == cbu)
                c.saldo *= monto;
        }
    }
}
