/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segmentation_memory_management_system;

/**
 *
 * @author Rakibul Hasan
 */
import java.text.DecimalFormat;
import java.util.Scanner;
public class Segmentation_memory_management_system {

    /**
     * @param args the command line arguments
     */
    public static int getMaxValue(int[] array) {
    int maxValue = array[0];
    for (int i = 1; i < array.length; i++) {
        if (array[i] > maxValue) {
            maxValue = array[i];
        }
    }
    return maxValue;
}
    public static int getMinValue(int[] inputArray){ 
    int minValue = inputArray[0]; 
    for(int i=1;i<inputArray.length;i++){ 
      if(inputArray[i] < minValue){ 
        minValue = inputArray[i]; 
      } 
    } 
    return minValue; 
  } 
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
        int noOfSegment=0;
        //int[] segmentSize = new int[50];
        int[] baseAddress = new int[50];
        int[] limit = new int[50];
        int PMA;
        int temp;
        
        DecimalFormat decimalFormat = new DecimalFormat("0000");
        DecimalFormat df2= new DecimalFormat("00");
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Segmentation : \n ");
        
        //No. of segment :
        System.out.print("No. of segment : ");
        noOfSegment=sc.nextInt();
        System.out.println();
        /*
        // loop for load the size
        for(int i =0;i<noOfSegment;i++){
            System.out.print("Segment [ "+i+" ] Size : ");
            segmentSize[i]=sc.nextInt();
            System.out.println();
        }
        */
        // physical Memory Size
        System.out.print("Physical Memory Size : ");
        PMA=sc.nextInt(); 
        System.out.println();
        
        // Segment Table
         System.out.println("Segment Table Input : ");
         for(int i =0;i<noOfSegment;i++){
            System.out.print("Segment Number [ "+i+" ] base Address : ");
            baseAddress[i]=sc.nextInt();
            if(baseAddress[i]<PMA){
                System.out.print(" Limit : ");
                limit[i]=sc.nextInt();
                if(limit[i]>=PMA){
                    i--;
                  System.out.println("Error : Physical Memory Address Limitation ");
              }
                
            }
            else
            {
                i--;
                System.out.println("Error : Physical Memory Address Limitation ");
            }
            
              
            
            System.out.println();
        }
         
        // Logical Calculation  
        
        //visual representation of logical address space
        
        System.out.println("Visual representation of logical address space : \n ");
       /* int unit=0;
        int maxLimit=getMaxValue(limit);
        int minLimit=getMinValue(limit);
        if(minLimit>=100   ){
            unit=100;
        }
        else if(minLimit>=50)
        {
            unit=50;
        }
        else
            unit =10;
        */
        for(int i=0;i<noOfSegment;i++){
            System.out.println("  Segemnt : [ "+i+" ] ");
            
                System.out.println(""+decimalFormat.format(0)+" ---------- ");
                    for(int k=0;k<limit[i]/100;k++){
                         System.out.println("    |          |");
                    }
                    System.out.println(""+decimalFormat.format(limit[i])+" __________ \n");
            
            
            
        }
        
   
        
        //Segment Table            
        System.out.println("\nSegment Table : "); 
        System.out.println("Index  |  Base Address  | Limit"); 
        for(int i=0;i<noOfSegment;i++){
            
        System.out.println("|------|----------------|----------|");
        System.out.println("|   "+df2.format(i)+" |          "+decimalFormat.format(baseAddress[i])+"  |    "+limit[i]+"   |");
        System.out.println("|      |                |          |");
        
       
    }
      System.out.println("|______|________________|__________| ");
                    
            
// Physical Address Space 
      
      System.out.println();
      System.out.println("Visual representation of Physical Address Space : ");
      int tempJ=0;
      int[] stack = new int[50];
      int count=0;
       System.out.println("Address   Segment "); 
        for(int i=0;i<PMA;i=i+100){
      int check = linearSearch(stack,i);
        if(i==0)
        {
            System.out.println("   "+decimalFormat.format(i)+"-----------");
        }
        if( (baseAddress[tempJ]+limit[tempJ])==i  ){  
         
                 System.out.println("   "+decimalFormat.format(i)+"-----------");
           
      
        }
        else
        {
             System.out.println("       |          |");
        }
        int flag=0;
        int j;
        for(j=0; j<noOfSegment;j++){
            
             if (i==baseAddress[j] ){
                 stack[count]=i+limit[j];
                 count++;
                 if(i!=0 && check ==-1){
                     
                System.out.println("   "+decimalFormat.format(i)+" ----------|");
                     
                
                 }
                
                //System.out.println("        ---------- ");
                 
                 flag=1;
                 tempJ=j;
                 break;
             }
             else {
                flag=0;
             }
        }
        if(flag==0){
             System.out.println("       |          |");
           // System.out.println("   "+decimalFormat.format(i)+"|          |");
        }
        else if (flag==1)
        {
            System.out.println("       | Sgmt: "+df2.format(j)+" |");
            //System.out.println("    | Page: "+df2.format(j)+" |");
        }
        //System.out.println("    |----------|");
        System.out.println("       |          |");
        
        
        }
        System.out.println("   "+decimalFormat.format(PMA)+"|__________|");
        
        System.out.println();
        
        
        
        
        //Input a logical memory address (segment number and offset ) 
        int convert =10;
        while(convert>0){
            int snum;
            int offset;
            int apma;
        System.out.println(" A Logical Memory Address --> A Physical Memory Address");
                System.out.print("segment number : ");
                snum=sc.nextInt();
                System.out.print("offset : ");
                offset=sc.nextInt();
                
        apma=baseAddress[snum]+offset;
        if(apma>(baseAddress[snum]+limit[snum])){
             System.out.println(" Error : Not Found");
        }
        else {
            
           System.out.println(" Result : The Physical Address is : "+apma);
            
        }
       
       
        }
       convert--;
    }
        
    
        
    }
        
        
    
