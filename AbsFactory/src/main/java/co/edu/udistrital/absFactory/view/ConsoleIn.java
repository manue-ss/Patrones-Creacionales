package co.edu.udistrital.operaciones.view;

import java.util.Scanner;

/**
 *
 * @author Manuel Salazar
 * @version 1
 */
public class ConsoleIn extends AbstractIn {

    Scanner sc;

    public ConsoleIn() {
        this.sc = new Scanner(System.in);
    }

    @Override
    public String recibir() {
        return sc.nextLine();
    }
}
