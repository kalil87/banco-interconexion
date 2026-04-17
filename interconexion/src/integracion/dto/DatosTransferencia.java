package integracion.dto;

public class DatosTransferencia {

    private String destinatario;
    private int numCuenta;
    private double monto;

    public DatosTransferencia(String destinatario, int numCuenta, double monto) {
        this.destinatario = destinatario;
        this.monto = monto;
        this.numCuenta = numCuenta;
    }

    public String getDestinatario(){
        return destinatario;
    }

    public double getMonto(){
        return monto;
    }

    public int getNumcuenta(){
        return numCuenta;
    }
}

