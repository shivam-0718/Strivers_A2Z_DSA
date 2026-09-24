package step1.lec7;

/**
 * Write a program to find the number of prime numbers till N
 */
public class Question10 {
    public static int countPrimeNosTillN(int n) {
        int count = 0;
        for(int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPrime(int number) {
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
