import java.util.Arrays;

public class KnuthShuffle {

    private static void shuffle(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int r = (int) (Math.random() * (i + 1)); // [0, i]
            exch(arr, i, r);
        }
    }

    private static void exch(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 7, 4, 9, 10, 1};
        shuffle(arr);
        System.out.println(Arrays.toString(arr));
    }
}