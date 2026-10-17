package co.edu.udistrital.factorymethod;

import co.edu.udistrital.factorymethod.controller.Client;
import co.edu.udistrital.factorymethod.model.RectangleCreator;
import co.edu.udistrital.factorymethod.view.ConsoleViewFactory;

/**
 *
 * @author Manuel Salazar
 * @version 1
 */
public class RectangleClientTest {

    public static void main(String[] args) {
        Client cliente = new Client(new ConsoleViewFactory());

        cliente.show("Ingrese la Base del Rectangulo:");
        double base = cliente.nextDouble();

        cliente.show("Ingrese la Altura del Rectangulo:");
        double altura = cliente.nextDouble();

        cliente.createFigure(new RectangleCreator(base, altura));

        cliente.showArea();
    }
}
