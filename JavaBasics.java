public class JavaBasics {
    public static void main(String args[]) {
        printPattern(4);
    }

    public static void printPattern(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                if (j < x - i) {
                    System.out.printf(" * ");
                }
            }
            System.out.printf("\n");
        }
    }
}