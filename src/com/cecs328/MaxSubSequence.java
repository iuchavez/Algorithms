package com.cecs328;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This is a class that tests four different approaches to solving the Maximum Sub-sequence Sum
 * problem. Each approach varies in speed.
 * @author Isaac Chavez
 *
 */
public class MaxSubSequence{

    public static Scanner in = new Scanner(System.in);

    public static void main(String args[]){

        MaxSubSequence ja = new MaxSubSequence();

        // Prompts the user for a comma serperated string of number-characters
        String commaSeperatedStr = prompt("Please enter a list of values seperated by commas:");
        String holder[] = commaSeperatedStr.split(",");
        // Converts each string into an integer and stores them in an array
        int values[] = new int[holder.length];
        for (int i = 0; i < holder.length; i++) {
            values[i] = Integer.parseInt(holder[i]);
        }
        String fullSetSelection = "1,2,3,4";
        ArrayList<String> fullSetHolder = new ArrayList<String>(Arrays.asList(fullSetSelection.split(",")));
        for (String s : fullSetHolder) {
            ja.computeMSS(s, values);
        }
//		printArray(values);

        // Prompt user for integer value i and create an array of length i
        int userInt = Integer.parseInt(prompt("\nPlease enter the size of the Array:"));
        int[] randArray = ja.randArrayGenerator(userInt);
//		printArray(randArray);

        String selectionCommaSeperated = prompt("\nPlease select one or more algorithms you \nwould like to test according to the codes 1,2,3,4");
        ArrayList<String> selectionHolder = new ArrayList<String>(Arrays.asList(selectionCommaSeperated.split(",")));

        for (String s : selectionHolder) {
            ja.computeMSS(s, randArray);
        }
    }

    /**
     * Simply asks the user for a value and returns that value no validation
     * @return A string entered by the user.
     */
    public static String prompt(String msg){
        System.out.println(msg);
        in = new Scanner(System.in);
        String output = in.nextLine();
        return output;
    }

    /**
     * Prints an integer array
     * @param arr the array to be printed
     */
    public static void printArray(int[] arr){
        if(arr.length > 0){
            System.out.println(arr[0]);
        }
        else return;
        printArray(Arrays.copyOfRange(arr, 1, arr.length));
    }

    /**
     * Returns an array of a desired length with random values ranging from -50 to 50
     * @param lengthValue the desired length of the array
     * @return an array of size i with random values (-50 to 50)
     */
    public int[] randArrayGenerator(int lengthValue){
        int newValues[] = new int[lengthValue];
        for (int i = 0; i < lengthValue; i++) {
            newValues[i] = ((int)((Math.random()*100)%100)-50);
        }
        return newValues;
    }

    /**
     *
     * @param s
     * @param values
     */
    public void computeMSS(String s, int[] values){
        switch (Integer.parseInt(s)) {
            case 1:
                double startFm = (double)System.nanoTime() /1000000;
                System.out.println("Freshman Algorithm: " + mss_freshman(values));
                double endFm = (double)System.nanoTime() /1000000;
                double fmTime = endFm - startFm;
                String totalTimeFm = (fmTime < 1000) ? (fmTime)+" ms" : (fmTime/1000)+" s";
                System.out.println(totalTimeFm);
                break;
            case 2:
                double startSm = (double)System.nanoTime() / 1000000;
                System.out.println("Sophomore Algorithm: " + mss_sophmore(values));
                double endSm = (double)System.nanoTime() / 1000000;
                double smTime = endSm - startSm;
                String totalTimeSm = (smTime < 1000) ? (smTime)+" ms" : (smTime/1000)+" s";
                System.out.println(totalTimeSm);
                break;
            case 3:
                double startJr = (double)System.nanoTime() / 1000000;
                System.out.println("Junior Algorithm: " + mss_junior(values, 0, values.length-1));
                double endJr = (double)System.nanoTime() / 1000000;
                double jrTime = endJr - startJr;
                String totalTimeJr = (jrTime < 1000) ? (jrTime)+" ms" : (jrTime/1000)+" s";
                System.out.println(totalTimeJr);
                break;
            case 4:
                double startSr = (double)System.nanoTime() / 1000000;
                System.out.println("Senior Algorithm: " + mss_senior(values));
                double endSr = (double)System.nanoTime() / 1000000;
                double srTime = endSr - startSr;
                String totalTimeSr = (srTime < 1000) ? (srTime)+" ms" : (srTime/1000)+" s";
                System.out.println(totalTimeSr);
                break;

            default:
                break;
        }
    }

    /**
     * Solves the Max Sub Sequence Sum problem with a Junior level approach
     * @param a the complete sequence
     * @param left the left-most index of the sequence in question
     * @param right the right-most index of the sequence in question
     * @return the total max sum of the MSS
     */
    //Assume: we are only interested in the MSS that is found between a[left] and a[right].
    //Initial call to mss_junior: mss_junior(a,0,n-1)
    int mss_junior(int[ ] a, int left, int right)
    {
        //Base case 1
        if(right == left)
            return a[left];
        //Base case 2
        if(right == left+1)

            return Math.max(Math.max(a[left],a[right]),a[left]+a[right]);
        int mid = (left+right)/2;
        //Find the MSS that occurs in the left half of a
        int mss_left = mss_junior(a,left,mid);
        //Find the MSS that occurs in the right half of a
        int mss_right = mss_junior(a,mid+1,right);
        //Find the MSS that intersects both the left and right halves
        //EXERCISE: implement mss_junior_middle()

        int mss_middle = mss_junior_middle(a,left,mid,right);
        return Math.max(Math.max(mss_left,mss_right),mss_middle);
    }

    int mss_junior_middle(int[] a, int left, int mid, int right){
        int leftSum = Integer.MIN_VALUE;
//		System.out.print(Integer.MIN_VALUE);
        int sum = 0;
        int maxLeft = Integer.MIN_VALUE;

        for(int i = mid; i >= left; i--){
            sum += a[i];
            if(sum > leftSum){
                leftSum = sum;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        int maxRight = Integer.MIN_VALUE;
        for(int j = mid + 1; j <= right; j++){
            sum = sum + a[j];
            if(sum > rightSum){
                rightSum = sum;
            }
        }
//		System.out.println("leftSum:" + leftSum);
//		System.out.println("rightSum:" + rightSum);
        return rightSum + leftSum;
    }

    /**
     * Solves the Max Sub Sequence Sum problem with a freshman level approach.
     * @param a the complete sequence
     * @return the total max sum of the MSS
     */
    public int mss_freshman(int[] a){
        int max_sum = 0;
        int n = a.length;
        for(int i = 0; i < n; i++)
        {
            for(int j = i; j < n; j++)
            {
                int this_sum = 0;
                for(int k = i; k <= j; k++)
                    this_sum += a[k];
                if(this_sum > max_sum)
                    max_sum = this_sum;
            }
        }
        return max_sum;
    }

    /**
     * Solves the Max Sub Sequence Sum problem with a sophomore level approach.
     * @param a the complete sequence
     * @return the total max sum of the MSS
     */
    public int mss_sophmore(int[] a){
        int max_sum = 0;
        int n = a.length;
        for(int i=0; i< n; i++)
        {
            int this_sum= 0;
            for(int j = i; j < n; j++)
            {
                this_sum += a[j];
                if(this_sum > max_sum)
                    max_sum = this_sum;
            }
        }
        return max_sum;
    }

    /**
     * Solves the Max Sub Sequence Sum problem with a Senior level approach.
     * @param a the complete sequence
     * @return the total max sum of the MSS
     */
    public int mss_senior(int[] a){
        int max_sum = 0;
        int this_sum = 0;
        int n = a.length;
        for(int i=0; i< n; i++)
        {
            this_sum += a[i];
            if(this_sum > max_sum)
                max_sum = this_sum;
            else if(this_sum < 0)
                this_sum = 0;
        }
        return max_sum;
    }



}

