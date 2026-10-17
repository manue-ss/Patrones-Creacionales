package co.edu.udistrital.factorymethod.model;

import static java.lang.Math.pow;

/**
 *
 * @author Manuel Salazar
 * @version 1
 */
public class Circle implements IFigure {

    private double radio;

    public Circle(double radio) {
        this.radio = radio;
    }

    @Override
    public double getArea() {
        return pow(this.radio, 2) * Math.PI;
    }

}
