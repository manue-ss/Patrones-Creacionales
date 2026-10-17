/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package co.edu.udistrital.singleton.model;

/**
 *
 * @author Manuel Salazar
 * @version 1
 */
public class CajeroAutomaticoS {
    
    private static CajeroAutomaticoS unicaInstancia;
    private final int numeroSerie;

    private CajeroAutomaticoS() {
        this.numeroSerie = (int) (Math.random() * 10000);
    }

    public static CajeroAutomaticoS getInstance() {
        if (unicaInstancia == null) {
            unicaInstancia = new CajeroAutomaticoS();
        }
        return unicaInstancia;
    }

    public int getNumeroSerie() {
        return numeroSerie;
    }

    
}
