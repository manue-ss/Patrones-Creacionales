package co.edu.udistrital.operaciones.model;

public class Suma extends Operacion {

    @Override
    public double operar(double numA, double numB) {
        return numA + numB;
    }
}
