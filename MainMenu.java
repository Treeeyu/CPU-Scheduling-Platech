/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
import java.util.Scanner;
public class MainMenu {
     public static void main(String[] args){
        diskSchedAlgo m = new diskSchedAlgo();   
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        int input = 0;

        while (!flag) {
            System.out.println("\n\nDISK SCHEDULING ALGORITHMS");
            System.out.println("1.First come first serve (FCFS) \n2.Non-Preemptive Shortest Job First (SFJ) \n3.Preemptive Shortest Job First \n4.Priority \n5.Round Robin (RR)\n6.QUIT");
            input = sc.nextInt();
            switch (input) {
                case 1: //First come first serve (FCFS) 
                    m.FCFS();
                    break;
                case 2://Shortest Job First (SFJ) 
                    m.NPSJF();  
                    break;
                case 3://Priority
                    m.PSJF();
                    break;
                case 4://Priority
                    m.Priority(); 
                    break;
                case 5://Round robin (RR)
                    m.RR();
                    break;
                case 6:
                    flag = true;
                    break;
                default:
                    System.out.println("Invalid Input!");
                    break;
            }
        }    
    }
}
