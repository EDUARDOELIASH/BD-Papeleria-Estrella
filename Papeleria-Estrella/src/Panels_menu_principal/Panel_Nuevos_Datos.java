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
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import metodos.Validacion_pNuevos;

/**
 *
 * @author Eduardo Elias Hernandez Moreno
 */
public class Panel_Nuevos_Datos{
    JMenuItem menuItem;
    
    public Panel_Nuevos_Datos (String nombre_Panel, Connection con, JMenuItem menuItem) throws SQLException{   
        this.menuItem = menuItem;
        this.con = con;
        nFilas = 1;
        if (nombre_Panel.equals("Nuevo_Producto")){
            pPrincipal = pNuevo_Producto();
        }
        else{
            if (nombre_Panel.equals("Nuevo_Servicio")){
                pPrincipal = pNuevo_Servicio();
            }
            else{
                if (nombre_Panel.equals("Nuevo_Cliente")){
                    pPrincipal = pNuevo_Cliente();
                }
                else {
                    if (nombre_Panel.equals("Nuevo_Proveedor")){
                        pPrincipal = pNuevo_Proveedor();
                    }
                }
            }   
        }
    }
    
    private JPanel pNuevo_Producto (){
        JPanel panel = new JPanel();
        
        lblTitulo = new JLabel();
        pSur = new JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tTabla = new javax.swing.JTable();
        lblEspacio1 = new JLabel();
        lblEspacio2 = new JLabel();
        btnRegistrar = new JButton();
        btnNuevaFila = new JButton();
        
        //labels
        lblTitulo.setText("           Nuevo Producto");
        lblEspacio1.setText("           ");
        lblEspacio2.setText("           ");

        //Consultar numero de ultimo cliente
        
        final String[] vector = {null, null, null};
        final DefaultTableModel newModelo = new DefaultTableModel(
            new Object [][] {
                vector
            },
            new String [] {
                "Codigo_P", "Nombre_P", "Precio_P"
            }
        );
         
        
        final DefaultTableModel dtmTable = newModelo;
        
        //JTable
        tTabla.setModel(dtmTable);
        tTabla.setFocusable(false); 
        jScrollPane1.setViewportView(tTabla);
 

        //Botones
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < nFilas; i++) {
                    //Verificar datos de tabla 
                    //codigo producto cumple con tamaño asignado 11 digitos
                    
                    //Precio_P es un numero entero
                    
                    String sql = "INSERT INTO producto VALUES('"+ dtmTable.getValueAt(i, 0)+"','"+ dtmTable.getValueAt(i, 1)+"',"+ 0 +","+dtmTable.getValueAt(i, 2)+")";
                            
                    try {
                        btnRegistrarActionPerformed(con, sql);
                    } catch (SQLException ex) {
                        Logger.getLogger(Panel_Nuevos_Datos.class.getName()).log(Level.SEVERE, null, ex);
                    }               
                }
                JOptionPane.showMessageDialog(null, "Registro de productos exitoso");
                menuItem.doClick();
            }
        });


        btnNuevaFila.setText("Nueva Fila");
        btnNuevaFila.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnNuevaFilaActionPerformed(e, dtmTable, vector);
            }
        });
        

        //Paneles
        panel.setLayout(new java.awt.BorderLayout());

        panel.add(lblTitulo, java.awt.BorderLayout.NORTH);
        panel.add(lblEspacio1, java.awt.BorderLayout.EAST);
        panel.add(lblEspacio2, java.awt.BorderLayout.WEST);

        panel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panel.add(pSur, java.awt.BorderLayout.SOUTH);

        /*Panel parte inferior*/
        pSur.setLayout(new java.awt.GridLayout(1, 3));
        pSur.add(btnNuevaFila);
        pSur.add(btnRegistrar);

        return panel;
    }
    
    private JPanel pNuevo_Servicio (){
        JPanel panel = new JPanel();
        
        lblTitulo = new JLabel();
        pSur = new JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tTabla = new javax.swing.JTable();
        lblEspacio1 = new JLabel();
        lblEspacio2 = new JLabel();
        btnRegistrar = new JButton();
        btnNuevaFila = new JButton();

        //labels
        lblTitulo.setText("           Nuevo Servicio");
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
        tTabla.setFocusable(false);

        jScrollPane1.setViewportView(tTabla);
        
        final javax.swing.table.DefaultTableModel dtmTable = (DefaultTableModel) tTabla.getModel();
        //Botones
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < nFilas; i++) {
                    String sql = "INSERT INTO servicio VALUES('"+ dtmTable.getValueAt(i, 0)+"','"+ dtmTable.getValueAt(i, 1)+"',"+dtmTable.getValueAt(i, 2)+")";
                    //Verificar datos de tabla

                    try {
                        btnRegistrarActionPerformed(con, sql);
                    } catch (SQLException ex) {
                        Logger.getLogger(Panel_Nuevos_Datos.class.getName()).log(Level.SEVERE, null, ex);
                    }               
                }
                JOptionPane.showMessageDialog(null, "Registro de servicios exitoso");
                menuItem.doClick();
            }
        });


        btnNuevaFila.setText("Nueva Fila");
        btnNuevaFila.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnNuevaFilaActionPerformed(e, dtmTable, vector);
            }
        });

        //Paneles
        panel.setLayout(new java.awt.BorderLayout());

        panel.add(lblTitulo, java.awt.BorderLayout.NORTH);
        panel.add(lblEspacio1, java.awt.BorderLayout.EAST);
        panel.add(lblEspacio2, java.awt.BorderLayout.WEST);

        panel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panel.add(pSur, java.awt.BorderLayout.SOUTH);

        /*Panel parte inferior*/
        pSur.setLayout(new java.awt.GridLayout(1, 3));
        pSur.add(btnNuevaFila);
        pSur.add(btnRegistrar);

        return panel;
    }

    //Panel Nuevo_Cliente
    private JPanel pNuevo_Cliente () throws SQLException{
        JPanel panel = new JPanel();    
        
        lblTitulo = new JLabel();
        pSur = new JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tTabla = new javax.swing.JTable();
        lblEspacio1 = new JLabel();
        lblEspacio2 = new JLabel();
        btnRegistrar = new JButton();
        btnNuevaFila = new JButton();

        //labels
        lblTitulo.setText("           Nuevo Cliente");
        lblEspacio1.setText("           ");
        lblEspacio2.setText("           ");
        
       
        //Consultar numero de ultimo cliente
        final boolean[] editable = {false, true, true};
        final String[] vector = {null, null, null};
        
        //JTable
        tTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
            },
            new String [] {
                "Numero_Cl", "Nombre_Cl", "Telefono_Cl"
            }
        ){
            @Override
            public boolean isCellEditable(int row, int column){
                return editable[column];
            }
        });
        tTabla.setFocusable(false);
        
        jScrollPane1.setViewportView(tTabla);
        
        final javax.swing.table.DefaultTableModel dtmTabla = (DefaultTableModel) tTabla.getModel();
        final int Numero_Cl = consultarU_Numero_Cl(con);
        dtmTabla.setValueAt(Numero_Cl, nFilas-1, 0);
        
        
        
        //Botones
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            //Falta validar datos
            @Override
            public void actionPerformed(ActionEvent e) {
                //Validar datos de tabla
                boolean datosV = false;
                final int nCaracteresCodigo = 5;
                final int nCaracteresTelefono = 10;
                
                for (int i = 0; i < nFilas; i++) {
                    if (vCampoNoVacio(dtmTabla.getValueAt(i, 1)+"")){//Nombre cliente no vacio                     
                        if (vCodigo(dtmTabla.getValueAt(i, 3)+"", nCaracteresTelefono)){//Numero de telefono valido
                            datosV = true;
                        }
                        else JOptionPane.showMessageDialog(null, "Numero de telefono debe ser de "+nCaracteresTelefono+" digitos");
                    }
                    else JOptionPane.showMessageDialog(null, "Nombre de cliente vacio"); 
                }
                
                //Datos son valido
                if (datosV == true){
                    for (int i = 0; i < nFilas; i++){
                        try {
                            String sql = "INSERT INTO cliente VALUES("+dtmTabla.getValueAt(i, 0)+",'"+ dtmTabla.getValueAt(i, 1)+"','"+dtmTabla.getValueAt(i, 2)+"')";  
                            btnRegistrarActionPerformed(con, sql);
                        } catch (SQLException ex) {
                            Logger.getLogger(Panel_Nuevos_Datos.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Registro de clientes exitoso");
                    menuItem.doClick();
                }
            }
        });

        btnNuevaFila.setText("Nueva Fila");
        btnNuevaFila.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnNuevaFilaActionPerformed(e, dtmTabla, vector);
                final int newNumero_Cl = Numero_Cl + nFilas-1;
                dtmTabla.setValueAt(newNumero_Cl, nFilas-1, 0);
            }
        });
        
        //Paneles
        panel.setLayout(new java.awt.BorderLayout());

        panel.add(lblTitulo, java.awt.BorderLayout.NORTH);
        panel.add(lblEspacio1, java.awt.BorderLayout.EAST);
        panel.add(lblEspacio2, java.awt.BorderLayout.WEST);

        panel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panel.add(pSur, java.awt.BorderLayout.SOUTH);

        /*Panel parte inferior*/
        pSur.setLayout(new java.awt.GridLayout(1, 3));
        pSur.add(btnNuevaFila);
        pSur.add(btnRegistrar);
        
        return panel;
    }
    
    private JPanel pNuevo_Proveedor (){
        JPanel panel = new JPanel();
        
        pPrincipal = new JPanel();
        lblTitulo = new JLabel();
        pSur = new JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tTabla = new javax.swing.JTable();
        lblEspacio1 = new JLabel();
        lblEspacio2 = new JLabel();
        btnRegistrar = new JButton();
        btnNuevaFila = new JButton();

        //labels
        lblTitulo.setText("           Nuevo Proveedor");
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
        tTabla.setFocusable(false);

        jScrollPane1.setViewportView(tTabla);
        
        final javax.swing.table.DefaultTableModel dtmTabla = (DefaultTableModel) tTabla.getModel();
        //Botones
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Validar datos de tabla
                final int nCaracteresCodigo = 5;
                final int nCaracteresTelefono = 10;
                String error="";
                
                for (int i = 0; i < nFilas; i++) {
                    if (vCodigo(dtmTabla.getValueAt(i, 0)+"", nCaracteresCodigo)==false){//Codigo proveedor valido
                        error += "Codigo proveedor fila "+i+" debe ser de "+nCaracteresCodigo+" digitos\n";
                    }
                    if (vCampoNoVacio(dtmTabla.getValueAt(i, 1)+"")==false){//Nombre proveedor no vacio
                        error += "Nombre de proveedor fila "+i+" vacio\n";    
                    }
                    if (vCampoNoVacio(dtmTabla.getValueAt(i, 2)+"")==false){//Direccion proveedor no vacio
                        error += "Direccion de proveedor fila "+i+" vacio\n";
                    }
                    if (vCodigo(dtmTabla.getValueAt(i, 3)+"", nCaracteresTelefono)==false){//Numero de telefono valido
                        error += "Numero de telefono fila "+i+" debe ser de "+nCaracteresTelefono+" digitos\n";
                    }
                }
                
                //Si datos son validos
                if (error.equals("")){
                    for (int i = 0; i < nFilas; i++) {
                        try {
                            String sql = "INSERT INTO proveedor VALUES('"+ dtmTabla.getValueAt(i, 0)+"','"+ dtmTabla.getValueAt(i, 1)+"','"+dtmTabla.getValueAt(i, 2)+"','"+dtmTabla.getValueAt(i, 3)+"')";
                            btnRegistrarActionPerformed(con, sql);
                        } catch (SQLException ex) {
                            Logger.getLogger(Panel_Nuevos_Datos.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Registro de proveedores exitoso");
                    menuItem.doClick();
                }
                else JOptionPane.showMessageDialog(null, error);
            }
        });

        btnNuevaFila.setText("Nueva Fila");
        btnNuevaFila.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnNuevaFilaActionPerformed(e, dtmTabla, vector);
            }
        });

        //Paneles
        panel.setLayout(new java.awt.BorderLayout());

        panel.add(lblTitulo, java.awt.BorderLayout.NORTH);
        panel.add(lblEspacio1, java.awt.BorderLayout.EAST);
        panel.add(lblEspacio2, java.awt.BorderLayout.WEST);

        panel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panel.add(pSur, java.awt.BorderLayout.SOUTH);

        /*Panel parte inferior*/
        pSur.setLayout(new java.awt.GridLayout(1, 3));
        pSur.add(btnNuevaFila);
        pSur.add(btnRegistrar);
        
        return panel;
    }
     
    private int consultarU_Numero_Cl (Connection con) throws SQLException{
        String sql = "SELECT * FROM ultimas_claves_secuenciales"; 
        int Numero_Cl = 0;
        
        try (Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                Numero_Cl = rs.getInt("Numero_Cl");
            }
            rs.close();
            st.close();
        }
        
        return Numero_Cl+1;
    }
    
    //Verificar datos
    private boolean vCodigo(String codigo, int nCaracteres){
        Validacion_pNuevos verificar = new Validacion_pNuevos();
        
        return verificar.vnCaracteres(codigo, nCaracteres);
    }
    
    private boolean vCampoNoVacio (String campo){
        if (campo.length()!=0 && !campo.equals("null")){ 
            for (int i=0; i<campo.length(); i++){
                if (campo.charAt(i) != ' '){
                    return true;
                }                                      
            }
            return false;
        }    
        else{ 
            return false;
        }
    }
    
    //listeners
    private void btnNuevaFilaActionPerformed (java.awt.event.ActionEvent evt, javax.swing.table.DefaultTableModel dtmTabla, String[] vector){       
        dtmTabla.addRow(vector);
        nFilas ++;
    }
    
    private void btnRegistrarActionPerformed (Connection con, String sql) throws SQLException{
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
    private JButton btnRegistrar;
    // End of variables declaration   
}
