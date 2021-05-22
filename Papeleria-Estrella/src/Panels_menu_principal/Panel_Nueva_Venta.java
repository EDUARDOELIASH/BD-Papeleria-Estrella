/*     
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */    
package Panels_menu_principal;
       
import Ventana.Nuevo_Dato;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
/**
 *
 * @author Eduardo Elias Hernandez Moreno
 */
public class Panel_Nueva_Venta extends JPanel{
    
    //Talves se necesite parametro Connection
    public Panel_Nueva_Venta (){
        initComponents();
    }
    
    private void initComponents(){
        pTablaP_Y_S = new JPanel();
        pCentro = new JPanel();
        pDatos_Venta = new JPanel();
        pCodigo_V = new JPanel();
        pNumero_Cl = new JPanel();
        pTotal_V = new JPanel();
        pBotones = new JPanel();
        
        tProductos_Venta = new JTable();
        tServicios_Venta = new JTable();      
        jstProductos = new JScrollPane();
        jstServicios = new JScrollPane();
        
        tpTablas = new JTabbedPane(JTabbedPane.BOTTOM);
        
        btnNuevo_Cliente = new JButton();
        btnRegistrar = new JButton();
        btnAgregar_p_o_s = new JButton();
        jdchFecha_V = new com.toedter.calendar.JDateChooser();
        lblCodigo_V = new JLabel();
        lblFecha_V = new JLabel();
        lblNumero_Cl = new JLabel();
        lblTotal_V = new JLabel();
        lblTitulo = new JLabel();
        //    private JLabel lblTitulo;
        txtCodigo_V = new JTextField();
        txtNumero_Cl = new JTextField();
        txtTotal_V = new JTextField();
        
        //JLabel's
        lblTitulo.setText("Nueva venta");
        lblCodigo_V. setText("Codigo_V     ");
        lblFecha_V.  setText("Fecha_V       ");
        lblNumero_Cl.setText("Numero_Cl  ");
        lblTotal_V.  setText("Total Venta");
        
        //JTextField's
        txtCodigo_V.setEditable(false);
        txtNumero_Cl.setText("0");
        
        //JDate's
        jdchFecha_V.setDateFormatString("dd/MM/yyyy");
        
        //JTable's
        tProductos_Venta.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null, null},
                },
                new String [] {
                    "Nombre_P", "Codigo_P", "Cantidad", "Precio", "Total"
                }
            ));
            //En base al nombre del producto se busca el codigo en la base de datos

            jstProductos.setViewportView(tProductos_Venta);
            
        tServicios_Venta.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null, null},
                },
                new String [] {
                    "Nombre_S", "Codigo_S", "Cantidad", "Precio", "Total"
                }
            ));
            //En base al nombre del producto se busca el codigo en la base de datos

            jstServicios.setViewportView(tServicios_Venta);    
        
        //JTabbedPane
        tpTablas.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        tpTablas.setFocusable(false);
	tpTablas.setRequestFocusEnabled(false);    
        
        tpTablas.addTab("Productos vendidos",jstProductos);
        tpTablas.addTab("Servicios vendidos", jstServicios);
            
        //JButton's
        btnAgregar_p_o_s.setText("Agregar fila");
        btnAgregar_p_o_s.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try{
                   btnAgregar_p_o_sActionPerformed(evt);
                }
                catch(Exception e){
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }
        });
        
        btnNuevo_Cliente.setText("Nuevo cliente");
        btnNuevo_Cliente.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo_ClienteActionPerformed(evt);
            }
        });
        
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                btnRegistrarActionPerformed(evt);
            
            }
        });
            
        //JPanel's
        /*Contenido Panel_Nueva_Venta*/
        setLayout(new BorderLayout());
        
        add(pCentro, BorderLayout.CENTER);
        add(pBotones, BorderLayout.SOUTH);
        add(lblTitulo, BorderLayout.NORTH);      
        
        /*Contenido pCodigo_V*/
        pCodigo_V.setLayout(new BorderLayout());
        pCodigo_V.add(lblCodigo_V, BorderLayout.WEST);
        pCodigo_V.add(txtCodigo_V, BorderLayout.CENTER);
        
        /*Contenido pNumero_Cl*/
        pNumero_Cl.setLayout(new BorderLayout());
        pNumero_Cl.add(lblNumero_Cl, BorderLayout.WEST);
        pNumero_Cl.add(txtNumero_Cl, BorderLayout.CENTER);
        
        /*Contenido pDatos_Venta*/
        pDatos_Venta.setLayout(new BorderLayout());
        
        pDatos_Venta.add(pCodigo_V, BorderLayout.NORTH);
        
        pDatos_Venta.add(lblFecha_V, BorderLayout.WEST);
        pDatos_Venta.add(jdchFecha_V, BorderLayout.CENTER);
        
        pDatos_Venta.add(pNumero_Cl, BorderLayout.SOUTH);
        
        /*Contenido pTotal_V*/
        pTotal_V.setLayout(new BorderLayout());
        pTotal_V.add(lblTotal_V, BorderLayout.WEST);
        pTotal_V.add(txtTotal_V, BorderLayout.CENTER);
        
        /*Contenido pTablaP_Y_S*/
        pTablaP_Y_S.setLayout(new BorderLayout());
        pTablaP_Y_S.add(pDatos_Venta, BorderLayout.NORTH);
        pTablaP_Y_S.add(pTotal_V, BorderLayout.SOUTH);
        pTablaP_Y_S.add(tpTablas, BorderLayout.CENTER);
        
        
        /*Contenido pCentro*/
        pCentro.setLayout(new BorderLayout());
        pCentro.add(pDatos_Venta, BorderLayout.NORTH);
        pCentro.add(pTablaP_Y_S, BorderLayout.CENTER);
        pCentro.add(pBotones, BorderLayout.SOUTH);
        
        /*Contenido pBotones*/
        pBotones.setLayout(new GridLayout(1, 3));
        pBotones.add(btnAgregar_p_o_s);
        pBotones.add(btnNuevo_Cliente);
        pBotones.add(btnRegistrar);
    }
    
    //metodos de panel Nueva_Venta, se activan en constructor despues de initComponents
    private String nuevo_Codigo_V (Connection con) throws SQLException{
        //El resultado de este metodo se asigna a JTextField del Codigo_V de nueva venta
        //Hacer consulta a tabla ultima_venta
        String codigo_V;
        String sql = "SELECT Codigo_V FROM ultima_venta";
        try (Statement statement = con.createStatement()) {
            try (ResultSet rs = statement.executeQuery(sql)) {
                codigo_V = rs.getString("Codigo_V");         
            }
            statement.close();
            //con.close();
        }
        
        //Generar nuevo Codigo_V
        String numero="";
        String primerCaracter = codigo_V.substring(0,1);
        for (int i=1; i<=codigo_V.length(); i++){
            if (i!=codigo_V.length()){
                numero += codigo_V.substring(i,i+1);
            }
            else{
                codigo_V = "";
                codigo_V += primerCaracter + (Integer.parseInt(numero) + 1);
            }
        }
        
        //Cada vez que se registra una nueva venta, se actualiza tabla ultima_venta
        /*
        txtCodigo_V.setText(nuevo_Codigo_V(con));
        */
        return codigo_V;
    }
    
    private Date fechaActual(){
        Date fecha=new Date();
        SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/YYYY");
        
        //el return de este metodo se asigna a txtFecha_V
        /*
            se puede añadir un listener para que no se pueda editar fecha
            jdchFecha_V.setDate(fechaActual);
        */
        return fecha;
    }
    
    private void btnAgregar_p_o_sActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
        //Se abre ventana para agregar productos o servicios para venta
    }                                                 

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        //Se registra todo en las tablas de las bases de datos
    }                                            

    private void btnNuevo_ClienteActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
        //Se abre panel pNuevo_Cliente
        Nuevo_Dato ventana = new Nuevo_Dato("Nuevo_Cliente");
        ventana.setVisible(true);
    }              
    
    // Variables declaration - do not modify  
    private JPanel pCentro;
    private JPanel pBotones;
    
    private JPanel pDatos_Venta;
    private JPanel pTablaP_Y_S;
    private JPanel pCodigo_V;
    private JPanel pNumero_Cl;
    private JPanel pTotal_V;
                       
    private JTable tProductos_Venta;
    private JTable tServicios_Venta;
    private JScrollPane jstProductos;
    private JScrollPane jstServicios;
    
    private JTabbedPane tpTablas;
    
    private JButton btnNuevo_Cliente;
    private JButton btnRegistrar;
    private JButton btnAgregar_p_o_s;
    private com.toedter.calendar.JDateChooser jdchFecha_V;
    private JLabel lblCodigo_V;
    private JLabel lblFecha_V;
    private JLabel lblNumero_Cl;
    private JLabel lblTotal_V;
    private JLabel lblTitulo;
//    private JLabel lblTitulo;
    private JTextField txtCodigo_V;
    private JTextField txtNumero_Cl;
    private JTextField txtTotal_V;
    // End of variables declaration    
    
}
