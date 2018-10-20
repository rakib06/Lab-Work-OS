/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oslab2_logical.address.space;

/**
 *
 * @author Rakibul Hasan
 */
import java.text.DecimalFormat;
import java.util.Scanner;
public class OSLAB2_LogicalAddressSpace {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int PagingUnitSize=0;
        int LogicalMemorySize;
        int PhysicalMemorySize;
        int MemoryAddress=0;
        
        DecimalFormat decimalFormat = new DecimalFormat("0000");
        DecimalFormat df2= new DecimalFormat("00");
        
        System.out.println("Implementation of Paging Memory Management System For Mapping LMA to PMA ");
        //input 
        System.out.print("Logical Memory Size / Process Size :");
        LogicalMemorySize=sc.nextInt();
        System.out.println();
        System.out.print("Physical Memory Size :");
        PhysicalMemorySize=sc.nextInt();
        if(PhysicalMemorySize>LogicalMemorySize){
            System.out.println("Warning : Physical Memory Size may smaller than Logical Memory Size ");
        }
        System.out.println();
        
        int checkOne=1;
        while(checkOne!=0)
        {
        System.out.print("Paging Unit Size : ");
        PagingUnitSize=sc.nextInt();
        if(PagingUnitSize>LogicalMemorySize || PagingUnitSize>PhysicalMemorySize ){
            System.out.println("Error : Paging Unit Size is Smaller than Logical Memory Size or Physical Memory Size  ");
             checkOne=1;
        }
        else
            checkOne=0;
        
        }
        System.out.println();
        
        
      // Input Page Table 
      int temp =LogicalMemorySize/PagingUnitSize;
      int[] tableFrame = new int[temp];
      
      System.out.println("Page Table : ");
      for (int j=0;j<PhysicalMemorySize/PagingUnitSize;j++){
          tableFrame[j]=0;
          int checkTwo=1;
          while(checkTwo!=0){
              
          System.out.print(" Table Index : "+df2.format(j)+" Frame Number : " );
          tableFrame[j]=sc.nextInt();
          if(tableFrame[j]>=PhysicalMemorySize/PagingUnitSize || tableFrame[j]<0){
              System.out.println("Error : Frame Number is invalid  ");
              checkTwo=1;
          }
          else
              checkTwo=0;
          
          
          
          }
          System.out.println();
      }
        
      
      // input a Logical Memory Address 
      int aLMA;
      

        // Visual representation of Logical Address Space 
         System.out.println();
         System.out.println("Visual representation of Logical Address Space : ");
         System.out.println("Addr.   Page");
        for(int i=0;i<LogicalMemorySize/PagingUnitSize;i++){
            
        System.out.println(""+decimalFormat.format(MemoryAddress)+" ---------- ");
        System.out.println("    | Page: "+df2.format(i)+" |");
        System.out.println("    |          |");
        MemoryAddress=MemoryAddress+4;
       
    }
      System.out.println(""+decimalFormat.format(MemoryAddress-1)+" __________ ");
      
      System.out.println();
      //output of page Table 
      System.out.println("Page Table : "); 
      System.out.println("Index   Frame"); 
        for(int i=0;i<PhysicalMemorySize/PagingUnitSize;i++){
            
        System.out.println("     ---------- ");
        System.out.println(""+df2.format(i)+"  |       "+df2.format(tableFrame[i])+" |");
        System.out.println("    |          |");
        
       
    }
      System.out.println("     __________ ");
      
      
      
// Physical Address Space 
      int frameNo=PhysicalMemorySize/PagingUnitSize;
      System.out.println();
      System.out.println("Visual representation of Physical Address Space : ");
      
       System.out.println("Frame Page "); 
        for(int i=0;i<frameNo;i++){
        
          
        System.out.println("     ---------- ");
        int flag=0;
        int j;
        for(j=0; j<temp;j++){
            
             if (i==tableFrame[j]){
                 
                 flag=1;
                 break;
             }
             else {
                flag=0;
             }
        }
        if(flag==0){
            
            System.out.println("  "+df2.format(i)+"|          |");
        }
        else if (flag==1)
        {
            System.out.println("  "+df2.format(i)+"| Page: "+df2.format(j)+" |");
            //System.out.println("    | Page: "+df2.format(j)+" |");
        }
        System.out.println("    |          |");
        }
        System.out.println("     __________ ");
        
        System.out.println();
        
        // LMA ==> PMA 
        int convert =10;
        while(convert>0){
        System.out.print(" Enter A Logical Memory Address : ");
        aLMA=sc.nextInt();
        if(aLMA>=LogicalMemorySize|| aLMA<0)
        {
            System.out.println(" Error : Out of Limit");
            
        }
        else
        {
        int aPageNum=aLMA/PagingUnitSize;
        int offset=aLMA-aPageNum*PagingUnitSize;
        int aFrameNum=0;
        int aPMA;
       
       aPMA=tableFrame[aPageNum]*PagingUnitSize+offset;
       System.out.println(" Output Physical Memory Address : "+aPMA);
        }
       convert--;
    }
     
    }
      
      
      
    }
  


