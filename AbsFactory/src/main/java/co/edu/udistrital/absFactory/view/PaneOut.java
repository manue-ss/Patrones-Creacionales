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
public class PaneOut extends AbstractOut {

    @Override
    public void mostrar(String st) {
        JOptionPane.showMessageDialog(null, st);
    }
    
}
