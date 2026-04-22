package integracion.interfaz;

public interface MediadorBanco {
    void registrarBanco(BancoParticipante banco);
    boolean transferir(String cbuDestino, double monto);
}
