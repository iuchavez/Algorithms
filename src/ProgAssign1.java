/**
 * A simple program that finds prints the greatest common divisor (gcd) between two numbers
 * Created by Isaac on 7/11/2017.
 */
public class ProgAssign1 {
    
    public static void main(String[] args){
        ProgAssign1 getGcd = new ProgAssign1();
        int gcd = getGcd.gcd(48, 18);
        System.out.print(gcd);
    }

    /**
     * Simply calls a helper method by setting up proper input
     * @return the gcd
     */
    public int gcd(int a,int b){
        // The a var is copied for the first and second input because the second one is a counter
        int counter = a;
        return recursiveGcd(a,b, counter);
    }

    /**
     * This is a recursive helper method which ultimately finds the gcd for any two positive numbers
     * @param a first number in a pair for which the gcd is desired
     * @param b second number in a pair for which the gcd is required
     * @param i a counter which is decremented to 1
     * @return a common denominator
     */
    public int recursiveGcd(int a, int b, int i){
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
}

