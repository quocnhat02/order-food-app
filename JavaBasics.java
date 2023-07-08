import java.util.Scanner;

public class JavaBasics {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        // printPattern1(input);
        // printPattern2(input);
        printReverseNumber(input);

    }

    public static void printPattern1(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                if (j < x - i) {
                    System.out.printf(" * ");
                }
            }
            System.out.printf("\n");
        }
    }

    public static void printPattern2(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {

                System.out.printf(" * ");

            }
            System.out.printf("\n");
        }
    }

    public static void printReverseNumber(int x) {
        int reverse = 0;
        int temp = x;

        while (temp > 0) {
            reverse = reverse * 10 + temp % 10;
            temp /= 10;
        }

        System.out.println(reverse);
    }

}
