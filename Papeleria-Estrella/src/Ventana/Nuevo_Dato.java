/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import java.awt.Dimension;
import javax.swing.JFrame;
import Panels_menu_principal.Panel_Nuevos_Datos;

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
    }
    
    private void initComponents() {
        Panel_Nuevos_Datos panel1 = new Panel_Nuevos_Datos(nuevo, ancho, alto);      
       
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        getContentPane().add(panel1.panel);
              
        pack(); 
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(getWidth(), getHeight()));
    }// </editor-fold>                        

    
    /**
     * @param args the command line arguments
     */
    
}
