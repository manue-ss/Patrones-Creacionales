/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.operaciones.view;

import javax.swing.JOptionPane;
/**
 *
 * @author Estudiantes
 */
public class PaneIn extends AbstractIn {

    @Override
    public String recibir() {
        return JOptionPane.showInputDialog("");
    }
    
}
