package step1.lec7;

/**
 * Write a program to find whether a given number is Armstrong number or not
 * Note: A number is said to be an Armstrong number <=> sum of the cubes of each
 * digit is equal to the same number
 *
 * Link: https://www.naukri.com/code360/problems/check-armstrong_589
 */
public class Question7 {
    public static boolean isArmstrong (int num) {
        int n = num;
        int sum = 0;
        while (num > 0) {
            int lastDigit = num % 10;
            sum += (int)(Math.pow(lastDigit, 3));
            num = num / 10;
        }
        return n == sum;
    }
}
