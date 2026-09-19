package step1.lec4;

/**
 * Write a program to count the digits of a given number
 * Link: https://www.naukri.com/code360/problems/number-of-digits_9173
 */
public class Question1 {
    // brute force approach
    public static int countDigits(int n) {
        int count = 0;
        while(n > 0) {
            count++;
            n = n/10;
        }
        return count;
    }

    // optimal approach
    public static int countTheDigits(int n){
        return (int)(Math.log10(n) + 1);
    }

}
