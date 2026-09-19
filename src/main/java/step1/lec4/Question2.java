package step1.lec4;

/**
 * Write a program to reverse the digits of a given number
 * Link: https://www.naukri.com/code360/problems/reverse-of-a-number_893271
 * Link2: https://leetcode.com/problems/reverse-integer/
 */
public class Question2 {
    // coding ninjas problem
    public static long reverseNumber(long n) {
        long revNumber = 0L;
        while(n > 0) {
            long lastDigit = n % 10L;
            revNumber = revNumber*10 + lastDigit;
            n /= 10;
        }
        return revNumber;
    }

    // leetcode problem
    public static int reverse(int x) {
        long rev = 0; //there is a chance that reversing a number can exceed the int range
        // so storing in long variable

        while(x != 0) {
            rev = rev * 10 + x % 10;
            if(rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE) {
                return 0; // after reversing, number can cross int boundary
            }
            x /= 10;
        }
        return (int) rev;
    }

}
