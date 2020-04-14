import java.io.*;
import java.util.*;

public class FileIO {
    String fileName;
    File file;
    Scanner scanner;

    public FileIO(String fileName) {
        this.fileName = fileName;
        this.file = new File(fileName);
        createFile();
        try {
            scanner = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void printTime(){
        Scanner reader = null;
        File activitiesFile = new File("files/activities.txt");
        try {
            reader = new Scanner(activitiesFile);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(reader.hasNext()) {
            String activity = reader.next();
            FileIO activityFile = new FileIO("files/" + activity + ".txt");
            int timeUsed = activityFile.readFirstInt();
            System.out.println(activity + " -> " + Stopwatch.secondToTimeFormat(timeUsed));
        }
    }
    public static void reset(){
        Scanner reader = null;
        File activitiesFile = new File("files/activities.txt");
        try {
            reader = new Scanner(activitiesFile);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(reader.hasNext()) {
            String activity = reader.next();
            FileIO activityFile = new FileIO("files/" + activity + ".txt");
            int timeUsed = activityFile.readFirstInt();
            System.out.println(activity + " -> " + Stopwatch.secondToTimeFormat(timeUsed));
            activityFile.write("0");
        }
    }

    public int readFirstInt(){
        Scanner reader = null;
        try {
            reader = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
        if(reader.hasNextInt()) {
            return reader.nextInt();
        }
        else{
            return 0;
        }
    }

    public void createFile() {
        try {
            file.createNewFile();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String str) {
        FileWriter myWriter;
        str += "\n";
        try {
            myWriter = new FileWriter(fileName);
            myWriter.write(str);
            myWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void append(String textToAppend) throws IOException {
        BufferedWriter writer = new BufferedWriter(
                new FileWriter(fileName, true)  //Set true for append mode
        );
        writer.write(textToAppend);
        writer.newLine();   //Add new line
        writer.close();
    }

    public boolean found(String str) {
        while (scanner.hasNext()) {
            String data = scanner.next();
            //System.out.println(data);
            //System.out.println(str);
            if (data.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
