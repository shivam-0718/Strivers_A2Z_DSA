package step1.lec11;

/**
 * Given an integer num, return true if it is prime otherwise false. Use recursion for the same
 */
public class Question6 {
    public static boolean checkPrime(int n) {
        if (n <= 1) {
            return false;
        }
        return isPrime(n, 2);
    }

    private static boolean isPrime (int n, int i) {
        // base case: if num is greater than sqrt (x), then it is isPrime
        // as there are no other divisors for it
        if (n > (int)Math.sqrt(n)) {
            return true;
        }

        if (n % i == 0) {
            return false;
        }

        return isPrime(n, i + 1);
    }
}
