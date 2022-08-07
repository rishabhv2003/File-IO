import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       /* File file = new File("testcases.out");

        try {
            file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileWriter filewriter = new FileWriter("testcases.out");
            filewriter.write("this is a file");
            filewriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */


        File file = new File("01d_test1.c");
        try  {

            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
    }
}