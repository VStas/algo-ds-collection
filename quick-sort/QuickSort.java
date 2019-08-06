import java.util.Arrays;

public class QuickSort {

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi+1;
        while (true) {
            while (less(a[++i], a[lo])) {
                if (i >= hi) break;
            }

            while (less(a[lo], a[--j])) {
                if (j <= lo) break; // redundant (from lecture)
            }

            if (j <= i) {
                break;
            }

            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static void sort(Comparable[] a, int i, int j) {
        if (i >= j) {
            return;
        }
        int pivot = partition(a, i, j);
        sort(a, i, pivot - 1);
        sort(a, pivot + 1, j);
    }

    private static void sort(Comparable[] a) {
        // TODO shuffle here
    
        sort(a, 0, a.length - 1);
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[] {5, 2, 3, 6, 2, 8, 4};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}