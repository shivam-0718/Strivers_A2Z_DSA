package step1.lec8;

/**
 * Write a program to count the number of odd elements in an array
 */
public class Question2 {
    public static int countOdd(int[] arr, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(isOdd(arr[i])) {
                count++;
            }
        }
        return count;
    }

    private static boolean isOdd(int num) {
        return num % 2 != 0;
    }
}
