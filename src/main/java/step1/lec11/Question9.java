package step1.lec11;

/**
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 * Use recursion for this question
 */
public class Question9 {
    public static int addDigits(int n) {
        return sumOfDigits(n, 0);
    }

    private static int sumOfDigits(int n, int sum) {
        if (n == 0) {
            if (sum < 9) {
                return sum;
            } else if (sum >= 10) {
                return sumOfDigits(sum, 0);
            } // as 2-digit number is becoming equal to 10,
            //so in place of num, replace it with sum and make other parameter as 0
        }

        sum += n % 10;
        n /= 10;
        return sumOfDigits(n, sum);
    }
}
