package co.edu.udistrital.singleton.view;

import java.util.Scanner;

/**
 *
 * @author Manuel Salazar
 * @version 1
 */
public class ConsoleIn implements AbstractIn {

    Scanner sc;

    public ConsoleIn() {
        this.sc = new Scanner(System.in);
    }

    @Override
    public double getDouble() {
        return Double.parseDouble(this.getString());
    }

    @Override
    public int getInt() {
        return Integer.parseInt(this.getString());
    }

    @Override
    public String getString() {
        if (sc.hasNext()) {
            return sc.nextLine();
        }
        return null;
    }
}
