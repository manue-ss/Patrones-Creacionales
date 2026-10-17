package co.edu.udistrital.factorymethod;

import co.edu.udistrital.factorymethod.controller.Client;
import co.edu.udistrital.factorymethod.model.TriangleCreator;
import co.edu.udistrital.factorymethod.view.ConsoleViewFactory;

/**
 *
 * @author Manuel Salazar
 * @version 1
 */
public class TriangleClientTest {

    public static void main(String[] args) {
        Client cliente = new Client(new ConsoleViewFactory());

        cliente.show("Ingrese un Lado del Triangulo:");
        double op = cliente.nextDouble();

        cliente.show("Ingrese el Otro Lado del Triangulo:");
        double ab = cliente.nextDouble();

        cliente.show("Ingrese la Lado del Triangulo:");
        double hip = cliente.nextDouble();

        cliente.createFigure(new TriangleCreator(op, ab, hip));

        cliente.showArea();
    }
}
