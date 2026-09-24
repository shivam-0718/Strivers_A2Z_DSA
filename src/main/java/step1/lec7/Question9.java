package step1.lec7;

/**
 * Write a program to check whether a given number is prime number or not
 * Link: https://www.naukri.com/code360/problems/check-prime_624674
 */
public class Question9 {
    // A number is said to be prime <=> it has 2 factors: 1 and number itself

    // brute-force approach
    public static boolean isPrime(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        return count == 2;
    }

    // time complexity is O(n), which is inefficient for higher number
    // just like for finding the number of factors
    // we are applying the loop until sqrt (Number)

    // optimized approach
    public static boolean isPrimeNumber(int number) {
        int count = 0;
        for (int i = 1; i <= (int)Math.sqrt(number); i++) {
            if (number % i == 0) {
                count++;
                if ((number / i) != i) {
                    count++;
                }
            }
        }
        return count == 2;
    }

}
