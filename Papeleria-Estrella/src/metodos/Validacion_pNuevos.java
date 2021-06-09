/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

/**
 *
 * @author Eduardo Elias Hernandez Moreno
 */
public class Validacion_pNuevos {
    
    private int vint (String cadena){
        int numero;
        
        try{
            numero = Integer.parseInt(cadena);
        }   
        catch (Exception ex){
            numero = -1;
        }
        
        return numero;
    }
    
    private double vdouble (String cadena){
        double numero;
        
        try{
            numero = Double.parseDouble(cadena);
        }   
        catch (Exception ex){
            numero = -1;
        }
        
        return numero;
    }
    
    public boolean vnCaracteres (String cadena, int numero){
        //validar numero de caracteres
        if (cadena.length() == numero){//Se analiza que no haya caracteres vacios
            for (int i = 0; i < numero; i++){
                if (cadena.charAt(i) == ' '){
                    return false;
                }
            }
        }
        else{
            return false;
        }
        return true;
    }
}
