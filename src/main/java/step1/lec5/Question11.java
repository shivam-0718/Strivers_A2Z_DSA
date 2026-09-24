package step1.lec5;

/**
 * Write a program to find GCD / HCF between 2 numbers
 * Link: https://www.naukri.com/code360/problems/hcf-and-lcm_840448
 */

public class Question11 {
    // brute-force approach
    public static int gcd(int n1, int n2) {
        int gcd = 1;
        for(int i = n1; i <= n2; i++){
            if(n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    // the above method is only valid if n1 < n2, what about n1 > n2?
    // the above approach will fail at this edge case and give wrong solution
    // hence better approach

    // better approach
    public static int hcf(int n1, int n2) {
        int gcd = 1;
        for(int i = 1; i <= Math.min(n1, n2); i++){
            if(n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    // better approach is fine, but still we have to go till min of 2 numbers
    // and time complexity can be
    // then optimized approach will come

    // optimized approach
    public static int gcdOrHcf(int n1, int n2) {
        int gcd = 1;
        for (int i = Math.min(n1, n2); i > 0; i--) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
                break;
            }
        }
        return gcd;
    }

    // the optimized approach is also fine, but it can take time complexity as O(min(n1, n2))
    // in the worst case
    // So we can use Euclidean Approach
    /**
     * Euclidean Algorithm:
     * GCD (a, b) = GCD (a-b, b) if a > b;
     * If after performing the steps as per the above algorithm:
     * If a = 0, or b = 0 , then the other number will be GCD.
     * <p>
     *
     * Alternate, GCD(a, b) = GCD (a%b, b) if a > b
     */

    public static int gcdEuclidean(int a, int b) {
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

    /**
     * time complexity is {@code O(log_φ(min(a, b)))}
     */
}
