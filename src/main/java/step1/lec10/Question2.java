package step1.lec10;

/**
 * Write a program to check whether a given string is palindrome or not
 * Link: https://leetcode.com/problems/valid-palindrome/description/
 */
public class Question2 {
    // brute-force approach
    public static boolean palindromeCheck(String s) {
        // converting string to character array
        char[] temp = s.toCharArray();
        int n = s.length();

        // iterating through array
        for (int i = 0; i < temp.length; i++) {
            if(temp[i] != temp[n - 1 - i]) {
                return false;
            }
        }

        return true;
    }
    // time complexity of above approach: O(n) -> iterating through character and comparing with n - 1 - i character
    // space complexity of above approach: O(n) -> using extra array to store characters

    // optimal approach
    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // time complexity of optimal approach: O(N)
    // space complexity of optimal approach: O(1)

}
