/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduling.algorithm;
import java.util.Scanner;
/**
 *
 * @author Rakibul Hasan
 */


public class RR 
{
 
 public static Scanner Num_Scanner = new Scanner(System.in);
 
 public void Round_Robin()
 {
  
  int Count,Number_Of_Processes,Time,Remaining,Flag=0,Time_Quantum; 
  int Waiting_Time=0,TurnAround_Time=0;
  int Average_Time[] = new int[20];
  int Burst_Time[] = new int[20];
  int Remaining_Time[] = new int[20]; 
  System.out.println("Enter Total Process : "); 
  Number_Of_Processes = Num_Scanner.nextInt(); 
  Remaining=Number_Of_Processes; 
  for(Count=0;Count<Number_Of_Processes;Count++) 
    { 
       System.out.print("Enter Arrival Time & Burst Time For Process Number "+(Count+1)+" :"); 
       Average_Time[Count] = Num_Scanner.nextInt(); 
       Burst_Time[Count] = Num_Scanner.nextInt(); 
       Remaining_Time[Count]=Burst_Time[Count]; 
    } 
  System.out.print("Enter Time Quantum : "); 
  Time_Quantum = Num_Scanner.nextInt(); 
  System.out.println("\nProcess\t|Turnaround Time|Waiting Time\n"); 
  for(Time=0,Count=0;Remaining!=0;) 
     { 
       if(Remaining_Time[Count]<=Time_Quantum && Remaining_Time[Count]>0) 
      { 
       Time+=Remaining_Time[Count]; 
       Remaining_Time[Count]=0; 
       Flag=1; 
      } 
      else if(Remaining_Time[Count]>0) 
      { 
       Remaining_Time[Count]-=Time_Quantum; 
       Time+=Time_Quantum; 
      } 
      if(Remaining_Time[Count]==0 && Flag==1) 
      { 
       Remaining--; 
       System.out.println("P["+(Count+1)+"]\t|\t"+(Time-Average_Time[Count])+"\t|\t"+(Time-Average_Time[Count]-Burst_Time[Count])+"\n"); 
       Waiting_Time+=Time-Average_Time[Count]-Burst_Time[Count]; 
       TurnAround_Time+=Time-Average_Time[Count]; 
       Flag=0; 
      } 
      if(Count==Number_Of_Processes-1) 
       Count=0; 
      else if(Average_Time[Count+1]<=Time) 
       Count++; 
      else 
       Count=0; 
    } 
    System.out.println("\nAverage Waiting Time= "+(Waiting_Time*1.0/Number_Of_Processes)+"\n"); 
    System.out.println("Avg Turnaround Time = "+TurnAround_Time*1.0/Number_Of_Processes); 
  
 }

}
