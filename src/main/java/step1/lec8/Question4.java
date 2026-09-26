package step1.lec8;

import java.util.Arrays;
import java.util.Collections;

/**
 * Write a problem to reverse an array
 */
public class Question4 {
    // brute-force approach - without pre-defined methods
    public static void reverse(int[] arr, int n) {
        int[] revArr = new int[n]; // new array for reversal

        for (int i = 0; i < n; i++) {
            revArr[n - 1 - i] = arr[i];
        }

        // revArr is temporarily used to swap back the values
        for (int i = 0; i < n; i++) {
            arr[i] = revArr[i];
        }
    }
    // Time complexity of brute-force approach: O(n) (n times for reversing and again n times for reallocation)
    // Space complexity of brute-force approach: O(n) (using extra space for revArray)

    // optimal approach - 2 pointer method
    public static void revArr(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    // Time complexity of brute-force approach: O(n) (n/2 times for reversing via 2 pointer approach)
    // Space complexity of brute-force approach: O(1)
}
