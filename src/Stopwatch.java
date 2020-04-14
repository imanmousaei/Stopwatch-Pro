import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

public class Stopwatch {
    FileIO lastLapFile = new FileIO("files/lastLap.txt");

    public void start() {
        lastLapFile.write(getSystemTimeInSecond() + "");
    }

    public void lap(String activity) {
        int lastLapTime = lastLapFile.readFirstInt();
        int now = getSystemTimeInSecond();
        FileIO activityFile = new FileIO("files/" + activity + ".txt");
        int timeUsed = activityFile.readFirstInt();
        timeUsed += now - lastLapTime;
        activityFile.write(timeUsed + "");
        start();
        System.out.println(activity + " -> " + secondToTimeFormat(timeUsed) );
    }

    public String secondToTimeFormat(int second){
        String timeFormat = "";
        int hour = second/3600;
        second -= hour*3600;
        int minute = second/60;
        second -= minute*60;

        if(hour>0){
            timeFormat += hour + ":";
        }
        if(minute>0){
            timeFormat += minute + "\':";
        }

        timeFormat += second + "\"";

        return timeFormat;
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
        return ((getSystemHour()) * 60 + getSystemMinute()) * 60 + getSystemSecond();
    }

    public static String systemToString() {
        return getSystemYear() +
                "/" + getSystemMonth() +
                "/" + getSystemDay();
    }

}
