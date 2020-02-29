
/**
 * Write a description of class diskSchedAlgo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.Stack;
public class diskSchedAlgo
{
    public static void FCFS(){
        Scanner kb = new Scanner(System.in);
        System.out.print("Input array length: ");
        int x = kb.nextInt();
        int[] array = new int[x];
        for(int y = 0; y < array.length;y++){
            System.out.print("Input JOB "+ (y+1) +" Burst time: ");
            array[y] = kb.nextInt();
        }
        double avg = 0, ct = 0;
        for(int z = 0; z< array.length - 1; z++){
            ct += array[z];
            avg += ct;
        }
        avg /= array.length;
        System.out.println("\nAverage Waiting Time: "+ avg + " ms");
    }
    
    public static void NPSJF(){
        Scanner kb = new Scanner(System.in);
        System.out.print("Input array length: ");
        int x = kb.nextInt();
        Integer[] array = new Integer[x];
        for(int y = 0; y < array.length;y++){
            System.out.print("Input JOB "+ (y+1) +" Burst time: ");
            array[y] = kb.nextInt();
        }
        double total = 0,ct = 0;
        for( x = 0; x < array.length - 1;x++){
            int pointer = -1;
            for(int y = 0; y < array.length; y++){
                
               if(pointer == -1){
                   if(array[y] != null ){
                       pointer = y;
                   }
               }else{
                   if(array[y] != null && array[y] < array[pointer]){
                       pointer = y;
                   }
               }
               
            }
            
            ct += array[pointer];
            total += ct;
            array[pointer] = null;
        }
        total /= array.length;
        System.out.println("\nAverage Waiting Time: "+ total + " ms");
        
        
    }
    
    public static void PSJF(){
        Scanner kb = new Scanner(System.in);
        System.out.print("Input array length: ");
        int x = kb.nextInt();
        Integer[][] array = new Integer[3][x];
        for(int y = 0; y < array[0].length;y++){
            System.out.print("Input JOB "+ (y+1) +" Burst time: ");
            array[0][y] = kb.nextInt();
            System.out.print("Input JOB "+ (y+1) +" Arrival Time : ");
            array[1][y] = kb.nextInt();
            array[2][y] = 0;
        }
        int pointer = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int y = 1; y < array[0].length ; y++){
            if(array[1][pointer] > array[1][y]  ){
                pointer = y;
            }
        }
        double wait = 0;
        int cnt = array[1][pointer];
        wait += cnt;
       int a = x;
        while(a > 1){
             if(!stack.empty() && array[0][pointer] <= 0){
                a--;
                if(a <= 1){
                    pointer = stack.pop();
                    break;
                }
                wait += (cnt - array[2][pointer]);
                //System.out.println("wait1: " + wait);
                array[2][pointer]= cnt;
                pointer = stack.pop();
                
              
                
            }
            cnt++;
            if(array[0][pointer] > 0){
                array[0][pointer]--;
            }
            for(int y = 0; y < array[0].length ; y++){
                if(cnt == array[1][y]  ){
                   if(array[0][y] < array[0][pointer] ){
                       wait += cnt - array[2][pointer];
                       //System.out.println("wait2 : " + wait);
                       array[2][pointer] = cnt;
                       stack.push(pointer);
                       pointer = y;
                   }else{
                       stack.push(y);
                   }
                }
            }
            
           
            
            /*for(int z = 0;z< array[0].length; z++){
                System.out.println(array[0][z] + "," +array[1][z] + "," +array[2][z]);
            }*/
            //System.out.println("Wait: " + wait + " ,Cnt: " + cnt + " , Pointer: "+ pointer +" , A: " + a);
        }
        
        wait += cnt - array[2][pointer];
        //System.out.println("FINAL WAIT: " + wait);
        double avg = wait / x;
        System.out.println("Average Waiting Time: " + avg);
    }
    
    public static void Priority(){
        Scanner kb = new Scanner(System.in);
        System.out.print("Input array length: ");
        int x = kb.nextInt();
        Integer[][] array = new Integer[x][x];
        for(int y = 0; y < array.length;y++){
            System.out.print("Input JOB "+ (y+1) +" Burst time: ");
            array[0][y] = kb.nextInt();
            System.out.print("Input JOB "+ (y+1) +" Priority : ");
            array[1][y] = kb.nextInt();
        }
       double total = 0,ct = 0;
        for( x = 0; x < array.length - 1;x++){
            int pointer = -1;
            for(int y = 0; y < array.length; y++){
                
               if(pointer == -1){
                   if(array[1][y] != null ){
                       pointer = y;
                   }
               }else{
                   if(array[1][y] != null && array[1][y] < array[1][pointer]){
                       pointer = y;
                   }
               }
               
            }
            ct += array[0][pointer];
            total += ct;
            array[1][pointer] = null;
        }
        total /= array.length;
        System.out.println("\nAverage Waiting Time: "+ total + " ms");
    }
    
    public static void RR(){
        Scanner kb = new Scanner(System.in);
        System.out.print("Input array length: ");
        int x = kb.nextInt();
        System.out.print("Input quantum: ");
        int q = kb.nextInt();
        int[][] array = new int[3][x];
        for(int y = 0; y < array[0].length;y++){
            System.out.print("Input JOB "+ (y+1) +" Burst time: ");
            array[0][y] = kb.nextInt();
        }
       int ct = 0;
        while (x > 1){
         
            for(int z = 0 ; z < array[0].length;z++){
                if(q>= array[0][z] && array[0][z] != 0){
                    
                    array[1][z] += (ct - array[2][z]);
                    ct += array[0][z];
                    array[0][z] = 0;
                    array[2][z] = ct;
                    x--;
                }else if (array[0][z] != 0){
                    
                    array[1][z] += (ct - array[2][z]);
                    ct += q;
                    array[2][z] = ct;
                    array[0][z] -= q;
                }
            }
            
           
        }
        for(int z = 0; z < array[0].length; z++){
            if(array[0][z] != 0){
                array[1][z] += (ct - array[2][z]);
                break;
            }
        }
        double avg = 0;
        for(int z = 0 ; z < array[0].length;z++){
            avg += array[1][z];
        }
        avg /= array[0].length;
        System.out.println("\nAverage Waiting Time: "+ avg + " ms");
    }
}
