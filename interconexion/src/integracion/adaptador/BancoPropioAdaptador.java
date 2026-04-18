package integracion.adaptador;

import banco.socio.Banco.Cuenta;
import integracion.dto.DatosTransferencia;
import integracion.interfaz.BancoExterno;

public class BancoPropioAdaptador implements BancoExterno {
    Cuenta cuenta;

    public BancoPropioAdaptador(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void depositoExterno(DatosTransferencia datosTransferencia) {

    }

    @Override
    public void recibirDepositoExterno(DatosTransferencia datosTransferencia) {

    }
}