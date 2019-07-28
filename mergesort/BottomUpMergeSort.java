import java.util.Arrays;


public class BottomUpMergeSort {

    // copy paste from merge sort
    // a[low...mid] is sorted and a[mid+1...hi] is sorted
    // after this merge a[low...hi] is sorted
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

        // copy
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        // merge
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)               a[k] = aux[j++];
            else if (j > hi)                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))  a[k] = aux[j++];
            else                            a[k] = aux[i++];
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void sort(Comparable[] a) {
        int N = a.length;
        Comparable[] aux = new Comparable[N];

        for (int sz = 1; sz < N; sz = sz+sz) {
            for (int lo = 0; lo < N-sz; lo += sz + sz) {
                int mid = lo+sz-1;
                int hi = Math.min(lo+sz+sz-1, N-1);
                merge(a, aux, lo, mid, hi);
                // System.out.println(Arrays.toString(a));
            }
        }
    }

    public static void main(String[] args) {
        Integer a[] = {1, 3, 2, 8, 5, 8, 4, 3, 5, 12, 6, 2, 5, 2, 1, 0};

        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}