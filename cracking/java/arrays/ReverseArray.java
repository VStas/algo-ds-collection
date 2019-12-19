/** Reverse array */


import java.util.Arrays;

public class ReverseArray {

    private static <T> void reverseArray(T[] arr) {
        int n = arr.length;

        for (int i = 0; i < n/2; i++) {
            int j = n - i - 1;

            T temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void test(Integer[] arrToReverse, Integer[] expected) {
        ReverseArray.<Integer>reverseArray(arrToReverse);
        assert Arrays.equals(arrToReverse, expected);
    }

    public static void main(String[] args) {
        test(
            new Integer[] {1, 2, 3, 4, 5},
            new Integer[] {5, 4, 3, 2, 1}
        );
        test(
            new Integer[] {1, 2, 3, 4, 5, 6},
            new Integer[] {6, 5, 4, 3, 2, 1}
        );
    }
}