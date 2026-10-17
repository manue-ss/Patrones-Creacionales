/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.factorymethod.model;

/**
 *
 * @author Manuel Salazar
 * @version 1
 */
public class TriangleCreator extends FigureCreator {

    private double abyacente;
    private double opuesto;
    private double hipotenusa;

    public TriangleCreator(double abyacente, double opuesto, double hipotenusa) {
        this.abyacente = abyacente;
        this.opuesto = opuesto;
        this.hipotenusa = hipotenusa;
    }

    @Override
    public IFigure createFigure() {
        return new Triangle(abyacente, opuesto, hipotenusa);
    }

}
