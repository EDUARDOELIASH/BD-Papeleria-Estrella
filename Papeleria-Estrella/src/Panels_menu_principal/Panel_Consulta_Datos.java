/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels_menu_principal;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import papeleria_estrella.Conectar;

/**
 *
 * @author Eduardo Elias Hernandez Moreno
 */
public class Panel_Consulta_Datos{
    
    public Panel_Consulta_Datos (String nombre_Panel, Connection con){   
        this.con = con;
        nFilas = 1;
        if (nombre_Panel.equals("Consultar_Producto")){
            pPrincipal = PConsultar_Producto();
            btnNuevaFila.doClick();
            btnConsultar.doClick();
        }
        else{
            if (nombre_Panel.equals("Consultar_Servicio")){
                pPrincipal = PConsultar_Servicio();
                btnNuevaFila.doClick();
                btnConsultar.doClick();
            }
            else{
                if (nombre_Panel.equals("Consultar_Cliente")){
                    pPrincipal = PConsultar_Cliente();
                    btnNuevaFila.doClick();
                    btnConsultar.doClick();
                }
                else {
                    if (nombre_Panel.equals("Consultar_Proveedor")){
                        pPrincipal = PConsultar_Proveedor();
                        btnNuevaFila.doClick();
                        btnConsultar.doClick();
                    }
                    else {
                        if (nombre_Panel.equals("Consultar_Inventario")){
                            pPrincipal = PConsultar_Inventario();
                            btnNuevaFila.doClick();
                            btnConsultar.doClick();
                        }
                    }
                }
            }   
        }
    }
    
    private JPanel PConsultar_Producto (){
        JPanel panel = new JPanel();
        
        lblTitulo = new JLabel();
        pSur = new JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tTabla = new javax.swing.JTable();
        lblEspacio1 = new JLabel();
        lblEspacio2 = new JLabel();
        btnConsultar = new JButton();
        btnNuevaFila = new JButton();
        
        //labels
        lblTitulo.setText("           Consultar Producto");
        lblEspacio1.setText("           ");
        lblEspacio2.setText("           ");

        //Consultar numero de ultimo cliente
        
        final String[] vector = {null, null, null};
        //JTable
        tTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                vector,
            },
            new String [] {
                "Codigo_P", "Nombre_P", "Precio_P"
            }
        ));
        tTabla.enable(false);
        jScrollPane1.setViewportView(tTabla);

        final javax.swing.table.DefaultTableModel dtmTable = (DefaultTableModel) tTabla.getModel();

        //Botones
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                ResultSet rs=null;
                Statement sentencia=null;
                String sql = "Select Codigo_P, Nombre_P, Precio_P From producto where Precio_P is not null and NOMBRE_P is not null";
                try {
                    sentencia=(Statement) con.createStatement();
                    rs=sentencia.executeQuery(sql);
                } catch (SQLException ex) { 
                    Logger.getLogger(Panel_Consulta_Datos.class.getName()).log(Level.SEVERE, null, ex);
                }
                for (int i = 0; i < nFilas; i++) {   
                    try {
                        if(rs.next()&&rs!=null){
                            dtmTable.setValueAt(rs.getString("Codigo_P"), i, 0);
                            dtmTable.setValueAt(rs.getString("Nombre_P"), i, 1);
                            dtmTable.setValueAt(rs.getDouble("Precio_P"), i, 2);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Panel_Consulta_Datos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                  /* Verificar datos de tabla
                    try {
                        btnConsultarActionPerformed(e, con, sql);
                    } catch (SQLException ex) {
                        Logger.getLogger(Panel_Consulta_Datos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  */             
                }
                
            }
        });

        btnNuevaFila.setText("Nueva Fila");
        btnNuevaFila.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultSet rs=null;
                Statement sentencia=null;
                String sql = "Select count(*) as filas From producto"; 
                try {
                    sentencia=(Statement) con.createStatement();
                    rs=sentencia.executeQuery(sql);
                    rs.next();
                    int Filas = rs.getInt("Filas");
                    rs.close();
                    for(int i=0;i<Filas;i++){
                        btnNuevaFilaActionPerformed(e, dtmTable, vector); 
                    }
                } catch (SQLException ex) { 
                    Logger.getLogger(Panel_Consulta_Datos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });


        //Paneles
        panel.setLayout(new java.awt.BorderLayout());

        panel.add(lblTitulo, java.awt.BorderLayout.NORTH);
        panel.add(lblEspacio1, java.awt.BorderLayout.EAST);
        panel.add(lblEspacio2, java.awt.BorderLayout.WEST);

        panel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        //panel.add(pSur, java.awt.BorderLayout.SOUTH);

        /*Panel parte inferior*/
        pSur.setLayout(new java.awt.GridLayout(1, 3));
        pSur.add(btnNuevaFila);
        pSur.add(btnConsultar);

        return panel;
    }
    
    private JPanel PConsultar_Servicio (){
        JPanel panel = new JPanel();
        
        lblTitulo = new JLabel();
        pSur = new JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tTabla = new javax.swing.JTable();
        lblEspacio1 = new JLabel();
        lblEspacio2 = new JLabel();
        btnConsultar = new JButton();
        btnNuevaFila = new JButton();
        
        //labels
        lblTitulo.setText("           Consultar Servicio");
        lblEspacio1.setText("           ");
        lblEspacio2.setText("           ");

        //Consultar numero de ultimo cliente
        
        final String[] vector = {null, null, null};
        //JTable
        tTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                vector
            },
            new String [] {
                "Codigo_S", "Nombre_S", "Precio_S"
            }
        ));
        tTabla.enable(false);
        jScrollPane1.setViewportView(tTabla);
        
        final javax.swing.table.DefaultTableModel dtmTable = (DefaultTableModel) tTabla.getModel();
        
        //Botones
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultSet rs=null;
                Statement sentencia=null;
                String sql = "Select Codigo_S, Nombre_S, Precio_S From servicio where Nombre_S is not null";
                try {
                    sentencia=(Statement) con.createStatement();
                    rs=sentencia.executeQuery(sql);
                } catch (SQLException ex) { 
                    Logger.getLogger(Panel_Consulta_Datos.class.getName()).log(Level.SEVERE, null, ex);
                }
                for (int i = 0; i < nFilas; i++) {   
                    try {
                        if(rs.next()&&rs!=null){
                            dtmTable.setValueAt(rs.getString("Codigo_S"), i, 0);
                            dtmTable.setValueAt(rs.getString("Nombre_S"), i, 1);
                            dtmTable.setValueAt(rs.getDouble("Precio_S"), i, 2);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Panel_Consulta_Datos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });


        btnNuevaFila.setText("Nueva Fila");
        btnNuevaFila.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultSet rs=null;
                Statement sentencia=null;
                String sql = "Select count(*) as filas From servicio"; 
                try {
                    sentencia=(Statement) con.createStatement();
                    rs=sentencia.executeQuery(sql);
                    rs.next();
                    int Filas = rs.getInt("Filas");
                    rs.close();
                    for(int i=0;i<Filas;i++){
                        btnNuevaFilaActionPerformed(e, dtmTable, vector); 
                    }
                } catch (SQLException ex) { 
                    Logger.getLogger(Panel_Consulta_Datos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        //Paneles
        panel.setLayout(new java.awt.BorderLayout());

        panel.add(lblTitulo, java.awt.BorderLayout.NORTH);
        panel.add(lblEspacio1, java.awt.BorderLayout.EAST);
        panel.add(lblEspacio2, java.awt.BorderLayout.WEST);

        panel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        //panel.add(pSur, java.awt.BorderLayout.SOUTH);

        /*Panel parte inferior*/
        pSur.setLayout(new java.awt.GridLayout(1, 3));
        pSur.add(btnNuevaFila);
        pSur.add(btnConsultar);

        return panel;
    }

    //Panel Nuevo_Cliente
    private JPanel PConsultar_Cliente (){
        JPanel panel = new JPanel();    
        
        lblTitulo = new JLabel();
        pSur = new JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tTabla = new javax.swing.JTable();
        lblEspacio1 = new JLabel();
        lblEspacio2 = new JLabel();
        btnConsultar = new JButton();
        btnNuevaFila = new JButton();

        //labels
        lblTitulo.setText("           Consultar Cliente");
        lblEspacio1.setText("           ");
        lblEspacio2.setText("           ");

        //Consultar numero de ultimo cliente
 
        final String[] vector = {null, null, null};
        //JTable
        tTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
            },
            new String [] {
                "Numero_Cl", "Nombre_Cl", "Telefono_Cl"
            }
        ));
        tTabla.enable(false);
        jScrollPane1.setViewportView(tTabla);
        
        final javax.swing.table.DefaultTableModel dtmTable = (DefaultTableModel) tTabla.getModel();
        //Botones
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultSet rs=null;
                Statement sentencia=null;
                String sql = "Select Numero_Cl, Nombre_Cl, Telefono_Cl From cliente where Nombre_Cl is not null";
                try {
                    sentencia=(Statement) con.createStatement();
                    rs=sentencia.executeQuery(sql);
                } catch (SQLException ex) { 
                    Logger.getLogger(Panel_Consulta_Datos.class.getName()).log(Level.SEVERE, null, ex);
                }
                for (int i = 0; i < nFilas; i++) {   
                    try {
                        if(rs.next()&&rs!=null){
                            dtmTable.setValueAt(rs.getInt("Numero_Cl"), i, 0);
                            dtmTable.setValueAt(rs.getString("Nombre_Cl"), i, 1);
                            dtmTable.setValueAt(rs.getString("Telefono_Cl"), i, 2);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Panel_Consulta_Datos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });


        btnNuevaFila.setText("Nueva Fila");
        btnNuevaFila.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultSet rs=null;
                Statement sentencia=null;
                String sql = "Select count(*) as filas From cliente"; 
                try {
                    sentencia=(Statement) con.createStatement();
                    rs=sentencia.executeQuery(sql);
                    rs.next();
                    int Filas = rs.getInt("Filas");
                    rs.close();
                    for(int i=0;i<Filas;i++){
                        btnNuevaFilaActionPerformed(e, dtmTable, vector); 
                    }
                } catch (SQLException ex) { 
                    Logger.getLogger(Panel_Consulta_Datos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        //Paneles
        panel.setLayout(new java.awt.BorderLayout());

        panel.add(lblTitulo, java.awt.BorderLayout.NORTH);
        panel.add(lblEspacio1, java.awt.BorderLayout.EAST);
        panel.add(lblEspacio2, java.awt.BorderLayout.WEST);

        panel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

//        panel.add(pSur, java.awt.BorderLayout.SOUTH);

        /*Panel parte inferior*/
        pSur.setLayout(new java.awt.GridLayout(1, 3));
        pSur.add(btnNuevaFila);
        pSur.add(btnConsultar);
        
        return panel;
    }
    
    private JPanel PConsultar_Proveedor (){
        JPanel panel = new JPanel();
        
        pPrincipal = new JPanel();
        lblTitulo = new JLabel();
        pSur = new JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tTabla = new javax.swing.JTable();
        lblEspacio1 = new JLabel();
        lblEspacio2 = new JLabel();
        btnConsultar = new JButton();
        btnNuevaFila = new JButton();

        //labels
        lblTitulo.setText("           Consultar Proveedor");
        lblEspacio1.setText("           ");
        lblEspacio2.setText("           ");

        //Consultar numero de ultimo cliente

        final String[] vector = {null, null, null, null};
        //JTable
        tTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                vector
            },
            new String [] {
                "Codigo_Pro", "Nombre_Pro", "No_Telefono_Pro", "Direccion_Pro"
            }
        ));
        tTabla.enable(false);
        jScrollPane1.setViewportView(tTabla);
        
        final javax.swing.table.DefaultTableModel dtmTable = (DefaultTableModel) tTabla.getModel();
        //Botones
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultSet rs=null;
                Statement sentencia=null;
                String sql = "Select Codigo_Pro, Nombre_Pro, No_Tel_Pro, Direccion_Pro From proveedor Where Nombre_Pro is not null";
                try {
                    sentencia=(Statement) con.createStatement();
                    rs=sentencia.executeQuery(sql);
                } catch (SQLException ex) { 
                    Logger.getLogger(Panel_Consulta_Datos.class.getName()).log(Level.SEVERE, null, ex);
                }
                for (int i = 0; i < nFilas; i++) {   
                    try {
                        if(rs.next()&&rs!=null){
                            dtmTable.setValueAt(rs.getString("Codigo_Pro"), i, 0);
                            dtmTable.setValueAt(rs.getString("Nombre_Pro"), i, 1);
                            dtmTable.setValueAt(rs.getString("No_Tel_Pro"), i, 2);
                            dtmTable.setValueAt(rs.getString("Direccion_Pro"), i, 3);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Panel_Consulta_Datos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });


        btnNuevaFila.setText("Nueva Fila");
        btnNuevaFila.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultSet rs=null;
                Statement sentencia=null;
                String sql = "Select count(*) as filas From proveedor"; 
                try {
                    sentencia=(Statement) con.createStatement();
                    rs=sentencia.executeQuery(sql);
                    rs.next();
                    int Filas = rs.getInt("Filas");
                    rs.close();
                    for(int i=0;i<Filas;i++){
                        btnNuevaFilaActionPerformed(e, dtmTable, vector); 
                    }
                } catch (SQLException ex) { 
                    Logger.getLogger(Panel_Consulta_Datos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        //Paneles
        panel.setLayout(new java.awt.BorderLayout());

        panel.add(lblTitulo, java.awt.BorderLayout.NORTH);
        panel.add(lblEspacio1, java.awt.BorderLayout.EAST);
        panel.add(lblEspacio2, java.awt.BorderLayout.WEST);

        panel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        //panel.add(pSur, java.awt.BorderLayout.SOUTH);

        /*Panel parte inferior*/
        pSur.setLayout(new java.awt.GridLayout(1, 3));
        pSur.add(btnNuevaFila);
        pSur.add(btnConsultar);
        
        return panel;
    }
    
    private JPanel PConsultar_Inventario (){
        JPanel panel = new JPanel();
        
        lblTitulo = new JLabel();
        pSur = new JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tTabla = new javax.swing.JTable();
        lblEspacio1 = new JLabel();
        lblEspacio2 = new JLabel();
        btnConsultar = new JButton();
        btnNuevaFila = new JButton();
        
        //labels
        lblTitulo.setText("           Consultar Inventario");
        lblEspacio1.setText("           ");
        lblEspacio2.setText("           ");

        //Consultar numero de ultimo cliente
        
        final String[] vector = {null, null, null};
        //JTable
        tTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                vector,
            },
            new String [] {
                "Codigo Producto", "Nombre Producto", "Existencia"
            }
        ));
        tTabla.enable(false);
        jScrollPane1.setViewportView(tTabla);

        final javax.swing.table.DefaultTableModel dtmTable = (DefaultTableModel) tTabla.getModel();

        //Botones
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                ResultSet rs=null;
                Statement sentencia=null;
                String sql = "Select Codigo_P, Nombre_P, Existencia_P From producto where Precio_P is not null and NOMBRE_P is not null";
                try {
                    sentencia=(Statement) con.createStatement();
                    rs=sentencia.executeQuery(sql);
                } catch (SQLException ex) { 
                    Logger.getLogger(Panel_Consulta_Datos.class.getName()).log(Level.SEVERE, null, ex);
                }
                for (int i = 0; i < nFilas; i++) {   
                    try {
                        if(rs.next()&&rs!=null){
                            dtmTable.setValueAt(rs.getString("Codigo_P"), i, 0);
                            dtmTable.setValueAt(rs.getString("Nombre_P"), i, 1);
                            dtmTable.setValueAt(rs.getInt("Existencia_P"), i, 2);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Panel_Consulta_Datos.class.getName()).log(Level.SEVERE, null, ex);
                    }     
                }
                
            }
        });

        btnNuevaFila.setText("Nueva Fila");
        btnNuevaFila.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultSet rs=null;
                Statement sentencia=null;
                String sql = "Select count(*) as filas From producto"; 
                try {
                    sentencia=(Statement) con.createStatement();
                    rs=sentencia.executeQuery(sql);
                    rs.next();
                    int Filas = rs.getInt("Filas");
                    rs.close();
                    for(int i=0;i<Filas;i++){
                        btnNuevaFilaActionPerformed(e, dtmTable, vector); 
                    }
                } catch (SQLException ex) { 
                    Logger.getLogger(Panel_Consulta_Datos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });


        //Paneles
        panel.setLayout(new java.awt.BorderLayout());

        panel.add(lblTitulo, java.awt.BorderLayout.NORTH);
        panel.add(lblEspacio1, java.awt.BorderLayout.EAST);
        panel.add(lblEspacio2, java.awt.BorderLayout.WEST);

        panel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        //panel.add(pSur, java.awt.BorderLayout.SOUTH);

        /*Panel parte inferior*/
        pSur.setLayout(new java.awt.GridLayout(1, 3));
        pSur.add(btnNuevaFila);
        pSur.add(btnConsultar);

        return panel;
    }
     
    private void btnNuevaFilaActionPerformed (java.awt.event.ActionEvent evt, javax.swing.table.DefaultTableModel dtmTable, String[] vector){       
        dtmTable.addRow(vector);
        nFilas ++;
    }
    
    private void btnConsultarActionPerformed (java.awt.event.ActionEvent evt, Connection con, String sql) throws SQLException{
        try (Statement statement = con.createStatement()) {
            statement.executeUpdate(sql);   
        }
    }
    
    // Variables declaration - do not modify
    private Connection con;
    private int nFilas;
    
    private JLabel lblEspacio1;
    private JLabel lblEspacio2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tTabla;
    private JLabel lblTitulo;
    public JPanel pPrincipal;
    private JPanel pSur;
    private JButton btnNuevaFila;
    private JButton btnConsultar;
    private int ultimo_Cliente;
    // End of variables declaration   
}
