import java.util.Scanner;

/**
 * A simple program that finds prints the greatest common divisor (gcd) between two numbers
 * Created by Isaac on 7/11/2017.
 */
public class GCDFinder {
    private int a;
    private int b;
    private int gcd;

    public GCDFinder(int aNum, int bNum) {
        a = aNum;
        b = bNum;
        gcd = gcd();
    }

    public static void main(String[] args) {

        String BORDER = "////////////////";
        String PROGRAM_TITLE = " GCD Finder ";
        String NEW_LINE = "\n";
        System.out.print(BORDER + PROGRAM_TITLE + BORDER + NEW_LINE);

        int control_value;

        do {
            // Prompts user input
            System.out.print("Please enter a positive integer grater than 1: ");
            // Retrieves integer value > 0 as part of a pair for which a gcd is desired
            int positiveIntA = checkIntRange(1, Integer.MAX_VALUE);
            // Prints a new line character
            System.out.print(NEW_LINE);

            // Prompts user for input
            System.out.print("Please enter another positive integer greater than 1: ");
            // Retrieves integer value > 0 as part of a pair for which a gcd is desired
            int positiveIntB = checkIntRange(1, Integer.MAX_VALUE);

            System.out.print(new GCDFinder(positiveIntA, positiveIntB));
            // Prints a new line character
            System.out.print(NEW_LINE + NEW_LINE);

            // Prompts usr for input
            System.out.print("To the GCD of another pair enter the number 1. To exit, enter 2: ");
            // Retrieves input from the user to conditionally continue program
            control_value = checkIntRange(1, 2);
            System.out.print(NEW_LINE);
        } while (control_value == 1);
    }

    /**
     * Simply calls a helper method by setting up proper input
     *
     * @return the gcd
     */
    public int gcd() {
        if (a % b == 0) {
            return b;
        }
        if (b % a == 0) {
            return a;
        }
        int counterA = a / 2;
        int counterB = b / 2;
        return max(recursiveGcd(counterA), recursiveGcd(counterB));
    }

    /**
     * This is a recursive helper method which ultimately finds the gcd for any two positive numbers
     *
     * @param i a counter which is decremented to 1
     * @return a common denominator
     */
    public int recursiveGcd(int i) {
        if (i == 1) {
            return 1;
        }
        if (a % i == 0) {
            if (b % i == 0) {
                return i;
            }
        }
        return recursiveGcd(i - 1);
    }

    /**
     * Finds the maximum value between two numbers
     *
     * @return max value
     */
    private int max(int a, int b) {
        // Assume the max value is a
        int max = a;
        // Check if b is bigger
        if (b > a) {
            // if b is bigger, then I stand corrected
            max = b;
        }
        // return whichever was the bigger value
        return max;
    }

    public String toString() {
        return "" + gcd;
    }


    /**
     * Used with permission by Shannon Foss - CECS 277
     * Checks that the inputted value is an integer and
     * within the specified range.
     *
     * @param low  lower bound of the range.
     * @param high upper bound of the range.
     * @return the valid input.
     * @Attribution: Shannon Foss, CECS 277
     */
    public static int checkIntRange(int low, int high) {
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        int input = 0;
        boolean valid = false;
        while (!valid) {
            if (in.hasNextInt()) {
                input = in.nextInt();
                if (input <= high && input >= low) {
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
}