/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels_menu_principal;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import listas.Compras;

/**
 *
 * @author Eduardo Elias Hernandez Moreno
 */
public class Panel_Nueva_Compra extends JPanel{
    
    public Panel_Nueva_Compra (Connection con) throws SQLException{
        this.con = con;
        
        nProveedores = 0;
        String[] vector = {null,null,null,null,null};
        initComponents(vector);
    }
    
    private void initComponents(final String[] vector) throws SQLException{
        jdchFechas_C = new ArrayList<com.toedter.calendar.JDateChooser>();
        cbProdutos = new JComboBox();
        P = new Compras();
        P = null;
        codigos_Pro = new ArrayList<String>();
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
        //btnNueva_compra.doClick();
        
        //JButton's
        btnNueva_compra.setText("Nueva compra");
        btnNueva_compra.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnNueva_compraActionPerformed(vector);
                } catch (SQLException ex) {
                    Logger.getLogger(Panel_Nueva_Compra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        btnRegistrar.setText("Registrar compra");
        
        btnRegistrar.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                for (int i = 0; i<nProveedores; i++){
                    Compras nodos = new Compras();
                    int[] nFilas = new int[1];
                    
                    nodos = nodos.obtenerNodo(P, nFilas);
                    System.out.println(nFilas[0]);
                    JTable tabla = (JTable) sptNueva_Compra.get(i).getViewport().getComponent(0);
                    DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
                    
                    for (int j = 0; j < nFilas[0]; j++){ //recorrer lista   
                        System.out.println("CALL Nueva_Compra('"+modelo.getValueAt(0, 0)+"', '"+codigos_Pro.get(0)+"', '2021-05-30', "+modelo.getValueAt(0, 3)+", "+modelo.getValueAt(0,4)+", 0)");
                        String sql = "CALL Nueva_Compra('"+modelo.getValueAt(j, 0)+"', '"+codigos_Pro.get(i)+"', '"+jdchFechas_C.get(i)+"', "+modelo.getValueAt(j, 3)+", "+modelo.getValueAt(j,4)+", 0)";
                        btnRegistrarActionPerformed(con, sql);
                        //System.out.println("hola");
                    }
                }
            }
        });
        
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
        
        cbProductos1();
        
    }
    
    private void nuevaCompra (String[] vector){
        //JTable's
        tNueva_compra = new JTable();
        
        DefaultTableModel modelo = new DefaultTableModel(
        new Object[][]{
                vector
            },
            new String[]{
                "Codigo del producto", "Nombre", "Cantidad", "Precio", "Total"
            }  
        );
        
        
        tNueva_compra.setModel(modelo);
        //JScrollPane's
        JScrollPane spnewScrollP = new JScrollPane();
        spnewScrollP.setViewportView(tNueva_compra);
        sptNueva_Compra.add(spnewScrollP);
    }
    
    private JFrame fNombre_proveedor (final String[] vector, JFrame fNombre_proveedor) throws SQLException{
        fNombre_proveedor = new JFrame();
        final JComboBox cbProveedores;
        
        JPanel pPrincipal = new JPanel();
        JPanel pCENTER = new JPanel();
        JLabel lblTitulo1 = new JLabel();        
        final JTable tProveedor = new JTable();
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
        
        //JTable
        tProveedor.setModel(dtmProveedor);
        tProveedor.setEnabled(false);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setToolTipText("Codigo de proveedor");
        tProveedor.getColumnModel().getColumn(0).setCellRenderer(renderer);
        
        String sql = "SELECT Codigo_Pro, Nombre_Pro FROM proveedor";
        
        ResultSet rs = consultar(con, sql);
        cbProveedores = new JComboBox();
        while (rs.next() == true){
            cbProveedores.addItem(rs.getString("Codigo_Pro")+"--"+rs.getString("Nombre_Pro"));
        }
        
        rs.close();
        cbProveedores.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                cbItemPerformed(e, cbProveedores, tProveedor);
            }
        });
        
        //JLabel
        lblTitulo1.setText("Nombre de proveedor");

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
        pCENTER.setLayout(new BorderLayout());
        pCENTER.add(cbProveedores, BorderLayout.NORTH);
        pCENTER.add(spProveedor, BorderLayout.CENTER);
        
        
        pPrincipal.setLayout(new BorderLayout());
        pPrincipal.add(lblTitulo1, BorderLayout.NORTH);
        pPrincipal.add(pCENTER, BorderLayout.CENTER);
        pPrincipal.add(btnListo, BorderLayout.SOUTH);
        
        fNombre_proveedor.add(pPrincipal);
        fNombre_proveedor.pack();
        
        return fNombre_proveedor;
    }
    
    private ResultSet consultar (Connection con, String sql) throws SQLException{
        Statement st;
        ResultSet rs = null;
        

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Panel_Nueva_Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
    private void cbItemPerformed (ItemEvent e, JComboBox cb, JTable tabla){
        if (e.getStateChange() == ItemEvent.SELECTED){
            if (!cb.getSelectedItem().toString().equals("")){
                String item = cb.getSelectedItem()+"";
                String codigo = "";
                String nombre = "";
                int indice = 0;
                
                for (int i = 0; i<item.length(); i++){
                    if (item.charAt(i) != '-' && item.charAt(i+1) != '-'){
                        codigo += item.charAt(i);
                    }
                    else{
                        codigo += item.charAt(i);
                        indice = i;
                        break;
                    }
                }
                
                for (int i = indice+3; i<item.length(); i++){
                     nombre += item.charAt(i);
                }
                tabla.getModel().setValueAt(codigo, 0, 0);
                tabla.getModel().setValueAt(nombre, 0, 1);
            }
        }
    }
    
    private void cbProductos1 () throws SQLException{
        String sql = "SELECT Codigo_P, NOMBRE_P FROM producto";
        ResultSet rs = consultar(con, sql);
        
        while (rs.next() == true){
            cbProdutos.addItem(rs.getString("Codigo_P")+"--"+rs.getString("NOMBRE_P"));
        }
    }
    
    private int validarint (String cadena){
        int numero;
        boolean nValido = false;
        
        try{
            numero = Integer.parseInt(cadena);
            nValido = true;
        }   
        catch (Exception ex){
            nValido = false;
            numero = -1;
        }
        
        return numero;
    }
    
    private double validardouble (String cadena){
        double numero;
        boolean nValido= false;
        
        try{
            numero = Double.parseDouble(cadena);
            nValido = true;
        }   
        catch (Exception ex){
            nValido = false;
            numero = -1;
        }
        
        return numero;
    }
    
    //Listeners de botones
    private void btnListoActionPerformed(DefaultTableModel dtmProveedor, final String[] vector){
        datos_Proveedor = new String[2];
        datos_Proveedor[0] = dtmProveedor.getValueAt(0, 0)+"";
        datos_Proveedor[1] = dtmProveedor.getValueAt(0, 1)+"";
        
        JPanel pFecha_C = new JPanel();
        JPanel panel = new JPanel();
        JPanel pProductos = new JPanel();
        JLabel lblFecha_C = new JLabel();
        JLabel lblProductos = new JLabel();
        JLabel lblEspacio = new JLabel();
        btnNueva_fila = new JButton();
        com.toedter.calendar.JDateChooser jdchFecha_C = new com.toedter.calendar.JDateChooser();
        
        lblFecha_C.setText  ("Fecha de la compra");
        lblProductos.setText("Productos                  ");
        lblEspacio.setText("");
        jdchFecha_C.setDateFormatString("dd/MM/yyyy");
        
        jdchFechas_C.add(jdchFecha_C);
        
        Compras Q = new Compras();
        P = Q.creanodo(0, P, Q);
        
        btnNueva_fila.setText("  +  ");
        
        final DefaultTableModel modelo = (DefaultTableModel) tNueva_compra.getModel();
        //nFilas.add(n);
        btnNueva_fila.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnNueva_FilaActionPerformed(modelo, vector, cbProdutos, tNueva_compra, P.indiceF);
                
            }
            
        });
        
        //JPaneles
        pFecha_C.setLayout(new BorderLayout());
        pFecha_C.add(lblEspacio, BorderLayout.NORTH);
        pFecha_C.add(lblFecha_C, BorderLayout.WEST);
        pFecha_C.add(jdchFechas_C.get(nProveedores), BorderLayout.CENTER);
        
        pProductos.setLayout(new BorderLayout());
        pProductos.add(pFecha_C, BorderLayout.NORTH);
        pProductos.add(lblProductos, BorderLayout.WEST);
        pProductos.add(cbProdutos, BorderLayout.CENTER);
        pProductos.add(btnNueva_fila, BorderLayout.EAST);
        
        panel.setLayout(new BorderLayout());
        panel.add(sptNueva_Compra.get(nProveedores),BorderLayout.CENTER);
        panel.add(pProductos, BorderLayout.NORTH);
        
        tpCompras.addTab(datos_Proveedor[1], panel);
        codigos_Pro.add(datos_Proveedor[0]);
        
        nProveedores++;
        fProveedor.dispose();
        fProveedor = null;
        //Se guarda para registrar en base de datos     
    }
    
    private void btnNueva_FilaActionPerformed(DefaultTableModel modelo, String[] vector, JComboBox cb, JTable tabla, int[] indiceF){
        boolean valido = false;
        JPanel pNueva_Fila = new JPanel();
            JPanel pPrecio = new JPanel();
            JPanel pCantidad = new JPanel();
            
            JTextField txtCantidad = new JTextField();
            JTextField txtPrecio = new JTextField();
            JLabel lblCantidad = new JLabel();
            JLabel lblPrecio = new JLabel();
            
            //label's
            lblCantidad.setText("Cantidad");
            lblPrecio.setText  ("Precio  ");
            
            pPrecio.setLayout(new BorderLayout());
            pPrecio.add(lblPrecio, BorderLayout.WEST);
            pPrecio.add(txtPrecio, BorderLayout.CENTER);
            
            pCantidad.setLayout(new BorderLayout());
            pCantidad.add(lblCantidad, BorderLayout.WEST);
            pCantidad.add(txtCantidad, BorderLayout.CENTER);
            
            pNueva_Fila.setLayout(new BorderLayout());
            pNueva_Fila.add(pPrecio, BorderLayout.NORTH);
            pNueva_Fila.add(pCantidad, BorderLayout.CENTER);
            
        while (valido == false){
            JOptionPane.showMessageDialog(null,pNueva_Fila, "Cantidad y Precio", JOptionPane.QUESTION_MESSAGE);
            int cantidad = validarint(txtCantidad.getText());//validar cantidad
            double precio = validardouble(txtPrecio.getText());

            if (cantidad > 0 && precio >= 0){
                String item = cb.getSelectedItem() + "";
                String codigo = "";
                String nombre = "";
                int indice = 0;

                for (int i = 0; i<item.length(); i++){
                    if (item.charAt(i) != '-' && item.charAt(i+1) != '-'){
                        codigo += item.charAt(i);
                    }
                    else{
                        codigo += item.charAt(i);
                        indice = i;
                        break;
                    }
                }

                for (int i = indice+3; i<item.length(); i++){
                     nombre += item.charAt(i);
                }

                tabla.getModel().setValueAt(codigo, indiceF[0], 0);
                tabla.getModel().setValueAt(nombre, indiceF[0], 1);
                
                
                modelo.addRow(vector);

                indiceF[0]++;
                valido = true;
            }
            else{
                txtCantidad.setText("");
                txtPrecio.setText("");
            }
        }    
    }
    
    private void btnNueva_compraActionPerformed (String[] vector) throws SQLException{
        nuevaCompra(vector);
        
        fProveedor = fNombre_proveedor(vector, fProveedor);
        fProveedor.setVisible(true);
        fProveedor.setLocationRelativeTo(null);
        fProveedor.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); 
        //Limpiar ventana
    }
    
    private void btnRegistrarActionPerformed (Connection con, String sql){
       try {
            // TODO add your handling code here:
            //Se registra todo en las tablas de las bases de datos
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException ex) {
            
            Logger.getLogger(Panel_Nueva_Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Connection con;
    private ArrayList<String> codigos_Pro;
    private JComboBox cbProdutos;
    
    private Compras P;
      
    private int nProveedores;
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
    private ArrayList<com.toedter.calendar.JDateChooser> jdchFechas_C;
    
    private JFrame fNombre_proveedor;
    
}
