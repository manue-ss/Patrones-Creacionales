package co.edu.udistrital.factorymethod.model;

/**
 * Creador concreto para instanciar círculos.
 *
 * @author Manuel Salazar
 * @version 2
 */
public class CircleCreator extends FigureCreator {

    private double radio;

    // Los datos específicos de la figura entran por el constructor del creador
    public CircleCreator(double radio) {
        this.radio = radio;
    }

    @Override
    public IFigure createFigure() {
        return new Circle(this.radio);
    }
}
