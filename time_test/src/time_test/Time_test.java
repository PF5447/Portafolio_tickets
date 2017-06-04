/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package time_test;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author bcn
 */
public class Time_test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.toString().replace(".","").replace("-","").replace(":",""));   
        
        
    }
    
}
