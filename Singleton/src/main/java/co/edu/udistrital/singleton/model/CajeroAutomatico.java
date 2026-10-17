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
public class CajeroAutomatico {

    private final int numeroSerie;

    public CajeroAutomatico() {

        this.numeroSerie = (int) (Math.random() * 10000);
    }

    public int getNumeroSerie() {
        return numeroSerie;
    }

}
