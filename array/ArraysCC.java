package array;

import java.util.Scanner;

/**
 * ArraysCC
 */
public class ArraysCC {
    public static void update(int marks[], int nonChangeable) {
        nonChangeable = 10;
        for (int i = 0; i < marks.length; i++) {
            marks[i] = marks[i] + 1;
        }
    }

    public static void main(String[] args) {
        int marks[] = { 97, 98, 99 };
        int nonChangeable = 5;
        update(marks, nonChangeable);
        System.out.println(nonChangeable);

        // print our marks
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
        }

    }

}