package step1.lec11;

/**
 * Given an integer n, return the factorial of n using recursion.
 * Factorial of a non-negative integer, is the multiplication of all integers smaller than or equal to n (use 64-bits to return answer).
 */
public class Question2 {
    public static long factorial(int n) {
        int fact = 1;
        if(n <= 1) {
            return fact;
        }
        fact = fact * n;
        return fact * factorial(n - 1);
    }
}
