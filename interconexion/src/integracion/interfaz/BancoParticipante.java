package integracion.interfaz;

public interface BancoParticipante {
    boolean esCuentaValida(String cbu);
    void recibirTransferencia(String cbuDestino, double monto);
}