package step1.lec11;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is
 * the sum of the two preceding ones, starting from 0 and 1. That is,
 *
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 *
 * Use recursion as well
 */
public class Question10 {
    // solution without recursion
    public static int fibonacciNumber(int n) {
        int last = 0, secondLast = 1, sum = 0; // last = F(n-2) (older value), sLast = F(n-1) (newer value)
        if(n <= 1) {
            return n;
        }

        while (n > 1) {
            sum = secondLast + last;  // finding usm as per formula given: F(n) = F(n - 1) + F(n - 2)
            last = secondLast;  // second last value shifted to last: the newer value becomes older one
            secondLast = sum;  // sum shifted to secondlast: the newer sum becomes sLast
            n--;
        }

        return sum;
    }

    // solution with recursion
    public static int fibonacci(int n) {
        return fib(n);
    }

    private static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
