package step1.lec11;

/**
 * Given an integer N, return the sum of first N natural numbers. Try to solve this using recursion.
 */
public class Question1 {
    public static int NnumbersSum(int N) {
        int sum = 0;
        // base condition to stop infinite recursion call
        if(N == 0) {
            return 0;
        }
        // operation
        sum += N;

        // return statement
        return sum + NnumbersSum(N - 1);
    }
}
