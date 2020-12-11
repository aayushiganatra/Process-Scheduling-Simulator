/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disk_scheduling_project.algorithm;

import static java.lang.Math.abs;
import java.util.Arrays;
/**
 *
 * @author Priya
 */
public class CLOOK implements Scheduling_Algorithm {
    private int [] reqQueue;  // input
    private int initHeadCylinder;  // input

    private int [] scheduleSequence;  // output
    private int totalTrackMovement = 0;  // output

    private int stime;  //output
    private float avgstime; //
    private int i =0;

    
    
    public CLOOK(int[] reqQueue, int initHeadCylinder) {
        this.reqQueue = new int[reqQueue.length];
        System.arraycopy(reqQueue, 0, this.reqQueue, 0, reqQueue.length);
        this.initHeadCylinder = initHeadCylinder;
    }

    public int [] getSequence() {
        Arrays.sort(reqQueue, 0, reqQueue.length); // Sorts the array of ints into ascending numerical order

        scheduleSequence = new int[reqQueue.length];

        int nextSequenceIndex = 0;

        /** move right **/
        // get the first element in the array that is bigger than the initHeadCylinder
        int startIndex = 0;
        for (int i=0; i<reqQueue.length; i++) {
            if (reqQueue[i]>initHeadCylinder) {
                startIndex = i;
                break;
            }
        }

        for (int i = startIndex; i<reqQueue.length; i++) {
            scheduleSequence[nextSequenceIndex++] = reqQueue[i];
        }

        /** Immediately return to the beginning of the disk and move right **/

        for (int i = 0; i<startIndex; i++) {
            scheduleSequence[nextSequenceIndex++] = reqQueue[i];
        }

        return scheduleSequence;
    }

    public int getTotalTrackMovement() {
        int currHeadPosition = initHeadCylinder;

        for (int cylinder: scheduleSequence) {
            totalTrackMovement += Math.abs(currHeadPosition - cylinder);
            currHeadPosition = cylinder;
        }

        return totalTrackMovement;
    }
    public int [] getTrackMovement() {
        int currHeadPosition = initHeadCylinder;
        int arr1[] = new int[25];
        for (int cylinder: scheduleSequence) {
            totalTrackMovement += Math.abs(currHeadPosition - cylinder);
            arr1[i]=Math.abs(currHeadPosition - cylinder);
            i++;
            currHeadPosition = cylinder;
        }

        return arr1;
    }
    
    public int getseektime()
    {
     stime = abs(initHeadCylinder - reqQueue[0]);
     for(int i=1;i<reqQueue.length;i++)
    {
    stime = stime + abs(reqQueue[i-1]-reqQueue[i]) ;
    }
     return (int) stime;  
    }

public float getavgseektime()
    {
     stime = abs(initHeadCylinder - reqQueue[0]);
     for(int i=1;i<reqQueue.length;i++)
    {
    stime = stime + abs(reqQueue[i-1]-reqQueue[i]) ;
    avgstime = stime/reqQueue.length;
    }
     return  avgstime;   
    }


    public int[] getReqQueue() {
        return reqQueue;
    }

    public void setReqQueue(int[] reqQueue) {
        this.reqQueue = new int[reqQueue.length];
        System.arraycopy(reqQueue, 0, this.reqQueue, 0, reqQueue.length);
    }

    public int getInitHeadCylinder() {
        return initHeadCylinder;
    }

    public void setInitHeadCylinder(int initHeadCylinder) {
        this.initHeadCylinder = initHeadCylinder;
    }

   
}
