/** Given two strings, write a method to decide if one is a permutation of the other */

import java.util.Arrays;

public class Permutation {

    // I method
    private static String sortString(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
    private static boolean isPermutationUsingSort(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }

        return sortString(string1).equals(sortString(string2));
    }


    // II method
    // Assume that string only uses 256 chars (ASCII)
    private static boolean isPermutation(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        int[] occurences = new int[256];
        char[] charArray1 = string1.toCharArray();
        char[] charArray2 = string2.toCharArray();
        for (char c : charArray1) 
            occurences[c]++;

        // or using .getCharAt like in book
        for (char c : charArray2)
            if (--occurences[c] < 0) {
                return false;
            }
        return true;
    }

    public static void main(String[] args) {
        assert isPermutationUsingSort("abcd", "dbac") == true;
        assert isPermutationUsingSort("abcd", "dcac") == false;

        assert isPermutation("abcd", "dbac") == true;
        assert isPermutation("abcd", "dcac") == false;
    }
}