import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CommentChecker {

    public static void main(String[] args) throws IOException {
        commentsRemover();
        linesRemover();
        whiteSpaceRemover();
    }

    public static void whiteSpaceRemover() throws IOException {

    }
    public static void linesRemover() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sample.out"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("sample2.out"));
        Scanner sc = new Scanner(br);
        while (sc.hasNextLine()) {
            String s = "";
            s = s + sc.nextLine();
            while (s.length() == 0) {
                s = s + sc.nextLine();
            }
            System.out.println(s);
            bw.write(s + '\n'); 
        }
        bw.close();
        br.close();
        sc.close();
    }
    public static void commentsRemover() throws IOException {
        FileReader fr = new FileReader("sample.c");
        FileWriter fw = new FileWriter("sample.out");
        Scanner sc = new Scanner(fr);
        int flag;
        while (fr.ready()) {
            char i = (char) fr.read();
            if (i == '/') {
                flag = 0;
                i = (char) fr.read();
                if (i == '/') // for one line comment
                {
                    flag = 1;
                    while ((i = (char) fr.read()) != '\n')
                        ;
                } else if (i == '*') // for multi line comment
                {
                    flag = 1;
                    while (fr.ready()) {
                        i = (char) fr.read();
                        if ((i = (char) fr.read()) == '/') {
                            i = '\n';
                            break;
                        }
                    }
                }
                if (flag == 0) {
                    fw.write('/');
                }
            }
            fw.write(i);
        }
        fw.close();
        fr.close();
        sc.close();
    }
}