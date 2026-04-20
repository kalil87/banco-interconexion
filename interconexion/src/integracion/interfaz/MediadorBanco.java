package integracion.interfaz;

public interface MediadorBanco {

    boolean existeCuenta(String cbu);

    void recibirTransferencia(String cbuDestino, double monto);
}