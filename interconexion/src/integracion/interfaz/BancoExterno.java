package integracion.interfaz;

import integracion.dto.DatosTransferencia;

public interface BancoExterno {
    void depositoExterno(DatosTransferencia datosTransferencia);
}
