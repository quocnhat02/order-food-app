package array;

import java.util.Scanner;

/**
 * ArraysCC
 */
public class ArraysCC {
    public static int linearSearch(int numbers[], int key) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == key) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int numbers[] = { 97, 98, 99 };
        int key = 98;

        int index = linearSearch(numbers, key);
        if (index == -1) {
            System.out.println("NOT found");
        } else {
            System.out.println("key is at index " + index);
        }
    }

}