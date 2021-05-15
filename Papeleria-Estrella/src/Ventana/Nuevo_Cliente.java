/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import javax.swing.JFrame;

/**
 *
 * @author Eduardo Elias Hernandez Moreno
 */
public class Nuevo_Cliente extends JFrame{
    
    public Nuevo_Cliente (){
    
    
    }
    
    public static void main(String[] args){
        Nuevo_Cliente ventana = new Nuevo_Cliente();
        ventana.setVisible(true);
        
        //ventana se crea en el centro de la pantalla
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        ventana.setBounds((ancho/2) - (ventana.getWidth()/2), (alto/2) - (ventana.getHeight()/2), 500, 500);
    }
    
    private void initComponents (){
    
    
    }
}
