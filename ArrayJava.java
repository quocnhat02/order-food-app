public class ArrayJava {
    public static void main(String[] args) {
        int marks[] = { 2, 6, 9, 11, 17, 23 };

        System.out.print(binarySearch(marks, 9));

    }

    public static int binarySearch(int array[], int key) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;

            if (array[mid] == key) {
                return mid;
            } else if (array[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

}
