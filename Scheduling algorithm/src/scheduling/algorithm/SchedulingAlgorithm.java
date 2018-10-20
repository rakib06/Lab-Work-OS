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
public class SchedulingAlgorithm {

    /**
     * @param args the command line arguments
     */
    
    public static Scanner Num_Scanner = new Scanner(System.in);
    public static boolean IsRunning = true;
    public static void main(String[] args) {
        // TODO code application logic here
         int Choice;
  
  //System.out.println("----------OPERATING SYSTEMS & SYSTEMS PROGRAMMING----------");
   
  while (IsRunning) 
  {
   
   System.out.println("----------ENTER YOUT CHOICE---------");
   
   System.out.println("1.FCFS");
   System.out.println("2.SJF");
   System.out.println("3.RR");
   System.out.println("4.PS");
   System.out.print("Choice : ");
   Choice = Num_Scanner.nextInt();
   
   if(Choice == 1)
   {
    FCFS FCFS = new FCFS();
    FCFS.FirstComeFirstServed();
   }
   
   if(Choice == 2)
   {
    SJF SJF = new SJF();
    SJF.ShorthestJobFirst();
   }
    
   if(Choice == 3)
   {
    RR RR = new RR();
    RR.Round_Robin();
   }
    
   if(Choice == 4)
   {
    PS PS = new PS();
    PS.PriorityScheduling();
   }
   
   if(Choice == 0)
   {
    IsRunning = false;
   }
   
   
  }
  
 }
    }
