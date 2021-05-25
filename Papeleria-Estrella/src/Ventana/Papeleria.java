package Ventana;

import Panels_menu_principal.Panel_Nueva_Compra;
import Panels_menu_principal.Panel_Nueva_Venta;
import Panels_menu_principal.Panel_Nuevos_Datos;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JPanel;

/*
 * @author Gijon Vazquez Elias Dominick
 */
public class Papeleria extends JApplet implements ActionListener{
    
    public Papeleria(Connection con) {
        this.con = con;
        df=new DecimalFormat("###0.00");
        //1.Creamos el Formulario
        JF_Estadisticas = new JFrame();
        JF_Estadisticas.setTitle("Papeleria la estrella");
        JF_Estadisticas.setSize(515, 450);
        JF_Estadisticas.setLayout(new BorderLayout());
        
        //2.Agregar los paneles para distribucion
        JP_Central = new JPanel();
        JP_Reporte = new JPanel();
        JP_DatosGen = new JPanel();
        JP_Datos = new JPanel();
        JP_Tablas = new JPanel();
        JP_Botones = new JPanel();
        jspPanel  = new JScrollPane();
        //Menu de Opciones
        mb=new JMenuBar();
        
        m_Principal = new JMenu("Inicio");
        m_Nuevo = new JMenu("Nuevo");
        m_Consultar = new JMenu("Consultar");
        m_Actualizar = new JMenu("Actualizar");
        m_Sesion = new JMenu("Sesion");

        m_n_Dato = new JMenu("Datos");
        m_n_Venta = new JMenuItem("Venta");
        m_n_Compra = new JMenuItem("Compra");

        //m_c_Datos = new JMenuItem("Datos"); //Creo que este es otro menu
        m_c_Datos = new JMenu("Datos");
        m_c_Ventas = new JMenuItem("Productos y Servicios Vendidos");
        m_c_Compras = new JMenuItem("Productos Comprados");
        m_c_Inventario = new JMenuItem("Inventario");

        m_a_Productos = new JMenuItem("Precio de Producto");
        m_a_Servicios = new JMenuItem("Precio de Servicios");
        m_a_Proveedor = new JMenu("Proveedor");
        m_a_Cliente = new JMenuItem("Numero de telefono del Cliente");

        m_s_Iniciar = new JMenuItem("Iniciar Sesion");
        m_s_Cerrar = new JMenuItem("Cerrar Sesion");
        
        m_nD_Productos = new JMenuItem("Productos");
        m_nD_Servicios = new JMenuItem("Servicios");
        m_nD_Clientes = new JMenuItem("Clientes");
        m_nD_Proveedores = new JMenuItem("Proveedores");
        
        m_aP_Telefono = new JMenuItem("Numero de Telefono");
        m_aP_Direccion = new JMenuItem("Direccion");
        
        
        //Invocadores
        m_n_Venta.addActionListener(this);
        m_n_Compra.addActionListener(this);
    
//        m_c_Datos.addActionListener(this);
        m_c_Ventas.addActionListener(this);
        m_c_Compras.addActionListener(this);
        m_c_Inventario.addActionListener(this);

        m_a_Productos.addActionListener(this);
        m_a_Servicios.addActionListener(this);
        m_a_Proveedor.addActionListener(this);
        m_a_Cliente.addActionListener(this);

        m_s_Iniciar.addActionListener(this);
        m_s_Cerrar.addActionListener(this);
        
        m_nD_Productos.addActionListener(this);
        m_nD_Servicios.addActionListener(this);
        m_nD_Clientes.addActionListener(this);
        m_nD_Proveedores.addActionListener(this);
        
        m_aP_Telefono.addActionListener(this);
        m_aP_Direccion.addActionListener(this);
        
        //Listas de Acciones
        m_Nuevo.add(m_n_Dato);
        m_Nuevo.add(m_n_Venta);
        m_Nuevo.add(m_n_Compra);
        
        m_Consultar.add(m_c_Datos);
        m_Consultar.add(m_c_Ventas);
        m_Consultar.add(m_c_Compras);
        m_Consultar.add(m_c_Inventario);
        
        m_Actualizar.add(m_a_Productos);
        m_Actualizar.add(m_a_Servicios);
        m_Actualizar.add(m_a_Proveedor);
        m_Actualizar.add(m_a_Cliente);
        
        m_Sesion.add(m_s_Iniciar);
        m_Sesion.add(m_s_Cerrar);
        
        //SubListas
        //Nuevo - Datos
        m_n_Dato.add(m_nD_Productos);
        m_n_Dato.add(m_nD_Servicios);
        m_n_Dato.add(m_nD_Clientes);
        m_n_Dato.add(m_nD_Proveedores);
        
        //Actualizar - Proveedor
        m_a_Proveedor.add(m_aP_Telefono);
        m_a_Proveedor.add(m_aP_Direccion);
        
        mb.add(m_Principal);
        mb.add(m_Nuevo);
        mb.add(m_Consultar);
        mb.add(m_Actualizar);
        mb.add(m_Sesion);
        /*
        menu1=new JMenu("Calcular");
        mb.add(menu1);
            mi1=new JMenuItem("Sueldos");
            mi1.addActionListener(this);
         menu1.add(mi1);
            mi2=new JMenuItem("Nomina");
            mi2.addActionListener(this);
        menu1.add(mi2); 
            menu2=new JMenuItem("Limpiar");
            menu2.addActionListener(this);
        mb.add(menu2);
            menu3=new JMenuItem("Salir");
            menu3.addActionListener(this);
        mb.add(menu3);  
        */
   //8. Mostramos interfaz
        JF_Estadisticas.setJMenuBar(mb);
        JF_Estadisticas.setLocationRelativeTo(null);
        JF_Estadisticas.setVisible(true);
        JF_Estadisticas.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == m_n_Venta){
            Panel_Nueva_Venta panel = new Panel_Nueva_Venta(con);
            llamarPanel(panel);
        }
        if (e.getSource() == m_n_Compra){
            Panel_Nueva_Compra panel = new Panel_Nueva_Compra();
            llamarPanel(panel);
        }
        if (e.getSource() == m_nD_Servicios){
            Panel_Nueva_Compra panel = new Panel_Nueva_Compra();
            llamarPanel(panel);
        }
        if(e.getSource() == m_nD_Productos){
            //Permitir guardar el panel (future feature)
            Panel_Nuevos_Datos panel = new Panel_Nuevos_Datos("Nuevo_Producto", con); 
            llamarPanel(panel.pPrincipal);
        }
        if (e.getSource() == m_nD_Servicios){
            Panel_Nuevos_Datos panel = new Panel_Nuevos_Datos("Nuevo_Servicio", con);
            llamarPanel(panel.pPrincipal);
        }
        if (e.getSource() == m_nD_Clientes){
            Panel_Nuevos_Datos panel = new Panel_Nuevos_Datos("Nuevo_Cliente", con);
            llamarPanel(panel.pPrincipal);
        }
        if (e.getSource() == m_nD_Proveedores){
            Panel_Nuevos_Datos panel = new Panel_Nuevos_Datos("Nuevo_Proveedor", con);
            llamarPanel(panel.pPrincipal);
        }
        if (e.getSource() == m_s_Cerrar){
            try {
                //Cerrar conexion a base de datos
                //Agregar JOptionPane para confirmar cerrar conexion
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Papeleria.class.getName()).log(Level.SEVERE, null, ex);
            }
            JF_Estadisticas.dispose();            
        }
    }   
    
    private void llamarPanel(final JPanel panel){
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
                java.util.logging.Logger.getLogger(Papeleria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(Papeleria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(Papeleria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(Papeleria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JF_Estadisticas.remove(jspPanel);
                    
                    JP_Central = panel;
                    jspPanel.setViewportView(panel);
                    JF_Estadisticas.add(jspPanel, BorderLayout.CENTER);
                    JF_Estadisticas.repaint();
                    JF_Estadisticas.validate();
                }
            }); 
    }
    
    private Connection con;
    
    private DecimalFormat df;
    private JFrame JF_Estadisticas;
	
    private JPanel JP_Central;
    private JPanel JP_DatosGen;
    private JPanel JP_Datos;
    private JPanel JP_Tablas;
    private JPanel JP_Reporte; 
    private JPanel JP_Botones;
    
    //JScrollPane1.setViewportView(lstEstadistica);

    private JMenuBar mb;
    private JMenu m_Principal;
    private JMenu m_Nuevo;
    private JMenu m_Consultar;
    private JMenu m_Actualizar;
    private JMenu m_Sesion;
    
    private JMenu m_n_Dato;
    private JMenuItem m_n_Venta;
    private JMenuItem m_n_Compra;
    
    private JMenu m_c_Datos;
    private JMenuItem m_c_Ventas;
    private JMenuItem m_c_Compras;
    private JMenuItem m_c_Inventario;
    
    private JMenuItem m_a_Productos;
    private JMenuItem m_a_Servicios;
    private JMenu m_a_Proveedor;
    private JMenuItem m_a_Cliente;
    
    private JMenuItem m_s_Iniciar;
    private JMenuItem m_s_Cerrar;
    
    private JMenuItem m_nD_Productos;
    private JMenuItem m_nD_Servicios;
    private JMenuItem m_nD_Clientes;
    private JMenuItem m_nD_Proveedores;
    
    private JMenuItem m_aP_Telefono;
    private JMenuItem m_aP_Direccion;
    
    private JScrollPane jspPanel;
    
    private int Filas, Columnas, ciclo=1;;
}
