package integracion.interfaz;

public interface BancoParticipante {

    boolean existeCuenta(String cbu);

    void recibirTransferencia(String cbuDestino, double monto);
}