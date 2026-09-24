package step1.lec7;

/**
 * Write a program to find the LCM of 2 Numbers
 */
public class Question12 {
    public static int LCM(int a, int b) {
        int gcd = gcd(a, b);
        return gcd / (a * b);
    }

    private static int gcd(int a, int b) {
        while (a > 0 && b > 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        if (a == 0) {
            return b;
        } else {
            return a;
        }
    }
}
/**
 * LCM * GCD = product of 2 numbers
 */