/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagereplacementalgorithms;


import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Rakibul Hasan
 */
public class PageReplacementAlgorithms {
            

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DecimalFormat decimalFormat = new DecimalFormat("0000");
        DecimalFormat df2= new DecimalFormat("00");
        
        //input
        
        int no_of_pages;
        //int[] page_sequence = new int[no_of_pages];
        int num_of_page_frames;
        Scanner sc = new Scanner(System.in);
        System.out.print("No. of pages : ");
        no_of_pages=sc.nextInt();
        int[] page_sequence = new int[no_of_pages];
        System.out.println();
        System.out.print("Page Sequence : ");
        for(int i=0;i<no_of_pages;i++){
            page_sequence[i]=sc.nextInt();
        }

        System.out.println();
        System.out.print("No. of page frames : ");
        num_of_page_frames=sc.nextInt();
        System.out.println();
        //End Of input 
        
        //Calculation part Start 
        
        
            
             for(int j=0;j<num_of_page_frames+2;j++){
                 if(j==0){
                     System.out.print("|Frame/Page|");
                     
                 }
                 else if(j==num_of_page_frames+1){
                     System.out.print("|   PF     |");
                 }
                 else
                     System.out.print("|   "+df2.format(j)+"     |");
                 for(int i=0;i<no_of_pages;i++){
                     if(j==0){
                         System.out.print("    "+df2.format(page_sequence[i])+"     |");
                     }
                     else if(j<i)
                         System.out.print("           |");
                     else if(j==i+1)
                         System.out.print("    "+df2.format(page_sequence[i])+"     |");
                     else
                         System.out.print("           |");
                         
                 //System.out.println("----------");
                
                  //System.out.println("----------");
                 
                 
                 
             }
                 System.out.println();
             }
        
        
        
        
        
        
        // TODO code application logic here
    }
    
}
