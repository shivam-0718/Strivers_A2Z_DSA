package step2;

/**
 * Given an array of integers nums, sort the array in non-decreasing order using the selection sort algorithm and return
 * the sorted array.
 * A sorted array in non-decreasing order is an array where each element is greater than or equal to all previous
 * elements in the array.
 */
public class Question1 {
    /**
     * Selection Sort logic: selecting the minimum from the array by finding minIndex and swap nums[minIndex] with nums[i]
     * This needs to be done throughout the array
     * @param nums
     * @return nums
     */
    public static int[] selectionSort(int[] nums) {
        int n = nums.length;
        // traversing from 0 till n-2 from outer array
        for (int i = 0; i <= n - 2; i++) {
            int minIndex = i; // assuming min element is at index i

            // traversing from i till n - 1
            for (int j = i; j <= n - 1; j++) {
                if(nums[j] < nums[minIndex]) { // assigning min index if nums[j] < nums[minIndex]
                    minIndex = j;
                }
            }

            // swap nums[i] with nums[minIndex]
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }
    // Time Complexity of Selection Sort: O(N^2) [Worst, Average, Best case scenario]
}
