/** Determine if a string has all unique characters */


// lets assume that string is ascii - 256 symbols

public class UniqueCharacters {

    private static boolean isUniqueChars(String str) {
        if (str.length() > 256) {
            return false;
        }

        boolean[] occurences = new boolean[256];

        for (int i = 0; i < str.length(); i++) {
            char character = str.charAt(i);
            if (occurences[character]) {
                return false;
            }
            occurences[character] = true;
        }

        return true;
    }

    public static void main(String[] args) {

        assert isUniqueChars("fyu") == true;
        assert isUniqueChars("fyufa") == false;
    }
}