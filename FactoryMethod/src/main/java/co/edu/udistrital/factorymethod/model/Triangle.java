package co.edu.udistrital.factorymethod.model;

import static java.lang.Math.sqrt;

/**
 *
 * @author Manuel Salazar
 * @version 2
 */
public class Triangle implements IFigure {

    // 1. Uso de camelCase y nombres genéricos para cualquier triángulo
    private final double sideA;
    private final double sideB;
    private final double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        // 2. Validación: Teorema de la desigualdad triangular
        if (!isValidTriangle(sideA, sideB, sideC)) {
            throw new IllegalArgumentException("Las medidas ingresadas no pueden formar un triángulo.");
        }

        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    /**
     * La suma de las longitudes de dos lados cualesquiera de un triángulo
     * siempre debe ser mayor que la longitud del tercer lado.
     */
    private boolean isValidTriangle(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    @Override
    public double getArea() {
        // 3. Fórmula de Herón
        double s = (this.sideA + this.sideB + this.sideC) / 2.0;
        double radicando = s * (s - this.sideA) * (s - this.sideB) * (s - this.sideC);

        return sqrt(radicando);
    }
}
