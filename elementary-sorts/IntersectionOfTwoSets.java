// Intersection of two sets. Given two arrays a[] and b[], each containing nn distinct 2D points in the plane,
// design a subquadratic algorithm to count the number of points that are contained both in array a[] and array b[].


class Point implements Comparable<Point> {

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int x;
    int y;

    public int compareTo(Point p) {
        if (this.x != p.x) {
            return this.x - p.x;
        }
        return this.y - p.y;
    }
}

public class IntersectionOfTwoSets {
    public static void insertionSort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j].compareTo(a[j - 1]) < 0) { // a[j] < a[j - 1]
                    exch(a, j, j-1);
                }
            }
        }
    }

    private static void exch(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int countNumber(Point[] a, Point[] b) {
        int count = 0;
        insertionSort(a);
        insertionSort(b);
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i].compareTo(b[j]) == 0) {
                i += 1;
                j += 1;
                count += 1;
            } else if (a[i].compareTo(b[j]) < 0) {
                i += 1;
            } else {
                j += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Point p1 = new Point(2, 1);
        Point p3 = new Point(3, 8);
        Point p5 = new Point(1, 0);
        Point p2 = new Point(1, 5);
        Point p4 = new Point(3, 4);

        Point p6 = new Point(3, 4);
        Point p7 = new Point(1, 4);
        Point p8 = new Point(1, 5);
        Point p9 = new Point(3, 8);
        Point p10 = new Point(2, 1);

        Point[] a = {p1, p2, p3, p4, p5};
        Point[] b = {p6, p7, p8, p9, p10};

        System.out.println(countNumber(a, b));
    }
}