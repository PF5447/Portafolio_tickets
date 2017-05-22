/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificador_rut;

import com.sun.javafx.geom.AreaOp;
import jdk.nashorn.internal.parser.Scanner;

/**
 *
 * @author bcn
 */
public class Verificador_rut {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        retornaVerificador(15892998);      
    }
    
    public void retornaVerificador(int numero){
        int largo = Integer.toString(numero).length();
        int[] arreglo = new int[largo];
        
        
        for (int i = largo; i > 0 ; i--) {
            
            System.out.println("Valor posicion "+i+" es :"+arreglo[i]);
            
        }
                
    }
    
    
}
