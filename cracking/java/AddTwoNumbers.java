/**
    Implement a function that adds 2 numbers without + and other arithmetic operators
 */

public class AddTwoNumbers {

    private static int add(int a, int b) {
        if (b == 0) return a;
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return add(sum, carry);
    }
    public static void main(String[] args) {
        assert add(5, 4) == 9;
    }
}