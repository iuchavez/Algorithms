/**
 * A simple test program that is designed to output the string "Hello World" to the console.
 * Created by Isaac on 7/11/2017.
 */
public class HelloWord {

    private String output;

    public HelloWord(String out) {
        this.output = out;
    }

    public static void main(String args[]){
        HelloWord test1 = new HelloWord("Hello Universe!");
        test1.printMessage();
    }

    public void printMessage(){
        System.out.print(output);
    }
}
