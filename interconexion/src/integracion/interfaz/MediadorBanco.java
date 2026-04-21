package integracion.interfaz;

public interface MediadorBanco {
    public void registrarBanco(BancoParticipante banco);
    public boolean transferir(String cbuDestino, double monto);
}
