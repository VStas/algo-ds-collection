public class QuickSelect {

    ////// Copy paste from quicksort
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

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
    //////

    private static Comparable search(Comparable[] a, int k) {
        int lo = 0;
        int hi = a.length - 1;

        // need to shuffle here

        while (lo < hi) {
            int j = partition(a, lo, hi);
            if (j < k)      lo = j + 1;
            else if (j > k) hi = j - 1;
            else            return a[k];
        }
        return a[k]; // nothing more to sort in this place so it should be correct(???) - it's like in lecture
    }


    public static void main(String[] args) {
        Integer[] a = new Integer[] {3, 2, 5, 2, 7, 3, 2, 9, 10, 1, 5};
        assert (Integer)search(a, 3) == 2;
        assert (Integer)search(a, 0) == 1;
        assert (Integer)search(a, a.length - 1) == 10;
    }
}