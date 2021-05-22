/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author felix
 */
public class Nuevo_Dato extends JFrame{
    private final static int ancho = 400;
    private final static int alto = 250;
    private String nuevo;
    
    public Nuevo_Dato (String nuevo){
        this.nuevo = nuevo; 
        initComponents();
        
        //Se localiza ventana enmedio
        int ancho1 = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto1 = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        setLocation((ancho1/2) - (getWidth()/2), (alto1/2) - (getHeight()/2));
        setMinimumSize(new Dimension(getWidth(), getHeight()));
    }
    
    private void initComponents() {
        PNuevos_Datos panel1 = new PNuevos_Datos(nuevo, ancho, alto);      
       
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        getContentPane().add(panel1.panel);
        
        pack(); 
    }// </editor-fold>                        

    
    /**
     * @param args the command line arguments
     */
    
}
