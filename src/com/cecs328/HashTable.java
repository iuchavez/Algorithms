package com.cecs328;

import java.util.ArrayList;
import java.util.Scanner;

//TODO import BigInteger;

/**
 * This is meant to hold Strings and assign slots in a hash table based
 * on the hashed value of those tokens. This program uses a technique
 * known as separate chaining to avoid collisions.
 * @author Isaac Chavez
 * @version 0.2
 **/
public class HashTable{

    public static void main(String args[]){
        System.out.println("How big do you want your HashTable to be?");
        int hashTableSize = checkIntRange(0, Integer.MAX_VALUE);
        HashTable ht = new HashTable(hashTableSize);

        for(int i = 0; i < hashTableSize; i++){
            if(i == 0){
                System.out.print("Please enter a word: ");
            }else{
                System.out.print("Enter another one, we're going up to " + hashTableSize + ": ");
            }
            ht.insert(getString());
        }
        System.out.println("\nHere is your HashTable with Seperate Chaining Collision Handling!");
        ht.printHash();
    }

    /** 2D ArrayList holding Tokens**/
    ArrayList<ArrayList<String>> table;

    /** Indicates the size of the list **/
    private int size;

    public static final int DEFAULT_PADDING = 1;
    /**
     * Takes in an array of Strings and adds them all as tokens to the table data member
     * @param aSize size is the size of the desired separate chaining table
     **/
    public HashTable(int aSize){
        // Get the size of the ArrayList and instantiate
        size = aSize;
        table = new ArrayList<ArrayList<String>>(aSize);
        // Prevents NullPointerExeption
        createEmptyArrayLists();
    }

    /**
     * This method populates the outer ArrayList called "table" with empty ArrayLists so that
     * the program will avoid a null pointer exception
     */
    private void createEmptyArrayLists(){
        for(int i = 0; i < size; i++){
            table.add(i, new ArrayList<String>());
        }
    }

    /**
     * Used with permission by Shannon Foss - CECS 277
     * Takes in a string from the user.
     * @return the inputted String.
     * @author Shannon Foss, CECS 277
     */
    public static String getString() {
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        return input;
    }

    /**
     * Checks that the inputted value is an integer and
     * Used with permission by Shannon Foss - CECS 277
     * within the specified range.
     * @param low lower bound of the range.
     * @param high upper bound of the range.
     * @return the valid input.
     * @author Shannon Foss, CECS 277
     */
    public static int checkIntRange(int low, int high) {
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        int input = 0;
        boolean valid = false;
        while(!valid) {
            if(in.hasNextInt()) {
                input = in.nextInt();
                if(input <= high && input >=low) {
                    valid = true;
                } else {
                    System.out.println("Invalid Input.");
                }
            } else {
                in.next();
                System.out.println("Invalid Input.");
            }
        }
        return input;
    }

    /**
     * Traverses the table and returns true if the value is present and returns boolean accordingly
     * @param aToken str the value desired
     * @return boolean true if found, false if not found
     **/
    public boolean contains(String aToken){
        // TODO Hash the str and mod by size then check the array list at that index
        int outerArrayIndex = hash(aToken)%size;

        if(table.get(outerArrayIndex) != null){
            // First check to see if the token exists in that sub array
            ArrayList<String> listOfTokens = table.get(outerArrayIndex);
            int i = 0;
            for (String anotherToken : listOfTokens) {
                if(aToken.equals(anotherToken)){
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    /** Simply returns a listed version of the hash table, numbered
     * @return String of a listed version of the table.
     **/
    public String toString(){
        // Starts the output array with nothing
        String outputString = "";

        // Sets useful strings as vars
        final String SPACE = " ";
        final String NEW_LINE = "\n";

        //TODO returns a listed version of the hash table, numbered
        int j = 1;
        for (ArrayList<String> arrayList : table) {
            outputString = outputString+(j+":"+SPACE);
            outputString = outputString+SPACE+arrayList+SPACE;
            outputString = outputString+NEW_LINE;
            j++;
        }
        return outputString;
    }

    /**
     * Handles all additions to the table data member
     * It does not allow duplicates in and uses separate chaining to avoid collisions.
     * @param aString the value of the element being inserted to the HashTable
     * @return an indicator of the success or failure of the procedure
     **/
    private void insert(String aString){
        // This finds the two indexes where the category is found
        int outterArrayIndex = hash(aString)%size;
        table.get(outterArrayIndex).add(aString);
    }

    public int hash(String str){
        //TODO use horners alg
        int hashValue = 0;

        char[] aCharArr = str.toCharArray();
        int sizeOfCharArr = aCharArr.length;
        for(int i = 0; i < sizeOfCharArr; i++){
            hashValue = hashValue*37;
            hashValue = hashValue+aCharArr[i];
        }
        return Math.abs(hashValue);
    }

    public void printHash(){
        int i = 0;
        for(ArrayList<String> al : table){
            System.out.print(i+") ");
            int j = 0;
            for (String str : al){
                System.out.print(str);
                if(j+1 < al.size()){
                    System.out.print(", ");
                }
                j++;
            }
            i++;
            System.out.println();
        }
    }

    public static void printArray(ArrayList<String> arr){

        int i = 1;
        for (String string : arr) {
            System.out.println(i+")"+" "+arr);
            i++;
        }
    }

    //TODO Add validation to your program.
}