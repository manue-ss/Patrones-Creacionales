package co.edu.udistrital.operaciones;

import co.edu.udistrital.operaciones.controller.Cliente;
import co.edu.udistrital.operaciones.model.*;
import co.edu.udistrital.operaciones.view.*;

public class Main {

    public static void main(String[] args) {
        
        AbstractViewFactory factorio = new PaneViewFactory(); 
        Operacion operacion = new Suma(); 

        if (args.length > 0) {
            switch (args[0].toLowerCase()) {
                case "consola":
                    factorio = new ConsoleViewFactory();
                    break;
                case "archivo":
                    factorio = new ArchiveViewFactory("src/entrada.txt", "src/salida.txt");
                    break;
                case "panel":
                    factorio = new PaneViewFactory();
                    break;
                default:
                    System.out.println("Vista '" + args[0] + "' no reconocida. Usando Panel por defecto.");
            }
        }

        if (args.length > 1) {
            switch (args[1].toLowerCase()) {
                case "multiplicacion":
                    operacion = new Multiplicacion();
                    break;
                case "suma":
                    operacion = new Suma();
                    break;
                default:
                    System.out.println("Operación '" + args[1] + "' no reconocida. Usando Suma por defecto.");
            }
        }

        Cliente app = new Cliente(factorio, operacion);
        app.ejecutar();
    }
}