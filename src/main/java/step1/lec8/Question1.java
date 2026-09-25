package step1.lec8;

/**
 * Write a program to find the sum of elements in an array
 */
public class Question1 {
    public static int sum(int arr[], int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
