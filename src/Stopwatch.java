import java.util.Calendar;
import java.util.Scanner;

public class Stopwatch {
    FileIO lastLapFile = new FileIO("lastLap.txt");
    FileIO laps = new FileIO(systemToString());

    public void start(){
        lastLapFile.write(getSystemTimeInSecond());
    }

    public void lap(String activity){
        int lastLapTime = lastLapFile.readInt();
        int now = getSystemTimeInSecond();
        System.out.println(now-lastLapTime);
    }

    public static int getSystemYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public static int getSystemMonth() {
        return Calendar.getInstance().get(Calendar.MONTH);
    }

    public static int getSystemDay() {
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }

    public static int getSystemHour() {
        return Calendar.getInstance().get(Calendar.HOUR);
    }

    public static int getSystemMinute() {
        return Calendar.getInstance().get(Calendar.MINUTE);
    }

    public static int getSystemSecond() {
        return Calendar.getInstance().get(Calendar.SECOND);
    }

    public static int getSystemTimeInSecond() {
        return (((((getSystemYear() * 12) + getSystemMonth()) * 30 + getSystemDay()) * 24 + getSystemHour()) * 60 + getSystemMinute()) * 60 + getSystemSecond();
    }

    public static String systemToString() {
        return getSystemYear() +
                "/" + getSystemMonth() +
                "/" + getSystemDay() ;
    }

}
