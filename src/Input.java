import java.util.Scanner;

public class Input {
    private static Scanner sc = new Scanner(System.in);
    public static int getNumber() {
         return sc.nextInt();
    }

    public static void scannerClose() {
        sc.close();
    }
}