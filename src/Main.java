import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        Scanner cin = new Scanner(System.in);
        String input = "";
        while(!input.equals("xq")) { // exit
            input = cin.next();
            if (input.equals("st")) {
                stopwatch.start();
            }
            else if (input.equals("lap")) {
                input = cin.next();
                input = input.toLowerCase();
                stopwatch.lap(input);
            }
            else if (input.equals("pr")) {
                FileIO.printTime();
            }
        }

    }
}
