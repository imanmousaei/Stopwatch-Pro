import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        Scanner cin = new Scanner(System.in);
        String input = cin.next();
        if(input.equals("start")){
            stopwatch.start();
        }
        else if(input.equals("lap")){
            input = cin.next();
            stopwatch.lap(input);
        }

    }
}
