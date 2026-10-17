package co.edu.udistrital.builder.controller;

import co.edu.udistrital.builder.modelo.*;
import co.edu.udistrital.builder.view.AbstractIn;
import co.edu.udistrital.builder.view.AbstractOut;
import co.edu.udistrital.builder.view.AbstractViewFactory;
import java.io.IOException;

/**
 * Cliente Orquestador que oculta la complejidad del Patrón Builder de I/O
 *
 * @author Manuel Salazar
 */
public class Client {

    private DirectorIO director;
    private MyBufferedReader lector;
    private MyBufferedWriter escritor;
    private AbstractIn entrada;
    private AbstractOut salida;

    public Client(DirectorIO director, AbstractViewFactory viewFacto) {
        this.director = director;
        this.entrada = viewFacto.getIn();
        this.salida = viewFacto.getOut();
    }

    public void configureReader(ReaderBuilder builder) {
        try {
            this.director.buildStandardReader(builder);
            this.lector = builder.getResult();
        }
        catch (Exception e) {
            this.salida.showError(">> Error al configurar el lector: "
                    + e.getMessage());
        }
    }

    public void configureWriter(WriterBuilder builder) {
        try {
            this.director.buildStandardWriter(builder);
            this.escritor = builder.getResult();
        }
        catch (Exception e) {
            this.salida.showError(">> Error al configurar el escritor: "
                    + e.getMessage());
        }
    }

    public String nextLine() {
        if (this.lector == null) {
            this.salida.showError(">> ¡Error: El lector no ha sido configurado!");
            return null;
        }
        try {
            return this.lector.nextLine();
        }
        catch (IOException e) {
            this.salida.showError(">> Error de lectura: " + e.getMessage());
            return null;
        }
    }

    public void writeLine(String st) {
        if (this.escritor == null) {
            this.salida.showError(">> ¡Error: El escritor no ha sido configurado!");
            return;
        }
        try {
            this.escritor.write(st);
            this.escritor.newLine();
        }
        catch (IOException e) {
            this.salida.showError(">> Error de escritura: " + e.getMessage());
        }
    }

    public void closeStreams() {
        try {
            if (this.lector != null) {
                this.lector.close();
            }
            this.salida.show(">> Conexiones de lectura cerradas correctamente.");
        }
        catch (IOException e) {
            this.salida.showError(">> Error al cerrar flujo de lectura: "
                    + e.getMessage());
        }
        
        try {
            if (this.escritor != null) {
                this.escritor.close();
            }
            this.salida.show(">> Conexiones de escritura cerradas correctamente.");
        }
        catch (IOException e) {
            this.salida.showError(">> Error al cerrar flujo de escritura: "
                    + e.getMessage());
        }
    }

    public void printLn(String st) {
        this.salida.show(st);
    }
    
    public void printErr(String e) {
        this.salida.showError(e);
    }

    public String readConsoleInput() {
        return this.entrada.getString();
    }
}
