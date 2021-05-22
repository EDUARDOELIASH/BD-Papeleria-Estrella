/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels_menu_principal;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eduardo Elias Hernandez Moreno
 */
public class Panel_Nueva_Compra extends JPanel{
    public Panel_Nueva_Compra (){
        i = 0;
        initComponents();
    }
    
    private void initComponents(){
        pBotones = new JPanel();
        lblTitulo = new JLabel();
        sptNueva_Compra = new ArrayList<JScrollPane>();
        btnNueva_fila = new JButton();
        btnNueva_compra = new JButton();
        btnRegistrar = new JButton();
        tpCompras = new JTabbedPane(JTabbedPane.BOTTOM);
        dtmNueva_Compra = new javax.swing.table.DefaultTableModel(
            new Object[][]{
                {null, null, null, null, null, null}
            },
            new String[]{
                "Codigo_P", "Existencia", "Fecha_C", "Cantidad_C", "Precio_C", "Total_C"
            }    
        );
        
        //JLabel's
        lblTitulo.setText("Nueva Compra");
              
        //JTabbedPane
        btnNueva_compra.doClick();
        
        //JButton's
        btnNueva_fila.setText("Nueva fila");
        btnNueva_compra.setText("Nueva compra");
        btnNueva_compra.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnNueva_compraActionPerformed(e, dtmNueva_Compra);
            }
        });
        
        btnRegistrar.setText("Registrar compra");
        
        //JPanel's
        /*Contenido de panel principal*/
        setLayout(new BorderLayout());
        add(lblTitulo, BorderLayout.NORTH);
        add(tpCompras, BorderLayout.CENTER);
        add(pBotones, BorderLayout.SOUTH);
        /*{*/
            /*Contenido pBotones*/
            pBotones.setLayout(new GridLayout(1,3));
            pBotones.add(btnNueva_fila);
            pBotones.add(btnNueva_compra);
            pBotones.add(btnRegistrar);
        /*}*/
        
        
        
    }
    
    private void nuevaCompra(DefaultTableModel dtmNueva_Compra){
        //JTable's
        tNueva_compra = new JTable();
        tNueva_compra.setModel(dtmNueva_Compra);
        
        //JScrollPane's
        JScrollPane spnewScrollP = new JScrollPane();
        spnewScrollP.setViewportView(tNueva_compra);
        sptNueva_Compra.add(spnewScrollP);
    }
    
    private void fNombre_proveedor (){
        fNombre_proveedor = new JFrame();
        fNombre_proveedor.setLayout(new BorderLayout());
        JLabel
    }
    
    //Listeners de botones
    private void btnNueva_compraActionPerformed(java.awt.event.ActionEvent evt, DefaultTableModel dtmNueva_Compra){
        nuevaCompra(dtmNueva_Compra);
        tpCompras.addTab("Proveedor", sptNueva_Compra.get(i));
        i++;
    }
    
    
      
    private int i;
    private JPanel pBotones;
    
    private JLabel lblTitulo;
    
    private javax.swing.table.DefaultTableModel dtmNueva_Compra;
    private JTable tNueva_compra;
    private ArrayList<JScrollPane> sptNueva_Compra;
    private JButton btnNueva_fila;
    private JButton btnNueva_compra;
    private JButton btnRegistrar;
    private JTabbedPane tpCompras;
    
    private JFrame fNombre_proveedor;
    
}
