package co.edu.udistrital.factorymethod.controller;

import co.edu.udistrital.factorymethod.model.FigureCreator;
import co.edu.udistrital.factorymethod.view.AbstractIn;
import co.edu.udistrital.factorymethod.view.AbstractOut;
import co.edu.udistrital.factorymethod.view.AbstractViewFactory;
import co.edu.udistrital.factorymethod.model.IFigure;

/**
 *
 * @author Manuel Salazar
 * @version 1
 */
public class Client {

    private AbstractIn entrada = null;
    private AbstractOut salida = null;
    private IFigure figura = null;

    public Client(AbstractViewFactory vista) {
        this.entrada = vista.getIn();
        this.salida = vista.getOut();
    }

    public void show(String st) {
        this.salida.mostrar(st);
    }

    public double nextDouble() {
        double numero;
        while (true) {
            // La lectura debe estar dentro del bucle
            String st = this.entrada.recibir();
            try {
                numero = Double.parseDouble(st);
                break; // Si tiene éxito, rompemos el bucle
            }
            catch (NumberFormatException e) {
                this.show(">>¡Ingrese un Numero valido!");
                // No necesitas 'continue', el bucle volverá a empezar naturalmente
            }
        }
        return numero;
    }

    public void createFigure(FigureCreator creador) {
        try {
            this.figura = creador.createFigure();
        }
        catch(IllegalArgumentException e){
            this.show(e.getMessage());
        }
    }

    public void showArea() {
        if (this.figura != null) {
            this.show("El Area de la figura es: " + this.figura.getArea());
        } else {
            this.show(">>¡Error: La figura aún no ha sido generada!");
        }
    }

}
