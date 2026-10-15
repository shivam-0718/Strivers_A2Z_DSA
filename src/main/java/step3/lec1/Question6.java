package step3.lec1;

/**
 * Given an integer array nums and a non-negative integer k, rotate the array to the left by k steps.
 */
public class Question6 {
    // Brute-force solution
    public static void rotateLeftArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        // pick k elements from left, store in temp array
        int[] temp = new int[k];
        for(int i = 0; i < k; i++) {
            temp[i] = nums[i];
        }

        // rotate n - k elements to the left
        for(int i = k; i < n; i++) {
            nums[i - k] = nums[i];
        }

        // place k elements to n - k places
        for(int i = 0; i < k; i++) {
            nums[n - k + i] = temp[i];
        }
    }
    // Time Complexity: O(k)(traversing till k to place k elements in temp array) + O(n - k)(moving n - k elements to left) + O(k)(placing k elements to n - k places) -> O(n + k)
    // Space Complexity: O(k)(temp array to place k elements into temp array)

    // Optimal Solution
    public static void rotateArrayLeft(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, n - 1);
        reverseArray(nums, 0, n - 1);
    }

    private static void reverseArray(int[] arr, int i, int j) {
        while(i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    // Time Complexity: O(k)(traversing till k to reverse k elements) + O(n - k)(reversing n - k elements) + O(n)(reversing whole array) -> O(2n)
    // Space Complexity: O(1)

}
