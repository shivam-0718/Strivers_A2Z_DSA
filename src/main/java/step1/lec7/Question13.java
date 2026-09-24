package step1.lec7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Write a program to find number of divisors of a given number.
 * Link: https://www.naukri.com/code360/problems/print-all-divisors-of-a-number_1164188
 */
public class Question13 {
    // brute-force approach
    public static int countFactors (int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count;
    }

    // time complexity is O(n). for small numbers it is fine
    // what about the big numbers? then it is not a good time complexity/
    /**
     * Optimised from O(n) to O(√n).
     *
     * Divisors come in pairs: 1 × n, 2 × (n/2), ... i × (n/i).
     * Each pair has one factor ≤ √n, so scanning past √n only
     * re-finds partners already seen. The pair meets at i × i = n.
     */

    public static int countTheFactors (int n) {
        int count = 0;
        for (int i = 1; i <= (int)(Math.sqrt(n)); i++) {
            if (n % i == 0) {
                count++;
                // i is a divisor, so n/i is its partner.
                // Count both — unless they're the same number (perfect square)
                if ((n / i) != i) {
                    count++;
                }
            }
        }
        return count;
    }

    // Find the list of divisors
    public static void findTheFactors (int n) {
        List<Integer> listOfFactors = new ArrayList<>();
        for (int i = 1; i <= (int)(Math.sqrt(n)); i++) {
            if (n % i == 0) {
                listOfFactors.add(i);
                // i is a divisor, so n/i is its partner.
                // Count both — unless they're the same number (perfect square)
                if ((n / i) != i) {
                    listOfFactors.add(n / i);
                }
            }
        }
        Collections.sort(listOfFactors);
        System.out.println(listOfFactors);
    }
}
