package step1.lec5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Write a program to find whether a given number is a perfect number or not
 * Note: A number is said to be a perfect number <=> whose proper divisors (excluding the number itself) add up to the number itself.
 */
public class Question8 {
    // brute-force
    public static boolean isPerfect(int n) {
        ArrayList<Integer> divisors = new ArrayList<Integer>();
        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisors.add(i);
                if ((n / i) != i) {
                    divisors.add(n / i);
                }
            }
        }
        Collections.sort(divisors);
        divisors.removeLast();

        int sum = 0;
        for(int i = 0; i < divisors.size(); i++) {
            sum += divisors.get(i);
        }

        return sum == n;
    }

    // optimal
    public boolean isPerfectNumber(int n) {
        ArrayList<Integer> divisors = listOfDivisors(n);

//        Collections.sort(divisors);
//        divisors.removeLast();

        int sum = 0;
        for(int i = 0; i < divisors.size(); i++) {
            if (divisors.get(i) == n) {
                divisors.remove(i);
            } else {
                sum += divisors.get(i);
            }
        }

        return sum == n;
    }

    private ArrayList<Integer> listOfDivisors(int n) {
        ArrayList<Integer> divisors = new ArrayList<Integer>();
        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisors.add(i);
                if ((n / i) != i) {
                    divisors.add(n / i);
                }
            }
        }
        return divisors;
    }


}
