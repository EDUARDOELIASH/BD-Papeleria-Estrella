/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels_menu_principal;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Eduardo Elias Hernandez Moreno
 */
public class Nueva_Venta extends javax.swing.JFrame {

    /**
     * Creates new form Nueva_Venta
     */
    public Nueva_Venta() {
        initComponents();
    }   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     *///
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_Nueva_Venta = new javax.swing.JPanel();
        pVenta = new javax.swing.JPanel();
        lblCodigo_V = new javax.swing.JLabel();
        lblFecha_V = new javax.swing.JLabel();
        lblNumero_Cl = new javax.swing.JLabel();
        txtCodigo_V = new javax.swing.JTextField();
        txtNumero_Cl = new javax.swing.JTextField();
        btnNuevo_Cliente = new javax.swing.JButton();
        jdchFecha_V = new com.toedter.calendar.JDateChooser();
        pEntradas = new javax.swing.JPanel();
        btn_Agregar_p_o_s = new javax.swing.JButton();
        lbl_Total_V = new javax.swing.JLabel();
        txtTotal_V = new javax.swing.JTextField();
        pBotones = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCodigo_V.setText("Codigo_V");

        lblFecha_V.setText("Fecha_V");

        lblNumero_Cl.setText("Numero_Cl");

        txtCodigo_V.setEditable(false);

        txtNumero_Cl.setText("0");

        btnNuevo_Cliente.setText("Nuevo Cliente");
        btnNuevo_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo_ClienteActionPerformed(evt);
            }
        });

        jdchFecha_V.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout pVentaLayout = new javax.swing.GroupLayout(pVenta);
        pVenta.setLayout(pVentaLayout);
        pVentaLayout.setHorizontalGroup(
            pVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pVentaLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(pVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCodigo_V)
                    .addComponent(lblFecha_V)
                    .addComponent(lblNumero_Cl))
                .addGap(39, 39, 39)
                .addGroup(pVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNumero_Cl, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(btnNuevo_Cliente, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCodigo_V, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdchFecha_V, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        pVentaLayout.setVerticalGroup(
            pVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCodigo_V)
                    .addComponent(txtCodigo_V, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFecha_V)
                    .addComponent(jdchFecha_V, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumero_Cl)
                    .addComponent(txtNumero_Cl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNuevo_Cliente)
                .addContainerGap())
        );

        btn_Agregar_p_o_s.setText("Agregar productos\n o servicios");
        btn_Agregar_p_o_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Agregar_p_o_sActionPerformed(evt);
            }
        });

        lbl_Total_V.setText("Total de venta");

        txtTotal_V.setEditable(false);

        javax.swing.GroupLayout pEntradasLayout = new javax.swing.GroupLayout(pEntradas);
        pEntradas.setLayout(pEntradasLayout);
        pEntradasLayout.setHorizontalGroup(
            pEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEntradasLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pEntradasLayout.createSequentialGroup()
                        .addComponent(lbl_Total_V)
                        .addGap(26, 26, 26)
                        .addComponent(txtTotal_V, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_Agregar_p_o_s))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        pEntradasLayout.setVerticalGroup(
            pEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEntradasLayout.createSequentialGroup()
                .addComponent(btn_Agregar_p_o_s)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Total_V)
                    .addComponent(txtTotal_V, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pBotonesLayout = new javax.swing.GroupLayout(pBotones);
        pBotones.setLayout(pBotonesLayout);
        pBotonesLayout.setHorizontalGroup(
            pBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBotonesLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(btnRegistrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pBotonesLayout.setVerticalGroup(
            pBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrar)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout p_Nueva_VentaLayout = new javax.swing.GroupLayout(p_Nueva_Venta);
        p_Nueva_Venta.setLayout(p_Nueva_VentaLayout);
        p_Nueva_VentaLayout.setHorizontalGroup(
            p_Nueva_VentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_Nueva_VentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_Nueva_VentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pEntradas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        p_Nueva_VentaLayout.setVerticalGroup(
            p_Nueva_VentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_Nueva_VentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_Nueva_Venta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_Nueva_Venta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    //metodos de panel Nueva_Venta
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
    
    public Date fechaActual(){
        Date fecha=new Date();
        SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/YYYY");
        
        //el return de este metodo se asigna a txtFecha_V
        /*
            se puede añadir un listener para que no se pueda editar fecha
            jdchFecha_V.setDate(fechaActual);
        */
        return fecha;
    }
    
    private void btn_Agregar_p_o_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Agregar_p_o_sActionPerformed
        // TODO add your handling code here:
        //Se abre ventana para agregar productos o servicios para venta
    }//GEN-LAST:event_btn_Agregar_p_o_sActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        //Se registra todo en las tablas de las bases de datos
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnNuevo_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo_ClienteActionPerformed
        // TODO add your handling code here:
        //Se abre panel pNuevo_Cliente
    }//GEN-LAST:event_btnNuevo_ClienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Nueva_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nueva_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nueva_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nueva_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Nueva_Venta ventana = new Nueva_Venta();
                ventana.setVisible(true);
                
                int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
                int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
                ventana.setBounds((ancho/2) - (ventana.getWidth()/2), (alto/2) - (ventana.getHeight()/2), 500, 500);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevo_Cliente;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btn_Agregar_p_o_s;
    private com.toedter.calendar.JDateChooser jdchFecha_V;
    private javax.swing.JLabel lblCodigo_V;
    private javax.swing.JLabel lblFecha_V;
    private javax.swing.JLabel lblNumero_Cl;
    private javax.swing.JLabel lbl_Total_V;
    private javax.swing.JPanel pBotones;
    private javax.swing.JPanel pEntradas;
    private javax.swing.JPanel pVenta;
    private javax.swing.JPanel p_Nueva_Venta;
    private javax.swing.JTextField txtCodigo_V;
    private javax.swing.JTextField txtNumero_Cl;
    private javax.swing.JTextField txtTotal_V;
    // End of variables declaration//GEN-END:variables
}
