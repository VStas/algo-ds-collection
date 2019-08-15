/*
Java autoboxing and equals(). Consider two double values a and b and their corresponding Double values x and y.

Find values such that (a==b) is true but x.equals(y) is false.
Find values such that (a==b) is false but x.equals(y) is true.
*/


public class DoubleEquals {
    public static void main(String[] args) {
        double a = 0.0;
        double b = -0.0;
        Double x = a;
        Double y = b;
        System.out.println(a == b);
        System.out.println(x.equals(y));

        double a1 = Double.NaN;
        double b1 = Double.NaN;
        Double x1 = a1;
        Double y1 = b1;
        System.out.println(a1 == b1);
        System.out.println(x1.equals(y1));
    }
}