package co.edu.udistrital.factorymethod.model;

/**
 *
 * @author Manuel Salazar
 * @version 1
 */
public class Rectangle implements IFigure {

    private final double BASE;
    private final double ALTURA;

    public Rectangle(double BASE, double ALTURA) {
        this.BASE = BASE;
        this.ALTURA = ALTURA;
    }

    public Rectangle() {
        this.BASE = 0;
        this.ALTURA = 0;
    }

    @Override
    public double getArea() {
        return this.BASE * this.ALTURA;
    }

}
