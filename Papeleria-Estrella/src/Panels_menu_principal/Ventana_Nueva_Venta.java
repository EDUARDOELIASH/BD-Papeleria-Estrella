/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels_menu_principal;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author felix
 */
public class Ventana_Nueva_Venta {
    public static void main(String[] args){
        
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Panel_Nueva_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Panel_Nueva_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Panel_Nueva_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Panel_Nueva_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                JFrame ventana = new JFrame();
                Panel_Nueva_Venta panel = new Panel_Nueva_Venta();
                                
                ventana.getContentPane().add(panel);
                ventana.pack();
                ventana.setVisible(true);
                ventana.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                
                int anchoPantalla = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
                int altoPantalla = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
                int anchoVentana = 600;
                int altoVentana = 600;       
                
                ventana.setBounds((anchoPantalla/2) - (ventana.getWidth()/2), (altoPantalla/2) - (ventana.getHeight()/2), anchoVentana, altoVentana);
                ventana.setMinimumSize(new Dimension(anchoVentana, altoVentana));
            }
        });
    }
    
}
