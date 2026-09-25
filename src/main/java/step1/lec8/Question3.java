package step1.lec8;

/**
 * Write a program to check whether a given array is in non-decreasing order or non-increasing order
 */
public class Question3 {
    public static boolean arraySortedOrNot(int[] arr, int n) {
        return isAscending(arr) || isDescending(arr);
    }

    private static boolean isAscending(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] <= arr[i + 1]) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean isDescending(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] >= arr[i + 1]) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
