/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disk_scheduling_project;
import java.util.Formatter;

import disk_scheduling_project.algorithm.*;
import static java.lang.Math.abs;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Priya
 */
public class Disk_Scheduling_Project {
 
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();
        
        int arr[] = new int[25];
        FCFS fcfs_alg;
        LOOK look_alg;
        CLOOK clook_alg;
        
        int sch_algs;
        
       int cnt = 0;
           System.out.println("**************DISK SCHEDULING*************8");
           
           while(true)
            while(cnt!=25)
            {
                
                
                for(int i=0; i<25; i++)
                {
                     arr[i] = rn.nextInt(200);
                                    
                }
                cnt=cnt+1;
            
            fcfs_alg = new FCFS(arr,53);
            fcfs_alg.setReqQueue(arr);
            fcfs_alg.setInitHeadCylinder(53);
           
            System.out.println("*********INPUT SEQUENCE***********");    
            System.out.println("Track requested : " + Arrays.toString(fcfs_alg.getReqQueue()));
            
            System.out.println("*********FCFS ALGORITHM********");
            System.out.println("Track Traversal : " + Arrays.toString(fcfs_alg.getSequence()));
            System.out.println("Number of Track Traversed : " +Arrays.toString(fcfs_alg.getTrackMovement()));
            System.out.println("Total Track Traversed : "  +fcfs_alg.getTotalTrackMovement());
            System.out.println("Total Seek Time : " +fcfs_alg.getseektime());
            System.out.println("Average Seek time : " +fcfs_alg.getavgseektime());
            
        
            look_alg = new LOOK(arr,53);
            look_alg.setReqQueue(arr);
            look_alg.setInitHeadCylinder(53);
            
            System.out.println("*********LOOK ALGORITHM***********"); 
           // System.out.println("Input Sequence : " + Arrays.toString(look_alg.getReqQueue()));
           
            System.out.println("Track Traversal : " + Arrays.toString(look_alg.getSequence()));
            System.out.println("Number of Track traversed" +Arrays.toString(fcfs_alg.getTrackMovement()));
            System.out.println("Total Track Traversed : " + look_alg.getTotalTrackMovement());
            System.out.println("Total Seek Time : "  +look_alg.getseektime());
            System.out.println("Average Seek time : "  +look_alg.getavgseektime());
            
            
	
            clook_alg = new CLOOK(arr,53);
            clook_alg.setReqQueue(arr);
            clook_alg.setInitHeadCylinder(53);
            
            System.out.println("*********CLOOK ALGORITHM***********"); 
            //System.out.println("Input Sequence : " + Arrays.toString(clook_alg.getReqQueue()));
           
            System.out.println("Track Traversal : " + Arrays.toString(clook_alg.getSequence()));
            System.out.println("Number of Track traversed" +Arrays.toString(fcfs_alg.getTrackMovement()));
            System.out.println("Total Track Traversed : " + clook_alg.getTotalTrackMovement());
            System.out.println("Total Seek Time : "   +clook_alg.getseektime());
            System.out.println("Average Seek time : " +clook_alg.getavgseektime());
            cnt=0;       
                }
        
        }
        }


