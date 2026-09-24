package step1.lec5;

/**
 * Write a program to count number of odd digits in a given number
 */
public class Question2 {
    public static int countOddDigit(int n) {
        int countOdd = 0;
        while (n != 0) {
            int lastDigit = n % 10;
            if(lastDigit % 2 != 0) {
                countOdd++;
            }
            n /= 10;
        }
        return countOdd;
    }
}
