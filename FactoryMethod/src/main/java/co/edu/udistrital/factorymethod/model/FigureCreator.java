package co.edu.udistrital.factorymethod.model;

/**
 * Clase abstracta que define el Factory Method.
 *
 * @author Manuel Salazar
 * @version 2
 */
public abstract class FigureCreator {

    // El Factory Method ahora es abstracto y no recibe parámetros específicos
    public abstract IFigure createFigure();

    // Comportamiento extra (Opcional): La clase padre puede tener lógica 
    // que use el Factory Method.
    public double getArea() {
        IFigure figura = createFigure();

        return figura.getArea();
    }
}
