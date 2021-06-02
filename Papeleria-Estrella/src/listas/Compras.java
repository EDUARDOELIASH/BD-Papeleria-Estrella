package listas;

    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eduardo Elias Hernandez Moreno
 */

public class Compras {

    public int[] indiceF = {0};
    public Compras next;
    
    public Compras creanodo(int indiceF, Compras P, Compras Q){
        Q.indiceF[0] = indiceF;
        Q.next=P;
        
        P=Q;
        System.out.println("valor del nodo: " + Q.indiceF[0]);
         System.out.println("direccion del nodo actual : " + Q );
        System.out.println("nodo actual apunta a: " + Q.next);
        System.out.println("                               "  );
        return P;
    }

    public Compras obtenerNodo(Compras nodos, int[] nFilas){
        nFilas[0] = nodos.indiceF[0];
        System.out.println("lista " + nodos.indiceF[0]);
        nodos = nodos.next;

        return nodos;
    }   
   
}
