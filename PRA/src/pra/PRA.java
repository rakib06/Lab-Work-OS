/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pra;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Rakibul Hasan
 */
public class PRA {

    /**
     * @param args the command line arguments
     */
     public static int linearSearch(char[] arr, char key){    
        for(int i=0;i<arr.length;i++){    
            if(arr[i] == key){    
                return 1;    
            }    
        }    
        return -1;    
    }
    public static void main(String[] args) {
        
                
        DecimalFormat decimalFormat = new DecimalFormat("0000");
        DecimalFormat df2= new DecimalFormat("00");
        
        //input
        

        // TODO code application logic here
    }
    
}
