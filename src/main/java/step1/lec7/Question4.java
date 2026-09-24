package step1.lec7;

/**
 * Write a program to check whether a given number is palindrome or not.
 *
 * Note: A number is said to be palindrome if the given number and the number
 * formed after reversing the digits is the same number
 *
 * Link: https://www.naukri.com/code360/problems/palindrome-number_624662
 * Link2: https://leetcode.com/problems/palindrome-number/description/
 */
public class Question4 {
    // coding ninjas question
    public static boolean palindrome(int n) {
        int num = n;
        int revNumber = 0;
        while(n != 0) {
            int lastDigit = n % 10;
            revNumber = revNumber * 10 + lastDigit;
            n /= 10;
        }

        return num == revNumber;
    }

    // leetcode question
    public static boolean isPalindrome(int n) {
        int num = n;
        long revNumber = 0;

        while(n > 0) {
            revNumber = revNumber * 10 + (n % 10);
            n /= 10;
        }

        return num == revNumber;
    }
}
