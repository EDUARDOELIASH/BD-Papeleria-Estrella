/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Eduardo Elias Hernandez Moreno
 */
public class PNuevos_Datos{
    protected JPanel panel;
    
    public PNuevos_Datos (String nombre_Panel, int ancho, int alto){   
        if (nombre_Panel.equals("Nuevo_Producto")){
            PNuevo_Producto panel1 = new PNuevo_Producto();
            panel1.add(panel1.pPrincipal);
            agregarPanel(panel1);
        }
        else{
            if (nombre_Panel.equals("Nuevo_Servicio")){
                PNuevo_Servicio panel1 = new PNuevo_Servicio(); 
                panel1.add(panel1.pPrincipal);
                agregarPanel(panel1);
            }
            else{
                if (nombre_Panel.equals("Nuevo_Cliente")){
                    PNuevo_Cliente panel1 = new PNuevo_Cliente();
                    panel1.add(panel1.pPrincipal);
                    agregarPanel(panel1);
                }
                else {
                    if (nombre_Panel.equals("Nuevo_Proveedor")){
                       PNuevo_Proveedor panel1 = new PNuevo_Proveedor();
                       panel1.add(panel1.pPrincipal);
                       agregarPanel(panel1);
                    }
                }
            }   
        }
        panel.setSize(ancho, alto);
    }
    
    private class PNuevo_Producto extends JPanel{
        public PNuevo_Producto (){
            initComponents();
        }
        
        private void initComponents() {
            pPrincipal = new JPanel();
            lblTitulo = new JLabel();
            pSur = new JPanel();
            jScrollPane1 = new javax.swing.JScrollPane();
            tNuevo_Producto = new javax.swing.JTable();
            lblEspacio1 = new JLabel();
            lblEspacio2 = new JLabel();
            btnListo = new JButton();
            btnNuevaFila = new JButton();

            //labels
            lblTitulo.setText("           Nuevo Producto");
            lblEspacio1.setText("           ");
            lblEspacio2.setText("           ");

            //Consultar numero de ultimo cliente

            tNuevo_Producto.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null},
                },
                new String [] {
                    "Codigo_P", "Nombre_P", "Precio_P"
                }
            ));

            jScrollPane1.setViewportView(tNuevo_Producto);
            //Botones
            btnListo.setText("Listo");
            btnNuevaFila.setText("Nueva Fila");

            //Paneles
            pPrincipal.setLayout(new java.awt.BorderLayout());

            pPrincipal.add(lblTitulo, java.awt.BorderLayout.NORTH);
            pPrincipal.add(lblEspacio1, java.awt.BorderLayout.EAST);
            pPrincipal.add(lblEspacio2, java.awt.BorderLayout.WEST);

            pPrincipal.add(jScrollPane1, java.awt.BorderLayout.CENTER);

            pPrincipal.add(pSur, java.awt.BorderLayout.SOUTH);

            /*Panel parte inferior*/
            pSur.setLayout(new java.awt.GridLayout(1, 3));
            pSur.add(btnNuevaFila);
            pSur.add(btnListo);
            


        }// </editor-fold>                        
        
        // Variables declaration - do not modify                     
        private JLabel lblEspacio1;
        private JLabel lblEspacio2;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTable tNuevo_Producto;
        private JLabel lblTitulo;
        protected JPanel pPrincipal;
        private JPanel pSur;
        private JButton btnNuevaFila;
        private JButton btnListo;
        private int ultimo_Cliente;
        // End of variables declaration   
    
    }
    
    private class PNuevo_Servicio extends JPanel{
        public PNuevo_Servicio (){
            initComponents();
        }
        
        private void initComponents() {
            pPrincipal = new JPanel();
            lblTitulo = new JLabel();
            pSur = new JPanel();
            jScrollPane1 = new javax.swing.JScrollPane();
            tNuevo_Servicio = new javax.swing.JTable();
            lblEspacio1 = new JLabel();
            lblEspacio2 = new JLabel();
            btnListo = new JButton();
            btnNuevaFila = new JButton();

            //labels
            lblTitulo.setText("           Nuevo Servicio");
            lblEspacio1.setText("           ");
            lblEspacio2.setText("           ");

            //Consultar numero de ultimo cliente

            tNuevo_Servicio.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null},
                },
                new String [] {
                    "Codigo_S", "Nombre_S", "Precio_S"
                }
            ));

            jScrollPane1.setViewportView(tNuevo_Servicio);
            //Botones
            btnListo.setText("Listo");
            btnNuevaFila.setText("Nueva Fila");

            //Paneles
            pPrincipal.setLayout(new java.awt.BorderLayout());

            pPrincipal.add(lblTitulo, java.awt.BorderLayout.NORTH);
            pPrincipal.add(lblEspacio1, java.awt.BorderLayout.EAST);
            pPrincipal.add(lblEspacio2, java.awt.BorderLayout.WEST);

            pPrincipal.add(jScrollPane1, java.awt.BorderLayout.CENTER);

            pPrincipal.add(pSur, java.awt.BorderLayout.SOUTH);

            /*Panel parte inferior*/
            pSur.setLayout(new java.awt.GridLayout(1, 3));
            pSur.add(btnNuevaFila);
            pSur.add(btnListo);
            


        }// </editor-fold>                        
        
        // Variables declaration - do not modify                     
        private JLabel lblEspacio1;
        private JLabel lblEspacio2;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTable tNuevo_Servicio;
        private JLabel lblTitulo;
        protected JPanel pPrincipal;
        private JPanel pSur;
        private JButton btnNuevaFila;
        private JButton btnListo;
        private int ultimo_Cliente;
        // End of variables declaration   
    }

    //Panel Nuevo_Cliente
    private class PNuevo_Cliente extends JPanel{       
        public PNuevo_Cliente (){
            initComponents();     
        }
        
        private void initComponents() {
            pPrincipal = new JPanel();
            lblTitulo = new JLabel();
            pSur = new JPanel();
            jScrollPane1 = new javax.swing.JScrollPane();
            tNuevo_Cliente = new javax.swing.JTable();
            lblEspacio1 = new JLabel();
            lblEspacio2 = new JLabel();
            btnListo = new JButton();
            btnNuevaFila = new JButton();

            //labels
            lblTitulo.setText("           Nuevo Cliente");
            lblEspacio1.setText("           ");
            lblEspacio2.setText("           ");

            //Consultar numero de ultimo cliente

            tNuevo_Cliente.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null},
                },
                new String [] {
                    "Numero_Cl", "Nombre_Cl", "Telefono_Cl"
                }
            ));

            jScrollPane1.setViewportView(tNuevo_Cliente);
            //Botones
            btnListo.setText("Listo");
            btnNuevaFila.setText("Nueva Fila");

            //Paneles
            pPrincipal.setLayout(new java.awt.BorderLayout());

            pPrincipal.add(lblTitulo, java.awt.BorderLayout.NORTH);
            pPrincipal.add(lblEspacio1, java.awt.BorderLayout.EAST);
            pPrincipal.add(lblEspacio2, java.awt.BorderLayout.WEST);

            pPrincipal.add(jScrollPane1, java.awt.BorderLayout.CENTER);

            pPrincipal.add(pSur, java.awt.BorderLayout.SOUTH);

            /*Panel parte inferior*/
            pSur.setLayout(new java.awt.GridLayout(1, 3));
            pSur.add(btnNuevaFila);
            pSur.add(btnListo);
            


        }// </editor-fold>                        
        
        // Variables declaration - do not modify                     
        private JLabel lblEspacio1;
        private JLabel lblEspacio2;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTable tNuevo_Cliente;
        private JLabel lblTitulo;
        protected JPanel pPrincipal;
        private JPanel pSur;
        private JButton btnNuevaFila;
        private JButton btnListo;
        private int ultimo_Cliente;
        // End of variables declaration   
    }
    
    private class PNuevo_Proveedor extends JPanel{
        public PNuevo_Proveedor (){
            initComponents();
        }
        
         private void initComponents() {
            pPrincipal = new JPanel();
            lblTitulo = new JLabel();
            pSur = new JPanel();
            jScrollPane1 = new javax.swing.JScrollPane();
            tNuevo_Proveedor = new javax.swing.JTable();
            lblEspacio1 = new JLabel();
            lblEspacio2 = new JLabel();
            btnListo = new JButton();
            btnNuevaFila = new JButton();

            //labels
            lblTitulo.setText("           Nuevo Proveedor");
            lblEspacio1.setText("           ");
            lblEspacio2.setText("           ");

            //Consultar numero de ultimo cliente

            tNuevo_Proveedor.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null},
                },
                new String [] {
                    "Codigo_Pro", "Nombre_Pro", "No_Telefono_Pro", "Direccion_Pro"
                }
            ));

            jScrollPane1.setViewportView(tNuevo_Proveedor);
            //Botones
            btnListo.setText("Listo");
            btnNuevaFila.setText("Nueva Fila");

            //Paneles
            pPrincipal.setLayout(new java.awt.BorderLayout());

            pPrincipal.add(lblTitulo, java.awt.BorderLayout.NORTH);
            pPrincipal.add(lblEspacio1, java.awt.BorderLayout.EAST);
            pPrincipal.add(lblEspacio2, java.awt.BorderLayout.WEST);

            pPrincipal.add(jScrollPane1, java.awt.BorderLayout.CENTER);

            pPrincipal.add(pSur, java.awt.BorderLayout.SOUTH);

            /*Panel parte inferior*/
            pSur.setLayout(new java.awt.GridLayout(1, 3));
            pSur.add(btnNuevaFila);
            pSur.add(btnListo);
        }// </editor-fold>                        
        
        // Variables declaration - do not modify                     
        private JLabel lblEspacio1;
        private JLabel lblEspacio2;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTable tNuevo_Proveedor;
        private JLabel lblTitulo;
        protected JPanel pPrincipal;
        private JPanel pSur;
        private JButton btnNuevaFila;
        private JButton btnListo;
        private int ultimo_Cliente;
        // End of variables declaration   
    
    }
    
    private void agregarPanel (JPanel panel1){
        panel = panel1;
    }
}
