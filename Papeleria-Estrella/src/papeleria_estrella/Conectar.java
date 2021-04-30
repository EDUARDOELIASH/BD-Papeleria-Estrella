package papeleria_estrella;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author felix
 */
public class Conectar {
    Connection con;
    //Datos de conexion a base de datos
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "uhqnltdnpxd2j2by";
    private static final String pass = "gRvU8dz1U43u2XKfPBDK";
    private static final String url = "jdbc:mysql://hv-mtl2-011.clvrcld.net:10624/baq7fnw62uwde1kyfv5g";
    
    public Conectar(){
        //Reset a null conex a bd
        con=null;
        try{
            Class.forName(driver);
            //conexion a bd
            con = DriverManager.getConnection(url, user, pass);
            //Si la conex exitosa, mostramos un mensaje conexion exitosa
            if (con!=null){
               System.out.println("Conexion exitosa");
            
            }
        }
        //Si conexion no exitosa
        catch(ClassNotFoundException | SQLException e){
            System.out.println("Error de conexión");
        }
        JOptionPane.showMessageDialog(null,"hola");
    }
}
