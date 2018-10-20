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
public class PS 
{
 
 public static Scanner Num_Scanner = new Scanner(System.in);

 public void PriorityScheduling()
 {
  
  int Burst_Time[] = new int[20];
  int Processes[] = new int[20];
  int Waiting_Time[] = new int[20];
  int TurnAround_Time[] = new int[20];
  int PriorityQueue[] = new int[20];
  int i,j,Number_Of_Processes,Total=0,Position,Temp,Average_Waiting_Time,Average_TurnAround_Time;
     System.out.println("Enter Total Number of Processes : ");
     Number_Of_Processes = Num_Scanner.nextInt();
  
     System.out.println("\nEnter Burst Time & Priority : \n");
     for(i=0;i<Number_Of_Processes;i++)
     {
         System.out.print("\nP["+(i+1)+"]\n");
         System.out.print("Burst Time : ");
         Burst_Time[i] = Num_Scanner.nextInt();
         System.out.print("Priority : ");
         PriorityQueue[i] = Num_Scanner.nextInt();
         Processes[i]=i+1;         
     }
  
     //SORTING THE PRIORITY
     for(i=0;i<Number_Of_Processes;i++)
     {
         Position=i;
         for(j=i+1;j<Number_Of_Processes;j++)
         {
             if(PriorityQueue[j]<PriorityQueue[Position])
                 Position=j;
         }
  
         Temp=PriorityQueue[i];
         PriorityQueue[i]=PriorityQueue[Position];
         PriorityQueue[Position]=Temp;
  
         Temp=Burst_Time[i];
         Burst_Time[i]=Burst_Time[Position];
         Burst_Time[Position]=Temp;
  
         Temp=Processes[i];
         Processes[i]=Processes[Position];
         Processes[Position]=Temp;
     }
  
     Waiting_Time[0]=0; 
  
     //CALCULATE WAITING TIME
     for(i=1;i<Number_Of_Processes;i++)
     {
         Waiting_Time[i]=0;
         for(j=0;j<i;j++)
             Waiting_Time[i]+=Burst_Time[j];
  
         Total+=Waiting_Time[i];
     }
  
     Average_Waiting_Time=Total/Number_Of_Processes; 
     Total=0;
  
     System.out.println("\nProcess\t    Burst Time    \tWaiting Time\tTurnaround Time");
     for(i=0;i<Number_Of_Processes;i++)
     {
         TurnAround_Time[i]=Burst_Time[i]+Waiting_Time[i];     
         Total+=TurnAround_Time[i];
         System.out.println("\nP["+Processes[i]+"]\t\t"+Burst_Time[i]+"\t\t"+Waiting_Time[i]+"\t\t"+TurnAround_Time[i]);
     }
  
     Average_TurnAround_Time=Total/Number_Of_Processes;     
     System.out.println("\nAverage Waiting Time = "+Average_Waiting_Time);
     System.out.println("\nAverage Turnaround Time = "+Average_TurnAround_Time);

  
 }
 
}
