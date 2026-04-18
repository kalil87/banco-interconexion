package integracion.dto;

public class DatosTransferencia {

    private String destinatario;
    private int numCuenta;
    private double monto;

    public DatosTransferencia(int numCuenta, double monto) {
        this.monto = monto;
        this.numCuenta = numCuenta;
    }

    public double getMonto(){
        return monto;
    }

    public int getNumcuenta(){
        return numCuenta;
    }
}

