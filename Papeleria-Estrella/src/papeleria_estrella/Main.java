package papeleria_estrella;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eddy-
 */
public class Main {
    public static void main(String[] args) throws SQLException{
        Conectar conectar = new Conectar();
        String user= JOptionPane.showInputDialog("Digite nombre usuario");
        String pass= JOptionPane.showInputDialog("Digite contraseña");
        
        try (Connection con = conectar.getConection(user, pass)) {
            /*Statement statement = con.createStatement();
            int n;
            String sql1 = "DELETEE FROM Cliente WHERE Numero_Cl ='"+n+"'";
            PreparedStatement pstm;
            pstm = (PreparedStatement)con.prepareStatement(sql1);*/
            
            String sql = "SELECT * FROM Cliente";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            while(rs.next()){
                int Numero_Cl = rs.getInt("Numero_Cl");
                System.out.println(Numero_Cl);
            }
            
            rs.close();
            statement.close();
            con.close();
            System.out.println("hola");
        }
        catch(RuntimeException| SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }        
        
    } 
}
