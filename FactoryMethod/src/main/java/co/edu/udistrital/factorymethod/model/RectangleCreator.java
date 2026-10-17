package co.edu.udistrital.factorymethod.model;

/**
 *
 * @author Manuel Salazar
 * @version 1
 */
public class RectangleCreator extends FigureCreator {

    private double base;
    private double altura;

    public RectangleCreator(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public IFigure createFigure() {
        return new Rectangle(base, altura);
    }

}
