/**
 * A simple program that finds prints the greatest common divisor (gcd) between two numbers
 * Created by Isaac on 7/11/2017.
 */
public class GCDFinder {
    
    public static void main(String[] args){
        GCDFinder getGcd = new GCDFinder();
        String BORDER = "////////////////";
        String PROGRAM_TITLE = " GCD Finder ";
        String NEW_LINE = "\n";
        System.out.print(BORDER + PROGRAM_TITLE + BORDER + NEW_LINE);

        int control_value;

        do {
            // Prompts user input
            System.out.print("Please enter a positive integer grater than 1: ");
            // Retrieves integer value > 0 as part of a pair for which a gcd is desired
            int positiveIntA = CheckInput.checkIntRange(1, Integer.MAX_VALUE);
            // Prints a new line character
            System.out.print(NEW_LINE);

            // Prompts user for input
            System.out.print("Please enter another positive integer greater than 1: ");
            // Retrieves integer value > 0 as part of a pair for which a gcd is desired
            int positiveIntB = CheckInput.checkIntRange(1, Integer.MAX_VALUE);
            int gcd = getGcd.gcd(positiveIntA, positiveIntB);
            System.out.print(gcd);
            // Prints a new line character
            System.out.print(NEW_LINE + NEW_LINE);

            // Prompts usr for input
            System.out.print("To the GCD of another pair enter the number 1. To exit, enter 2: ");
            // Retrieves input from the user to conditionally continue program
            control_value = CheckInput.checkIntRange(1,2);
            System.out.print(NEW_LINE);
        }while(control_value == 1);
    }

    /**
     * Simply calls a helper method by setting up proper input
     * @return the gcd
     */
    public int gcd(int a,int b){

        int minValue = min(a,b);
        int minHalf = minValue/2;
        int counter = minHalf;
        if(a == minValue){
            return recursiveGcd(a,b, counter);
        }
        if(b == min(a,b)){
            return recursiveGcd(b,a, counter);
        }

        return 0;



    }

    /**
     * This is a recursive helper method which ultimately finds the gcd for any two positive numbers
     * @param a first number in a pair for which the gcd is desired
     * @param b second number in a pair for which the gcd is required
     * @param i a counter which is decremented to 1
     * @return a common denominator
     */
    public int recursiveGcd(int a, int b, int i){

        // This will be used in the recursive helper method to determine where to start the count down!
        while((minValue%i) > 0){
            counter--;
        }

        // Logic needa to be added in order to check the value a itself and the value b itself


        if(i <= 1){
            return 1;
        }
        
        int maxCd = recursiveGcd(a, b, i-1);

        int cd = 1;
        if(a%i == 0){
            if(b%i == 0){
                cd = i;
            }
        }

        return max(maxCd, cd);
    }

    /**
     * Finds the maximum value between two numbers
     * @return max value
     */
    private int max(int a, int b){
        // Assume the max value is a
        int max = a;
        // Check if b is bigger
        if(b > a){
            // if b is bigger, then I stand corrected
            max = b;
        }
        // return whichever was the bigger value
        return max;
    }

    /**
     * Finds the minimum value between two numbers
     * @return max value
     */
    private int min(int a, int b){
        // Assume the min value is a
        int min = a;
        // Check if b is smaller
        if(b < a){
            // if b is bigger, then I stand corrected
            min = b;
        }
        // return whichever was the smaller value
        return min;
    }
}

