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
        String[] vector = {null,null,null,null,null,null};
        initComponents(vector);
        fProveedor = fNombre_proveedor(vector);
    }
    
    private void initComponents(final String[] vector){
        fProveedor = new JFrame();
        pBotones = new JPanel();
        lblTitulo = new JLabel();
        sptNueva_Compra = new ArrayList<JScrollPane>();
        btnNueva_compra = new JButton();
        btnRegistrar = new JButton();
        tpCompras = new JTabbedPane(JTabbedPane.BOTTOM);
        
        //JLabel's
        lblTitulo.setText("Nueva Compra");
              
        //JTabbedPane
        btnNueva_compra.doClick();
        
        //JButton's
        btnNueva_compra.setText("Nueva compra");
        btnNueva_compra.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnNueva_compraActionPerformed(e, vector);
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
            pBotones.setLayout(new GridLayout(1,2));
            pBotones.add(btnNueva_compra);
            pBotones.add(btnRegistrar);
        /*}*/
        
        
        
    }
    
    private void nuevaCompra (String[] vector){
        //JTable's
        tNueva_compra = new JTable();
        DefaultTableModel modelo = new DefaultTableModel(
        new Object[][]{
                vector
            },
            new String[]{
                "Codigo_P", "Existencia", "Fecha_C", "Cantidad_C", "Precio_C", "Total_C"
            }  
        );
        
        
        tNueva_compra.setModel(modelo);
        //JScrollPane's
        JScrollPane spnewScrollP = new JScrollPane();
        spnewScrollP.setViewportView(tNueva_compra);
        sptNueva_Compra.add(spnewScrollP);
    }
    
    private JFrame fNombre_proveedor (final String[] vector){
        fNombre_proveedor = new JFrame();
        
        JPanel pPrincipal = new JPanel();
        JLabel lblTitulo1 = new JLabel();        
        JTable tProveedor = new JTable();
        JButton btnListo = new JButton();
        JScrollPane spProveedor = new JScrollPane();
        
        final DefaultTableModel dtmProveedor = new DefaultTableModel(
          new Object[][]{
                {null, null}
            },
            new String[]{
                "Codigo_Pro", "Nombre_Pro"
            }    
        );
 
        //JLabel
        lblTitulo1.setText("Nombre de proveedor");
        
        //JTable
        tProveedor.setModel(dtmProveedor);

        //JScrollPane's
        spProveedor.setViewportView(tProveedor);
        
        //JButton's
        btnListo.setText("Listo");
        
        btnListo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnListoActionPerformed(dtmProveedor, vector);
            }
        });

        //JPanel's
        pPrincipal.setLayout(new BorderLayout());
        pPrincipal.add(lblTitulo1, BorderLayout.NORTH);
        pPrincipal.add(spProveedor, BorderLayout.CENTER);
        pPrincipal.add(btnListo, BorderLayout.SOUTH);
        
        fNombre_proveedor.add(pPrincipal);
        fNombre_proveedor.pack();
        
        return fNombre_proveedor;
    }
    
    //Listeners de botones
    private void btnListoActionPerformed(DefaultTableModel dtmProveedor, final String[] vector){
        datos_Proveedor = new String[2];
        datos_Proveedor[0] = dtmProveedor.getValueAt(0, 0)+"";
        datos_Proveedor[1] = dtmProveedor.getValueAt(0, 1)+"";
        JPanel panel = new JPanel();
        btnNueva_fila = new JButton();
        
        btnNueva_fila.setText("+");
        
        final DefaultTableModel modelo = (DefaultTableModel) tNueva_compra.getModel();
        
        btnNueva_fila.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnNueva_FilaActionPerformed(modelo, vector);
            }
        });
        
        panel.setLayout(new BorderLayout());
        panel.add(sptNueva_Compra.get(i),BorderLayout.CENTER);
        panel.add(btnNueva_fila, BorderLayout.SOUTH);
        
        
        tpCompras.addTab(datos_Proveedor[1], panel);
        i++;
        fProveedor.dispose();
        //Se guarda para registrar en base de datos
        
    }
    
    private void btnNueva_FilaActionPerformed(DefaultTableModel modelo, String[] vector){
        modelo.addRow(vector);
    }
    
    private void btnNueva_compraActionPerformed(java.awt.event.ActionEvent evt, String[] vector){
        nuevaCompra(vector);
        fProveedor.setVisible(true);
        fProveedor.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); 
        //Limpiar ventana
    }
    
      
    private int i;
    private String[] datos_Proveedor;
    private JFrame fProveedor;
    private JPanel pBotones;
    
    private JLabel lblTitulo;
    
    private JTable tNueva_compra;
    private ArrayList<JScrollPane> sptNueva_Compra;
    private JButton btnNueva_fila;
    private JButton btnNueva_compra;
    private JButton btnRegistrar;
    private JTabbedPane tpCompras;
    
    private JFrame fNombre_proveedor;
    
}
