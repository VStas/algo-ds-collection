import java.util.Arrays;

public class ShellSort {

    private static void sort(Comparable[] arr) {
        int N = arr.length;
        int h = 1;
        while (h < N / 3) {
            h = h * 3 + 1; // 1 4 13 40 ...
        }

        while (h >= 1) {
            hsort(arr, h);
            h = h / 3;
        }
    }

    private static void hsort(Comparable[] arr, int h) {
        // System.out.println(h + "sorting");
        int N = arr.length;
        for (int i = h; i < N; i++) {
            for (int j = i; j >= h; j -= h) {
                if (less(arr[j-h], arr[j])) {
                    break;
                }
                exch(arr, j-h, j);
            }
        }
        // System.out.println(Arrays.toString(arr));
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
        // hsort(arr, 2);
        // hsort(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}