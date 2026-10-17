package co.edu.udistrital.operaciones.model;

/**
 *
 * @author Manuel Salazar
 * @version 1
 */
public class Multiplicacion extends Operacion {

    @Override
    public double operar(double numA, double numB) {
        double resultado = 0;
        Suma suma = new Suma();

        for (int i = 0; i < numB; i++) {
            resultado = suma.operar(resultado, numA);
        }

        return resultado;
    }

}
