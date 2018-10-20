/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4pra;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Rakibul Hasan
 */
public class Lab4PRA {

    /**
     * @param args the command line arguments
     */
    public static int linearSearch(int[] arr, int key){    
        for(int i=0;i<arr.length;i++){    
            if(arr[i] == key){    
                return i;    
            }    
        }    
        return -1;    
    }
    public static void main(String[] args) {
        // TODO code application logic here
        
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
        
        //queue
        int pf=0;
        int count=0;
        int[] q=new int[num_of_page_frames];
        for(int i=0;i<num_of_page_frames;i++ ){
            q[i]=-1;
            
        }
        
        
        //FIFO
        int index=0;
        for(int i=0;i<no_of_pages;i++){
            //Check frame a  ase kina
            if(linearSearch(q,page_sequence[i])==-1){
                //check frame er kothay bosabo
                pf=1;
                count++;
                int done=0;
                //kothao faka ase kina
                    for(int r=0;r<num_of_page_frames;r++)
                    {
                    // jodi -1 thak
                        if(q[r]==-1){
                    q[r]=page_sequence[i];
                    r=num_of_page_frames;
                    done=1;
                    break;
                        }
                
                    
                    }
                    
                    //jodi frame a onnno kono value thake
                    if(done!=1)
                    {
                       
                          //call algorithm 
                            //kon ta milse 
                            
                                q[index]=page_sequence[i];
                                index++;
                                if(index==num_of_page_frames){
                                    index=0;
                                }    
                            
                        }
                        
                    
                            
            }
            else{
                pf=0;
            }
            //out put 
            for(int a=0;a<num_of_page_frames+2;a++){
                if(a==0){
                    System.out.print("|----------|");
                }
                else
                    System.out.print(" ----------|");
                
                
            }
            System.out.println();
                
                System.out.print("|   "+df2.format(page_sequence[i])+"     |");
                //System.out.print(""+page_sequence[i]+"  ");
                
                for(int t=0;t<num_of_page_frames;t++){
                    if(q[t]==-1){
                        System.out.print("           |");
                    }
                    else{
                        System.out.print("    "+df2.format(q[t])+"     |");
                    }
                    
                }
                if(pf==1){
                    System.out.print("   PF      |");
                }
                System.out.println();
            
            
            
        }
        
        
        System.out.println(" PF = "+count+"");
    }
    
}
