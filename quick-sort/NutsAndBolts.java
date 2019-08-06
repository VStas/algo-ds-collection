/*
    Nuts and bolts. A disorganized carpenter has a mixed pile of n nuts and n bolts.
    The goal is to find the corresponding pairs of nuts and bolts
    Each nut fits exactly one bolt and each bolt fits exactly one nut.
    By fitting a nut and a bolt together, the carpenter can see which one is bigger (but the carpenter cannot compare two nuts or two bolts directly).
    Design an algorithm for the problem that uses at most proportional to nlogn compares (probabilistically).
*/

// Idea found here https://www.geeksforgeeks.org/nuts-bolts-problem-lock-key-problem/

import java.util.Arrays;


public class NutsAndBolts {

    private static void matchPairs(int[] nuts, int[] bolts, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int pivot = partition(nuts, bolts[hi], lo, hi);
        partition(bolts, nuts[pivot], lo, hi);
        matchPairs(nuts, bolts, lo, pivot - 1);
        matchPairs(nuts, bolts, pivot + 1, hi);
    }

    private static int partition(int[] arr, int pivot, int lo, int hi) {
        int i = lo; // we make so that to left of i everything is < pivot. And move element that =pivot to hi
        for (int j = lo; j < hi; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            } else if (arr[j] == pivot) {
                swap(arr, j, hi);
                j--;
            }
        }
        swap(arr, i, hi);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] nuts =    new int[] {1, 6, 3, 2, 4, 8, 9, 7, 10, 5};
        int[] bolts =   new int[] {3, 5, 1, 2, 7, 9, 10, 4, 8, 6};

        matchPairs(nuts, bolts, 0, 9);

        System.out.println(Arrays.toString(nuts));
        System.out.println(Arrays.toString(bolts));
    }
}