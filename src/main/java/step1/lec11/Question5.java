package step1.lec11;

/**
 * Given a string s, return true if the string is palindrome, otherwise false. Use recursion for solving the same
 */
public class Question5 {
    // brute-force solution without recursion
    public static boolean isPalindrome(String s) {
       char[] temp = s.toCharArray();
       int n = s.length();

       for (int i = 0; i < temp.length; i++) {
           if(temp[i] != temp[n - 1 - i]) {
               return false;
           }
       }

       return true;
    }

    // optimal solution without recursion
    public static boolean isStringPalindrome(String s) {
        // 2 pointer approach
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    // optimal solution using recursion
    public static boolean palindromeCheck(String s) {
        // 2 pointer approach
        int i = 0, j = s.length() - 1;
        return charCheck(s, i, j);
    }

    private static boolean charCheck(String s, int i, int j) {
        if (i >= j) {
            return true;
        }
        if(s.charAt(i) != s.charAt(j)) {
            return false;
        }
        return charCheck(s, i + 1, j - 1);
    }
}
