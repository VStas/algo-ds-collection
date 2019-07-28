// Merging with smaller auxiliary array.
// Suppose that the subarray a[0] to a[n−1] is sorted and the subarray a[n] to a[2∗n−1] is sorted.
// How can you merge the two subarrays so that a[0] to a[2∗n−1] is sorted using an auxiliary array of length n (instead of 2n)?

import java.util.Arrays;


public class SmallerAuxMerge {

    public static void merge(Comparable[] a, Comparable[] aux, int n) {
        for (int i = 0; i < n; i++) {
            aux[i] = a[i];
        }
        int i = 0;
        int j = n;
        for (int k = 0; k < 2*n; k++) {
            if (i > n-1)                    a[k] = a[j++];
            else if (j > 2*n-1)             a[k] = aux[i++];
            else if (less(a[j], aux[i]))    a[k] = a[j++];
            else                            a[k] = aux[i++];
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    public static void main(String[] args) {
        Integer[] a = {1, 2, 6, 8, 9, 2, 3, 4, 7, 8}; // length == 10
        Integer[] aux = new Integer[5];
        System.out.println(Arrays.toString(a));
        merge(a, aux, 5);
        System.out.println(Arrays.toString(a));
    }
}