// Dutch national flag. Given an array of n buckets, each containing a red, white, or blue pebble, sort them by color.
// The allowed operations are:

// swap(i, j): swap the pebble in bucket i with the pebble in bucket j.
// color(i): determine the color of the pebble in bucket i.
// The performance requirements are as follows:

// At most n calls to color().
// At most n calls to swap().
// Constant extra space.

import java.util.Arrays;

enum Color {
    RED,
    WHITE,
    BLUE
}

public class Flag {

    private static void swap(Color[] a, int i, int j) {
        Color temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static Color color(Color[] a, int i) {
        return a[i];
    }

    private static void sort(Color[] a) {
        int r = 0;
        int b = a.length - 1;
        int i = 0;

        while (i <= b) {
            if (color(a, i) == Color.RED) {
                swap(a, i, r);
                r += 1;
                i += 1;
            } else if (color(a, i) == Color.BLUE) {
                swap(a, i, b);
                b -= 1;
            } else {
                i += 1;
            }
        }

    }

    public static void main(String[] args) {
        Color[] colors1 = {Color.RED, Color.WHITE, Color.BLUE, Color.BLUE, Color.RED};
        sort(colors1);
        System.out.println(Arrays.toString(colors1));

        Color[] colors2 = {Color.BLUE, Color.BLUE, Color.WHITE, Color.WHITE, Color.RED};
        sort(colors2);
        System.out.println(Arrays.toString(colors2));
    }
}
