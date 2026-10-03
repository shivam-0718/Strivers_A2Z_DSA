package step1.lec10;

/**
 * Given a string s, representing a large integer, write a program to return the largest-valued odd integer (as a string)
 * that is a substring of the given string s.
 * The number returned should not have leading zero's. But the given input string may have leading zero.
 * (If no odd number is found, then return empty string.)
 *
 * Link: https://leetcode.com/problems/largest-odd-number-in-string/description/
 */
public class Question3 {
    // very good question
    public static String largestOddNumber(String s) {
        int n = s.length();
        String largest = "";
        int j = -1;

        // first we have to find the index from the right
        // where the odd digit is there
        for (int i = n - 1; i >= 0; i--) {
            if (Integer.valueOf(s.charAt(i)) % 2 == 1) {
                j = i;
                break;
            }
        }

        if (j == -1) {
            return largest;
        }

        // after getting the index of the odd digit from back
        // traversal, we will go from start (i) till j

        int i = 0;
        while (i < n) {
            // I got my first non-zero number
            if(s.charAt(i) != '0') {
                break;
            }
            i++;
        }

        // then from i till j after retrieval
        // return the substring
        return s.substring(i, j + 1);
    }

    // time complexity: O(N)
    // space complexity: O(1)

}
