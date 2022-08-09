import java.util.Scanner;

public class StringProperty {
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);

        String s = "rishabh";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
        sc.close();
    }
}
