import java.util.Scanner;

public class JavaBasics {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        print01Triangle(input);
    }

    public static void printStarPattern1(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                if (j < x - i) {
                    System.out.printf(" * ");
                }
            }
            System.out.printf("\n");
        }
    }

    public static void printStarPattern2(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                if (j <= i) {
                    System.out.printf(" * ");
                }
            }
            System.out.printf("\n");
        }
    }

    public static void printStarPattern3(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                if (j >= x - i - 1) {
                    System.out.printf(" * ");
                } else {
                    System.out.printf("   ");
                }
            }
            System.out.printf("\n");
        }
    }

    public static void printSquarePattern(int x) {
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

    public static Boolean isPrimeNumber(int x) {
        if (x < 2) {
            return false;
        } else if (x == 2) {
            return true;
        } else if (x % 2 == 0) {
            return false;
        } else {
            for (int i = 3; i <= Math.sqrt(x); i += 2) {
                if (x % i == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void printHalfPyramidPattern(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(j + 1);
            }
            System.out.printf("\n");
        }
    }

    public static void printCharacterPattern(int x) {
        char c = 'A';
        for (int i = 0; i < x; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(c);
                c++;
            }
            System.out.printf("\n");
        }
    }

    public static void printHollowRectanglePattern(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                if (i == 0 || i == x - 1 || j == 0 || j == x - 1) {
                    System.out.printf(" * ");
                } else {
                    System.out.printf("   ");

                }
            }
            System.out.printf("\n");
        }
    }

    public static void printInvertedHalfPyramidPattern(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x - i; j++) {
                System.out.print(j + 1);
            }
            System.out.printf("\n");
        }
    }

    public static void printFloydTriangle(int x) {
        int num = 1;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j <= i; j++) {
                if (num < 10) {
                    System.out.print(" " + num + "  ");
                } else {
                    System.out.print(num + "  ");
                }
                num++;
            }
            System.out.printf("\n");
        }
    }

    public static void print01Triangle(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");

                }
            }
            System.out.printf("\n");
        }
    }

}
