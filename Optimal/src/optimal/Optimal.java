/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimal;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Rakibul Hasan
 */
public class Optimal {

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
    public static int linearSearch(int[] arr, int key,int start){    
        for(int i=start;i<arr.length;i++){    
            if(arr[i] == key){    
                return i;
                
            }    
        }    
        return -1;    
    }
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
      public static int getMinValue(int[] inputArray,int range){ 
    int minValue = inputArray[0]; 
    for(int i=1;i<range;i++){ 
      if(inputArray[i] < minValue){ 
        minValue = inputArray[i]; 
      } 
    } 
    return minValue; 
  }
     public static int getCountValue(int[] inputArray,int key){ 
     int count=0;
    for(int i=0;i<inputArray.length;i++){ 
      if(inputArray[i] ==key){ 
        count++;
      } 
    } 
    return count; 
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
        int[] q_c=new int[num_of_page_frames];
        int q_count=0;
        int[] timer=new int[num_of_page_frames];
        for(int i=0;i<num_of_page_frames;i++ ){
            q[i]=-1;
            q_c[i]=0;
            
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
                    int[] ones=new int[10];
                    //jodi frame a onnno kono value thake
                    if(done!=1)
                    {
                        //int[] page_sequence = new int[no_of_pages];
                    int[] cmp =new int[num_of_page_frames];
                        int ones_count=0;
                       for(int l=0;l<num_of_page_frames;l++){
                           cmp[l]=linearSearch(page_sequence,q[l],i);
                           if(cmp[l]==-1){
                               ones[ones_count]=q[l];
                               ones_count++;
                           }
                       }
                          //call algorithm 
                          
                         //find the index 
                         for(int o=0;o<num_of_page_frames;o++){
                          if(ones_count<1){
                              // find the max and replace it  
                          int max=getMaxValue(cmp);
                            
                           
                            
                            if(page_sequence[max]==q[o]){
                                index=o;
                                    }
                          
                          }
                          // jodi ekta -1 thake 
                          else if (ones_count==1)
                          { // FIND THE min
                              int min=getMinValue(cmp);
                             
                                //count Min value 
                                if(ones[0]==q[o]){
                                    index=o;
                                    break;
                                }
                                
                
                          }
                          
                          // end of 2nd if 
                          else {
                              //int min2=getMinValue(ones,ones_count);
                              int maxTime=getMaxValue(q_c);
                              int search_index=linearSearch(q_c,maxTime);
                              //longer time ta sorate hbe 
                              
                                  index=search_index;
                              
                          } // end of 3rd Loop
                          }
                         //End finding index 
                        
                       
                        
                        //max ta replace hbe 
                        q[index]=page_sequence[i];
                        
                           //linearSearch(page_sequence,q[i]){
                        
                    //}
                            
                              
                            
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
                
                 System.out.println();
                 
                 // Time manage 
                 
            for(int ii=0;ii<num_of_page_frames;ii++){
                    if(q[ii]==timer[ii]){
                        q_c[ii]++;
                    }
                    else
                    {
                      q_c[ii]=0;
                      
                    }
                    if(i>=num_of_page_frames){
                        timer[ii]=q[ii];
                    }
                    
                    
            }
            
            
        } // end the for loop
        
        
        System.out.println("PF = "+count+"");
    }
    
    }

    

