// Counting inversions. An inversion in an array a[] is a pair of entries a[i] and a[j]
// such that i < j but a[i] > a[j]. Given an array, design a linearithmic algorithm to count the number of inversions.

import java.util.Arrays;


public class Inversions {

    private static int merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

        // copy
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        // merge
        int i = lo;
        int j = mid + 1;
        int inversions = 0;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)               a[k] = aux[j++];
            else if (j > hi)                a[k] = aux[i++];
            else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
                inversions += mid+1-i;
            }
            else                            a[k] = aux[i++];
        }

        return inversions;
    }

    private static int sortAndCountInversions(Comparable[] a) {
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        int inversions = 0;

        for (int sz = 1; sz < N; sz = sz+sz) {
            for (int lo = 0; lo < N-sz; lo += sz + sz) {
                int mid = lo+sz-1;
                int hi = Math.min(lo+sz+sz-1, N-1);
                inversions += merge(a, aux, lo, mid, hi);
            }
        }

        return inversions;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    public static void main(String[] args) {
        Integer[] a = {1, 2, 6, 8, 9, 2, 3, 4, 7, 8};
        System.out.println(Arrays.toString(a));
        assert sortAndCountInversions(a) == 12;
        System.out.println(Arrays.toString(a));

        Integer[] b = {1, 7, 9, 4, 8, 5};
        System.out.println(Arrays.toString(b));
        assert sortAndCountInversions(b) == 6;
        System.out.println(Arrays.toString(b));
    }
}