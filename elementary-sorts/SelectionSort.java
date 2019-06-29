import java.util.Arrays;


public class SelectionSort {

    private static void sort(Comparable[] arr) {
        int N = arr.length;
        for (int i = 0; i < N - 1; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(arr[j], arr[min])) {
                    min = j;
                }
            }
            exch(arr, i, min);
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
