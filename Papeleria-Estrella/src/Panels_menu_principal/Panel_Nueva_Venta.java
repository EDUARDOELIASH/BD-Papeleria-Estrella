/*     
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */    
package Panels_menu_principal;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
/**
 *
 * @author Eduardo Elias Hernandez Moreno
 */
public class Panel_Nueva_Venta extends JPanel{
    
    //Talves se necesite parametro Connection
    public Panel_Nueva_Venta (Connection con, JMenuItem menuItem) throws SQLException{
        this.con = con;
        initComponents(menuItem);
    }
    
    private void initComponents(final JMenuItem menuItem) throws SQLException{
        final String [] vector_Producto_Venta = {null,null,null,null,null};
        final String [] vector_Servicio_Venta = {null,null,null,null,null};
        final byte nTabs = 2;
        final int[] nFilas = {1, 1};
        
        pTablaP_Y_S = new JPanel();
        pCentro = new JPanel();
        pDatos_Venta = new JPanel();
        pCodigo_V = new JPanel();
        pNumero_Cl = new JPanel();
        pTotal_V = new JPanel();
        pBotones = new JPanel();
        pTabbedPane = new ArrayList<JPanel>();
        
        tProductos_Venta = new JTable();
        tServicios_Venta = new JTable();      
        sptProductos = new JScrollPane();
        sptServicios = new JScrollPane();
        
        tpTablas = new JTabbedPane(JTabbedPane.BOTTOM);
        
        btnNuevo_Cliente = new JButton();
        btnRegistrar = new JButton();
        btnNueva_fila = new ArrayList<JButton>();
        jdchFecha_V = new com.toedter.calendar.JDateChooser();
        lblCodigo_V = new JLabel();
        lblFecha_V = new JLabel();
        lblNumero_Cl = new JLabel();
        lblTotal_V = new JLabel();
        lblTitulo = new JLabel();
        
        //    private JLabel lblTitulo;
        txtCodigo_V = new JTextField();
        txtCodigo_V.setText(nuevo_Codigo_V(con));
        txtCodigo_V.setEditable(false);
        
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
        jdchFecha_V.setDate(fechaActual());
        
        //JTable's
        tProductos_Venta.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    vector_Producto_Venta
                },
                new String [] {
                    "Codigo producto", "Nombre", "Cantidad", "Precio", "Total"
                }
            ));
            //En base al nombre del producto se busca el codigo en la base de datos

            sptProductos.setViewportView(tProductos_Venta);
        setBox(tProductos_Venta, tProductos_Venta.getColumnModel().getColumn(0), "producto", (DefaultTableModel) tProductos_Venta.getModel());    
            
        tServicios_Venta.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    vector_Servicio_Venta
                },
                new String [] {
                    "Codigo servicio", "Nombre", "Cantidad", "Precio", "Total"
                }
            ));
            //En base al nombre del producto se busca el codigo en la base de datos

            sptServicios.setViewportView(tServicios_Venta);  
        //setBox(tServicios_Venta, tServicios_Venta.getColumnModel().getColumn(0), "servicio", (DefaultTableModel) tServicios_Venta.getModel());
            
        //DefaultTablemModel's    
        final DefaultTableModel dtmProductos_V = (DefaultTableModel) tProductos_Venta.getModel();
        final DefaultTableModel dtmServicios_V = (DefaultTableModel) tServicios_Venta.getModel();

        //JButton's
        botonesNueva_Fila(vector_Producto_Venta, vector_Servicio_Venta, nTabs, nFilas);
         
        btnNuevo_Cliente.setText("Nuevo cliente");
        btnNuevo_Cliente.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnNuevo_ClienteActionPerformed(evt, con, menuItem);
                } catch (SQLException ex) {
                    Logger.getLogger(Panel_Nueva_Venta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        btnRegistrar.setText("Registrar venta");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                //Insert en tabla venta y cliente_venta
                
                
                //Insert productos vendidos falta consultar precios en tabla consultar nombre p
                for (int i = 0; i<nFilas[0]; i++){  
                    String sql = "INSERT INTO producto_venta VALUES('"+txtCodigo_V+"','"+dtmProductos_V.getValueAt(i, 0)+"', "+dtmProductos_V.getValueAt(i, 2)+", "+1+", "+0+")";
                    btnRegistrarActionPerformed(sql); 
                }
                
                //Insert servicios vendidos cambiar de modelo
                for (int i = 0; i<nFilas[1]; i++){
                    String sql = "INSERT INTO servicio_venta VALUES('"+txtCodigo_V+"', '"+dtmServicios_V.getValueAt(i, 0)+"', "+dtmServicios_V.getValueAt(i, 2)+", "+1+")";
                    btnRegistrarActionPerformed(sql);  
                }
                
                //se vuelve a llamar panel
            }
        });    
           
        //JTabbedPane
        tpTablas.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        tpTablas.setFocusable(false);
	tpTablas.setRequestFocusEnabled(false);    
                         
        //JPanel's
        panelesTabbedPane(nTabs);
        
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
        pBotones.setLayout(new GridLayout(1, 2));
        pBotones.add(btnNuevo_Cliente);
        pBotones.add(btnRegistrar);
    }
    
    //metodos de panel Nueva_Venta, se activan en constructor despues de initComponents
    private String nuevo_Codigo_V (Connection con) throws SQLException{
        //El resultado de este metodo se asigna a JTextField del Codigo_V de nueva venta
        //Hacer consulta a tabla ultima_venta
        String codigo_V = null;
        String sql = "SELECT Codigo_V FROM ultimas_claves_secuenciales";
        try (Statement statement = con.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
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
        //SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/YYYY");

        /*
            se puede añadir un listener para que no se pueda editar fecha
            jdchFecha_V.setDate(fechaActual);
        */
        return fecha;
    }
    
    private void botonesNueva_Fila (final String[] vector_Producto_Venta, final String[] vector_Servicio_Venta, byte nTabs, final int[] nFilas){    
        for (int i = 0; i < nTabs; i++) {
            JButton btn = new JButton();
            
            btnNueva_fila.add(btn);
            btnNueva_fila.get(i).setText("+");
            final int indice = i;
            btnNueva_fila.get(i).addActionListener(new java.awt.event.ActionListener() {
                @Override           
                public void actionPerformed(ActionEvent evt) {
                    
                    try{
                        javax.swing.table.DefaultTableModel tmTabla = new javax.swing.table.DefaultTableModel();
                        String[] vector = null;
                        
                        if (indice == 0){//Producto_Venta
                            tmTabla = (javax.swing.table.DefaultTableModel)tProductos_Venta.getModel();
                            vector = vector_Producto_Venta;
                        }
                        else{//Servicio_Venta
                            if (indice == 1){
                                tmTabla = (javax.swing.table.DefaultTableModel)tServicios_Venta.getModel();
                                vector = vector_Servicio_Venta;
                            }
                        }

                        btnNueva_FilaActionPerformed(tmTabla, vector, nFilas, indice);
                    }
                    catch(Exception e){
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                }
            });
        }     
    }
    
    private void panelesTabbedPane (byte nTabs){
        for (int i = 0; i < nTabs; i++) {
            JPanel panel = new JPanel();
            pTabbedPane.add(panel);
            pTabbedPane.get(i).setLayout(new BorderLayout());
            
            if (i == 0){
                pTabbedPane.get(i).add(sptProductos, BorderLayout.CENTER);
                pTabbedPane.get(i).add(btnNueva_fila.get(i), BorderLayout.SOUTH);
                tpTablas.addTab("Productos vendidos", pTabbedPane.get(i));
            }
            else{
                if (i == 1){
                    pTabbedPane.get(i).add(sptServicios, BorderLayout.CENTER);
                    pTabbedPane.get(i).add(btnNueva_fila.get(i), BorderLayout.SOUTH);
                    tpTablas.addTab("Servicios vendidos", pTabbedPane.get(i));
                }
            }
        }
    
    }
    
    private void setBox (JTable tabla, TableColumn columna, String nombreT, final DefaultTableModel dtmVenta) throws SQLException{
        final JComboBox cb = new JComboBox();
        String sql = "SELECT Codigo_P, NOMBRE_P, Precio_P FROM producto";
        
        final ResultSet rs = consultar(sql, "producto");
        
        while (rs.next() == true){
            try {
                cb.addItem(rs.getString("Codigo_P") + " " + rs.getString("NOMBRE_P"));
                
            } catch (SQLException ex) {
                Logger.getLogger(Panel_Nueva_Venta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        cb.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    cbComboActionPerformed(cb, rs, dtmVenta);
                } catch (SQLException ex) {
                    Logger.getLogger(Panel_Nueva_Venta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        columna.setCellEditor(new DefaultCellEditor(cb));
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setToolTipText("Seleccionar Codigo de " + nombreT);
        columna.setCellRenderer(renderer);
    }
    
    private ResultSet consultar (String sql, String tabla){

        ResultSet rs = null;
        Statement st = null;

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Panel_Nueva_Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    //Listeners
    private void btnNueva_FilaActionPerformed(javax.swing.table.DefaultTableModel dtmTabla, String[] vector, int[] nFilas, int i) {                                                  
        // TODO add your handling code here:
        //Se abre ventana para agregar producto o servicio para venta
        
        dtmTabla.addRow(vector);
        nFilas[i]++;
        System.out.println(i+ " "+ nFilas[i]);
    }                                                 

    private void btnRegistrarActionPerformed(String sql) {                                             
        try {
            // TODO add your handling code here:
            //Se registra todo en las tablas de las bases de datos
            Statement st = con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Panel_Nueva_Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }                                            

    private void btnNuevo_ClienteActionPerformed(java.awt.event.ActionEvent evt, Connection con, JMenuItem menuItem) throws SQLException {                                                 
        // TODO add your handling code here:
        //Se abre panel pNuevo_Cliente
        Panel_Nuevos_Datos panel = new Panel_Nuevos_Datos("Nuevo_Cliente", con, menuItem);
        
        javax.swing.JFrame ventana = new javax.swing.JFrame();
        
        ventana.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        //ventana.add(panel.pPrincipal);
        ventana.setLocationRelativeTo(null);
        ventana.pack();
        ventana.setVisible(true);
    }              
    
    private void cbComboActionPerformed (JComboBox cb, ResultSet rs, DefaultTableModel dtmModelo) throws SQLException{
        String item = (String) cb.getSelectedItem();
        System.out.println(item);
        String codigo_P = "";
        
        for (int i = 0; i < item.length(); i++){
            if (item.charAt(i) != ' '){
                codigo_P += item.charAt(i);
            }
            else{
                break;
            }
        }//arreglo de columnas
        
        while (!rs.getString("Codigo_P").equals(codigo_P)){
            rs.next();
        }
        //cb.ge;
        dtmModelo.setValueAt(rs.getString("NOMBRE_P"), 0, 1);
        dtmModelo.setValueAt(rs.getString("Precio_P"), 0, 3);
        //Se consiguen valores para tabla
    }
    
    // Variables declaration - do not modify  
    private Connection con;
    
    private JPanel pCentro;
    private JPanel pBotones;
    
    private JPanel pDatos_Venta;
    private JPanel pTablaP_Y_S;
    private JPanel pCodigo_V;
    private JPanel pNumero_Cl;
    private JPanel pTotal_V;
    private ArrayList<JPanel> pTabbedPane;
                       
    private JTable tProductos_Venta;
    private JTable tServicios_Venta;
    private JScrollPane sptProductos;
    private JScrollPane sptServicios;
    
    private JTabbedPane tpTablas;
    
    private JButton btnNuevo_Cliente;
    private JButton btnRegistrar;
    private ArrayList<JButton> btnNueva_fila;
    
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
