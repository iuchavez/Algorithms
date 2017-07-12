/**
 * This contains static methods that will validate input
 * Created by Isaac on 7/11/2017.
 */
import java.util.Scanner;
/**
 * Used to check different types of user input.
 */
public class CheckInput {

    /**
     * Checks that the inputted value is an integer.
     * @return the valid input.
     */
    public static int checkInt() {
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        int input = 0;
        boolean valid = false;
        while(!valid) {
            if(in.hasNextInt()) {
                input = in.nextInt();
                valid = true;
            } else {
                in.next();
                System.out.println("Invalid Input.");
            }
        }
        return input;
    }

    /**
     * Checks that the inputted value is an integer and
     * within the specified range.
     * @param low lower bound of the range.
     * @param high upper bound of the range.
     * @return the valid input.
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
     * Checks that the inputted value is a double.
     * @return the valid input.
     */
    public static double checkDouble() {
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        double input = 0;
        boolean valid = false;
        while(!valid) {
            if(in.hasNextInt()) {
                input = in.nextDouble();
                valid = true;
            } else {
                in.next();
                System.out.println("Invalid Input.");
            }
        }
        return input;
    }

    /**
     * Takes in a string from the user.
     * @return the inputted String.
     */
    public static String getString() {
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        return input;
    }

    /**
     * This will output a random value within a range
     * @param min The minimum number desired
     * @param max The maximum number desired
     * @return A random integer between the numbers specified through input
     */
    public static int randomWithRange(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }
}