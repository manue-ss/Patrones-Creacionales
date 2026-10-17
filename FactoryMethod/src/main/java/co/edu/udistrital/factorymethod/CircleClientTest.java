package co.edu.udistrital.factorymethod;

import co.edu.udistrital.factorymethod.controller.Client;
import co.edu.udistrital.factorymethod.model.CircleCreator;
import co.edu.udistrital.factorymethod.view.ConsoleViewFactory;

/**
 *
 * @author Manuel Salazar
 * @version 1
 */
public class CircleClientTest {

    public static void main(String[] args) {
        Client cliente = new Client(new ConsoleViewFactory());

        cliente.show("Ingrese el radio de la Circunferencia:");
        double radio = cliente.nextDouble();

        cliente.createFigure(new CircleCreator(radio));

        cliente.showArea();
    }

}
