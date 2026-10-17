package co.edu.udistrital.operaciones.controller;

import co.edu.udistrital.operaciones.model.Operacion;
import co.edu.udistrital.operaciones.view.AbstractIn;
import co.edu.udistrital.operaciones.view.AbstractOut;
import co.edu.udistrital.operaciones.view.AbstractViewFactory;

public class Cliente {

    private final AbstractIn in;
    private final AbstractOut out;
    private final Operacion operacion;

    public Cliente(AbstractViewFactory factorio, Operacion operacion) {
        this.in = factorio.getIn();
        this.out = factorio.getOut();
        this.operacion = operacion;
    }

    public void ejecutar() {
        double numA = solicitarNumeroValido("Ingrese numero a: ");
        out.mostrar(">> " + numA);
        
        double numB = solicitarNumeroValido("Ingrese numero b: ");
        out.mostrar(">> " + numB);

        double res = operacion.operar(numA, numB);

        out.mostrar("El resultado de la operación es: " + res);
    }

    private double solicitarNumeroValido(String mensaje) {
        while (true) {
            out.mostrar(mensaje);
            String entrada = in.recibir();

            if (entrada == null) {
                out.mostrar(">> Error: No hay más datos");
                continue;
            }

            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                out.mostrar(">> Error: '" + entrada + "' no es un numero valido. Intente de nuevo...");
            }
        }
    }
}