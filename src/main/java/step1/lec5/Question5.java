package step1.lec5;

/**
 * Write a program to return the largest digit of a given number
 */
public class Question5 {
    public static int largestDigit(int n) {
        int largestDigit = 0;
        while(n != 0) {
            if ((n % 10) > largestDigit) {
                largestDigit = n % 10;
            }
            n /= 10;
        }
        return largestDigit;
    }

}
