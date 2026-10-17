package co.edu.udistrital.operaciones.view;

import java.io.FileWriter;
import java.io.IOException;

public class ArchiveOut extends AbstractOut {
    private FileWriter output;

    public ArchiveOut(String rutaArchivo) {
        try {
            this.output = new FileWriter(rutaArchivo);
        } catch (IOException e) {
            System.err.println("Error crítico: No se pudo inicializar el archivo de salida.");
        }
    }

    @Override
    public void mostrar(String st) {
        try {
            if (output != null) {
                output.write(st + "\n");
                output.flush();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo.");
        }
    }
}