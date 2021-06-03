/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels_menu_principal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Eduardo Elias Hernandez Moreno
 */
public class Panel_Actualizar_Datos{
    
    public Panel_Actualizar_Datos (String nombre_Panel, JMenuItem menuItem, Connection con) throws SQLException{   
        this.con = con;
        this.menuItem = menuItem;
        
        nFilas = 0;
        initComponents();
        
        if (nombre_Panel.equals("Actualizar_Precio_P")){
            pPrincipal = PActualizar_Producto();
        }
        else{
            if (nombre_Panel.equals("Actualizar_Precio_S")){
                pPrincipal = PActualizar_Servicio();            
            }
            else{
                if (nombre_Panel.equals("Actualizar_Numero_Tel_Cl")){
                    pPrincipal = PActualizar_Cliente();               
                }
                else {
                    if (nombre_Panel.equals("Actualizar_Numero_Tel_Pro")){
                        pPrincipal = PActualizar_Proveedor("No_Tel_Pro");                        
                    }
                    else{
                        if (nombre_Panel.equals("Actualizar_Direccion_Pro")){
                            pPrincipal = PActualizar_Proveedor("Direccion_Pro");
                        }
                    }
                }
            }   
        }
    }
    
    private void initComponents() {
        pPrincipal = new JPanel();
        lblTitulo = new JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tTabla = new javax.swing.JTable();
        lblEspacio1 = new JLabel();
        lblEspacio2 = new JLabel();
        btnActualizar = new JButton();
        btnNuevaFila = new JButton();
    }
    
    private JPanel PActualizar_Producto () throws SQLException{
        JPanel pNORTH = new JPanel();
        JPanel panel;
        JPanel pSOUTH = new JPanel();
        
        //variables para JTable
        final String[] vector = {null, null, null};
        final boolean[] editable = {false, false, true};
        final int nColumnas = 3;
        String[] columnas = new String[nColumnas];
        
        nombreT = "producto";
        
        //labels
        lblTitulo.setText("           Actualizar precio de Producto");
        lblEspacio1.setText("           ");
        lblEspacio2.setText("           ");       
        
        //JTable
        columnas[0] = "Codigo_P";
        columnas[1] = "NOMBRE_P";
        columnas[2] = "Precio_P";
        
        tTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                columnas[0], columnas[1], columnas[2]
            }
        ){
            @Override
            public boolean isCellEditable(int row, int column){
                return editable[column];
            }
        });
        jScrollPane1.setViewportView(tTabla);

        //JComboBox
        final JComboBox cb = comboBoxSeleccionar(columnas, nombreT);
        
        final javax.swing.table.DefaultTableModel dtmTable = (DefaultTableModel) tTabla.getModel();

        //Botones
         btnNuevaFila.setText("Nueva Fila");
        btnNuevaFila.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] datos = {"", "", ""};
                btnNuevaFilaActionPerformed(dtmTable, vector, datos, cb, nColumnas); 
            }
        });
        
        final String[] columnas1 = columnas;
        final int nColumnaActualizar = 2;
        
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    for (int i = 0; i < nFilas; i++){
                        String sqlAct = "UPDATE " + nombreT + " SET " + columnas1[nColumnaActualizar] + "='" + dtmTable.getValueAt(i, nColumnaActualizar) 
                                + "' WHERE " + columnas1[0] + "='" + dtmTable.getValueAt(i, 0)+"'";
                        btnActualizarActionPerformed(con, sqlAct, "Precio_P");
                    }   
                } catch (SQLException ex) {
                    Logger.getLogger(Panel_Actualizar_Datos.class.getName()).log(Level.SEVERE, null, ex);
                }    
            }                     
        });

        //Paneles
        panel = organizarPanel(pNORTH, pSOUTH, cb);

        return panel;
    }
    
    private JPanel PActualizar_Servicio () throws SQLException{
        JPanel pNORTH = new JPanel();
        JPanel panel;
        JPanel pSOUTH = new JPanel();
        
        //Variables para JTable
        final String[] vector = {null, null, null};
        final boolean[] editable = {false, false, true};
        final int nColumnas = 3;
        String[] columnas = new String[nColumnas];
        
        nombreT = "servicio";
        
        //labels
        lblTitulo.setText("           Actualizar precio de servicio");
        lblEspacio1.setText("           ");
        lblEspacio2.setText("           ");

        //Consultar numero de ultimo cliente
        

        //JTable
        columnas[0] = "Codigo_S";
        columnas[1] = "Nombre_S";
        columnas[2] = "Precio_S";
        
        tTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                vector
            },
            new String [] {
                columnas[0], columnas[1], columnas[2]
            }
        ){
            @Override
            public boolean isCellEditable(int row, int column){
                return editable[column];
            }
        });
        
        jScrollPane1.setViewportView(tTabla);
        
        //JComboBox
        final JComboBox cb = comboBoxSeleccionar(columnas, nombreT);
        
        final javax.swing.table.DefaultTableModel dtmTable = (DefaultTableModel) tTabla.getModel();
        
        //Botones
        btnNuevaFila.setText("Nueva Fila");
        btnNuevaFila.addActionListener(new java.awt.event.ActionListener() {          
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] datos = {"", "", ""};
                btnNuevaFilaActionPerformed(dtmTable, vector, datos, cb, nColumnas); 
            }
        });
        
        final String[] columnas1 = columnas;
        final int nColumnaActualizar = 2;
        
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {    
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    for (int i = 0; i < nFilas; i++){
                        String sqlAct = "UPDATE " + nombreT + " SET " + columnas1[nColumnaActualizar] + "='" + dtmTable.getValueAt(i, nColumnaActualizar) 
                                + "' WHERE " + columnas1[0] + "='" + dtmTable.getValueAt(i, 0)+"'";
                        btnActualizarActionPerformed(con, sqlAct, "Precio_P");
                    }   
                } catch (SQLException ex) {
                    Logger.getLogger(Panel_Actualizar_Datos.class.getName()).log(Level.SEVERE, null, ex);
                }    
            }
        });

        //Paneles
        panel = organizarPanel(pNORTH, pSOUTH, cb);

        return panel;
    }

    //Panel Nuevo_Cliente
    private JPanel PActualizar_Cliente () throws SQLException{
        JPanel pSOUTH = new JPanel();
        JPanel panel; 
        JPanel pNORTH = new JPanel();
        
        //Variables para JTable
        final String[] vector = {null, null, null};
        final boolean[] editable = {false, false, true};
        final int nColumnas = 3;
        String[] columnas = new String[nColumnas];
        
        nombreT = "cliente";
        
        //labels
        lblTitulo.setText("           Actualizar telefono de Cliente");
        lblEspacio1.setText("           ");
        lblEspacio2.setText("           ");

        //Consultar numero de ultimo cliente
        
        //JTable
        columnas[0] = "Numero_Cl";
        columnas[1] = "Nombre_Cl";
        columnas[2] = "Telefono_Cl";
        
        tTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                
            },
            new String [] {
                columnas[0], columnas[1], columnas[2]
            }){
                @Override
                public boolean isCellEditable(int row, int column){
                    return editable[column];
                }
        });
        
        jScrollPane1.setViewportView(tTabla);
        
        final JComboBox cb = comboBoxSeleccionar(columnas, nombreT);       
         
        final javax.swing.table.DefaultTableModel dtmTable = (DefaultTableModel) tTabla.getModel();
        
        //Botones
        btnNuevaFila.setText("Nueva Fila");
        btnNuevaFila.addActionListener(new java.awt.event.ActionListener() {          
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] datos = {"", "", ""};
                btnNuevaFilaActionPerformed(dtmTable, vector, datos, cb, nColumnas); 
            }
        });
        
        final String[] columnas1 = columnas;
        final int nColumnaActualizar = 2;
        
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {    
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    for (int i = 0; i < nFilas; i++){
                        String sqlAct = "UPDATE " + nombreT + " SET " + columnas1[nColumnaActualizar] + "='" + dtmTable.getValueAt(i, nColumnaActualizar) 
                                + "' WHERE " + columnas1[0] + "='" + dtmTable.getValueAt(i, 0)+"'";
                        btnActualizarActionPerformed(con, sqlAct, "Precio_P");
                    }   
                } catch (SQLException ex) {
                    Logger.getLogger(Panel_Actualizar_Datos.class.getName()).log(Level.SEVERE, null, ex);
                }    
            }
        });
        
        //Paneles
        panel = organizarPanel(pNORTH, pSOUTH, cb);
        
        return panel;
    }
    
    private JPanel PActualizar_Proveedor (final String columna) throws SQLException{
        JPanel pNORTH = new JPanel();
        JPanel panel;
        JPanel pSOUTH = new JPanel();
        
        //variables para JTable
        final String[] vector = {null, null, null};
        final boolean[] editable = {false, false, true};
        final int nColumnas = 3;
        String[] columnas = new String[nColumnas];
       
        nombreT = "proveedor";  

        //labels
        lblTitulo.setText("           Actualizar "+ columna+" de proveedor");
        lblEspacio1.setText("           ");
        lblEspacio2.setText("           ");

        //JTable
        
        if (columna.equals("No_Tel_Pro")){
            columnas[0] = "Codigo_Pro";
            columnas[1] = "Nombre_Pro";
            columnas[2] = columna;
            
            tTabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    
                },
                new String [] {
                    columnas[0], columnas[1], columnas[2]
                }
                ){
                    @Override
                    public boolean isCellEditable(int row, int column){
                        return editable[column];
                    }
            });
        }
        else{
            if (columna.equals("Direccion_Pro")){
                columnas[0] = "Codigo_Pro";
                columnas[1] = "Nombre_Pro";
                columnas[2] = columna;
                
                tTabla.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {
                        vector
                    },
                    new String [] {
                        columnas[0], columnas[1], columnas[2]
                    }
                    ){
                        @Override
                        public boolean isCellEditable(int row, int column){
                            return editable[column];
                        }
                });             
            }
        }
        jScrollPane1.setViewportView(tTabla);
        
        //JComboBox
        final JComboBox cb = comboBoxSeleccionar(columnas, nombreT);
        
        final javax.swing.table.DefaultTableModel dtmTable = (DefaultTableModel) tTabla.getModel();
        
        //Botones
        btnNuevaFila.setText("Nueva Fila");
        btnNuevaFila.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] datos = {"", "", ""}; 
                btnNuevaFilaActionPerformed(dtmTable, vector, datos, cb, nColumnas);
            }
        });
        
        final String[] columnas1 = columnas;
        final int nColumnaActualizar = 2;
        
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try { 
                    for (int i = 0; i < nFilas; i++){
                        String sqlAct = "UPDATE " + nombreT + " SET " + columnas1[nColumnaActualizar] + "='" + dtmTable.getValueAt(i, nColumnaActualizar) 
                                + "' WHERE " + columnas1[0] + "='" + dtmTable.getValueAt(i, 0)+"'";
                        btnActualizarActionPerformed(con, sqlAct, columna);
                    }   
                } catch (SQLException ex) {
                    Logger.getLogger(Panel_Actualizar_Datos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        //Paneles
        panel = organizarPanel(pNORTH, pSOUTH, cb);
        
        return panel;
    }
    
    private JComboBox comboBoxSeleccionar (String[] columnas, String nombreT) throws SQLException{
        JComboBox cbSeleccionar = new JComboBox();
        
        //cambio nombreT por indice
        String sql;

        sql = "SELECT "+columnas[0]+", "+columnas[1]+", "+columnas[2]+" FROM " + nombreT;

        final ResultSet rs = consultar(sql);
        while (rs.next() == true){
            try {
                cbSeleccionar.addItem(rs.getString(columnas[0]) + "--" + rs.getString(columnas[1]) + "--" + rs.getString(columnas[2]));

            } catch (SQLException ex) {
                Logger.getLogger(Panel_Nueva_Venta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return cbSeleccionar;
    }
    
    private void obtenerDatos_Tablas (JComboBox comboBox, String[] datos){
        String item = comboBox.getSelectedItem()+"";
        int indice = 0;
        
        //Se recorre item
        //Se obtiene codigo
        for (int i = 0; i<item.length(); i++){
            if (item.charAt(i) != '-' && item.charAt(i+1) != '-'){
                datos[0] += item.charAt(i);
            } 
            else {
                datos[0] += item.charAt(i);
                indice = i;     
                break;
            }
        }
        
        //se obtiene nombre
        for (int i = indice + 3; i < item.length(); i++) {
            if (item.charAt(i) != '-' && item.charAt(i+1) != '-'){
                datos[1] += item.charAt(i);
            } 
            else {
                datos[1] += item.charAt(i);
                indice = i;     
                break;
            }
        }
        
        for (int i = indice + 3; i < item.length(); i++) {
            datos[2] += item.charAt(i);
        }
        
    }
        
    private ResultSet consultar (String sql) throws SQLException{
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        return rs;
    }
    
    private JPanel organizarPanel (JPanel pNORTH, JPanel pSOUTH,  JComboBox cb){
        JPanel panel = new JPanel();
        /*pNORTH*/
        pNORTH.setLayout(new BorderLayout());
        pNORTH.add(lblTitulo, BorderLayout.NORTH);
        pNORTH.add(btnNuevaFila, BorderLayout.EAST);
        pNORTH.add(cb, BorderLayout.CENTER);
        
        /*pSOUTH*/
        pSOUTH.setLayout(new BorderLayout());
        pSOUTH.add(btnActualizar);
        
        panel.setLayout(new BorderLayout());
        panel.add(pNORTH, BorderLayout.NORTH);
        panel.add(lblEspacio1, BorderLayout.EAST);
        panel.add(lblEspacio2, BorderLayout.WEST);
        panel.add(jScrollPane1, BorderLayout.CENTER); 
        panel.add(pSOUTH, BorderLayout.SOUTH);
        
        return panel;
    }
     
    private void btnNuevaFilaActionPerformed (javax.swing.table.DefaultTableModel dtmTable, String[] vector, String[] datos, JComboBox cb, int nColumnas){       
        dtmTable.addRow(vector);
        nFilas ++;
        obtenerDatos_Tablas(cb, datos);
                
        for (int i = 0; i < nColumnas; i++){
            dtmTable.setValueAt(datos[i], nFilas-1, i);
        }
    }
    
    private void btnActualizarActionPerformed (Connection con, String sql, String columna) throws SQLException{
        try (PreparedStatement pStatement = (PreparedStatement) con.prepareStatement(sql)) {
            pStatement.executeUpdate(sql);  
            JOptionPane.showMessageDialog(null, "Actualizacion exitosa", "Actualizar " + columna +" de "+ nombreT, JOptionPane.INFORMATION_MESSAGE);
            menuItem.doClick();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Actualizacion fallida", "Actualizar " + columna +" de "+ nombreT, JOptionPane.INFORMATION_MESSAGE);
        }
        
    }  
    
    // Variables declaration - do not modify
    private Connection con;
    private int nFilas;
    String nombreT;
    private JMenuItem menuItem;
    
    private JLabel lblEspacio1;
    private JLabel lblEspacio2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tTabla;
    private JLabel lblTitulo;
    public JPanel pPrincipal;
    private JButton btnNuevaFila;
    private JButton btnActualizar;
    private int ultimo_Cliente;
    // End of variables declaration   
}
