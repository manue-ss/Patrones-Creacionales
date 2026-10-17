package co.edu.udistrital.operaciones.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArchiveIn extends AbstractIn {
    private Scanner input;

    public ArchiveIn(String rutaArchivo) {
        try {
            this.input = new Scanner(new File(rutaArchivo));
        } catch (FileNotFoundException e) {
            System.err.println("Error crítico: No se encontró el archivo de entrada en " + rutaArchivo);
            this.input = null; 
        }
    }

    @Override
    public String recibir() {
        if (input != null && input.hasNextLine()) {
            return input.nextLine();
        }
        return "0"; 
    }
}