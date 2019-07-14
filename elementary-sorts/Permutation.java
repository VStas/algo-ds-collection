// Permutation. Given two integer arrays of size nn, design a subquadratic algorithm to determine whether one is a permutation of the other.
// That is, do they contain exactly the same entries but, possibly, in a different order.


public class Permutation {
    public static void insertionSort(int[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    exch(a, j, j-1);
                }
            }
        }
    }

    private static void exch(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean isPermutation(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }
        insertionSort(a);
        insertionSort(b);
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 3};
        int[] b = {3, 3, 5, 7, 1};

        assert isPermutation(a, b);

        int[] c = {1, 3, 5, 8, 3};
        int[] d = {3, 3, 5, 7, 1};

        assert !isPermutation(c, d);

        int[] e = {1};
        int[] f = {3, 6, 1};

        assert !isPermutation(e, f);
    }
}