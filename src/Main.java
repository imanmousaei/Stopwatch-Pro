import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        Scanner cin = new Scanner(System.in);
        String input = "";
        while(!input.equals("x")) {
            input = cin.next();
            if (input.equals("s")) {
                stopwatch.start();
            }
            else if (input.equals("lap")) {
                input = cin.next();
                stopwatch.lap(input);
            }
        }

    }
}
