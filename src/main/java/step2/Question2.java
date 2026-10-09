package step2;

/**
 * Given an array of integers called nums,sort the array in non-decreasing order using the bubble sort algorithm and
 * return the sorted array.
 * A sorted array in non-decreasing order is an array where each element is greater than or equal to all preceding
 * elements in the array.
 */
public class Question2 {
    /**
     * Bubble Sort logic: Pushing the maximum element from the array to the last by performing adjacent swaps.
     * This needs to be done throughout the array
     * @param nums
     * @return nums
     */
    public static int[] bubbleSort(int[] nums) {
        int n = nums.length;
        // traversing from n - 1 till 1 from outer array
        for (int i = n - 1; i >= 1; i--) {
            // traversing from 0 till i - 1 in inner array
            for (int j = 0; j <= i - 1; j++) {
                if(nums[j] >= nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }
}
