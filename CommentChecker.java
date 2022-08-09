import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CommentChecker {

    public static void main(String[] args) throws IOException {

        File file = new File("sample.c");
        Scanner sc = new Scanner(file);
        FileReader fr = new FileReader("sample.c");
        FileWriter fw = new FileWriter("sample.out");
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
// ((i = (char) fr.read()) == '/') && ((i = (char) fr.read()) == '*')
