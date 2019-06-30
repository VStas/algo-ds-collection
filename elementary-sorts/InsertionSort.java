import java.util.Arrays;


public class InsertionSort {

    private static void sort(Comparable[] arr) {
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(arr[j - 1], arr[j])) {
                    break;
                }
                exch(arr, j, j - 1);
            }
        }
    }
    private static void exch(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 7, 4, 9, 10, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
