import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * A simple program that finds prints the greatest common divisor (gcd) between two numbers
 * Created by Isaac on 7/11/2017.
 */
public class GCDFinder {

    public static void main(String[] args) {

        String BORDER = "////////////////";
        String PROGRAM_TITLE = " GCD Finder ";
        String NEW_LINE = "\n";
        System.out.print(BORDER + PROGRAM_TITLE + BORDER + NEW_LINE);

        int control_value;

        ArrayList<Integer> inputValues = new ArrayList<Integer>();
        do {
            // Clears out the array list
            inputValues.clear();

            // Prompts user input
            System.out.print("Please enter a positive integer grater than 1: ");
            // Retrieves integer value > 0 as part of a pair for which a gcd is desired
            inputValues.add(checkIntRange(1, Integer.MAX_VALUE));
            // Prints a new line character

            do{

                // Prompts user input
                System.out.print("Please enter a positive integer grater than 1: ");
                // Retrieves integer value > 0 as part of a pair for which a gcd is desired
                inputValues.add(checkIntRange(1, Integer.MAX_VALUE));

                System.out.print("Enter another number?"+NEW_LINE+"1) Yes"+NEW_LINE+"2) No");
                control_value = checkIntRange(1, 2);

            }while(control_value == 1);

//            for(int x : inputValues){
//                System.out.println("["+x+"]");
//            }

            double startTime = System.nanoTime();
            System.out.println(new GCDFinder().gcd(inputValues));
            double endTime = System.nanoTime();
            System.out.println("Duration: "+(endTime-startTime)/(1000000000));

            // Prints a new line character
            System.out.print(NEW_LINE);

            // Prompts usr for input
            System.out.print("1) Try Again"+NEW_LINE+"2) Exit"+NEW_LINE);
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
    public int gcd(ArrayList<Integer> input) {
        int commonDenom = euclideanGcd(input.get(0), input.get(1));
        for (int i = 2; i < input.size(); i++){
            commonDenom = euclideanGcd(input.get(i), commonDenom);
        }
        int gcd = commonDenom;
        return gcd;
    }

    /**
     * This is a recursive helper method which ultimately finds the gcd for any two positive numbers
     * @return a common denominator
     */
    public int euclideanGcd(int a, int b) {
        if(b > a){
            // swap a and b
            int temp;
            temp = a;
            a = b;
            b = temp;
        }
//        System.out.println("a-value: " + a + " b-value: " + b);
        if (a%b == 0) {
            return b;
        }
        return euclideanGcd(b, a%b);
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