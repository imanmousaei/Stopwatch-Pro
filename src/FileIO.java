import java.io.*;
import java.util.*;

public class FileIO {
    String fileName;
    File file;

    public FileIO(String fileName) {
        this.fileName = fileName;
        this.file = new File(fileName);
    }

    public void createFile() {
        try {
            file.createNewFile();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void write(String str) {
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

    private boolean found(String str) {

        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                //System.out.println(data);
                //System.out.println(str);

                if (data.equals(str)) {

                    return true;
                }
            }
            myReader.close();

        }
        catch (FileNotFoundException e) {

            e.printStackTrace();

        }
        return false;

    }
}
