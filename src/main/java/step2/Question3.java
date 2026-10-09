package step2;

/**
 * Given an array of integers called nums, sort the array in non-decreasing order using the insertion sort algorithm and
 * return the sorted array.
 *
 * A sorted array in non-decreasing order is an array where each element is greater than or equal to all preceding
 * elements in the array.
 */
public class Question3 {
    /**
     * Insertion Sort logic: Takes an element and places it in correct order.
     * This needs to be done throughout the array
     * @param nums
     * @return nums
     */
    public static int[] insertionSort(int[] nums) {
        int n = nums.length;
        // i = 1, because we are comparing nums[i] with nums[i - 1] to do the
        // swap <=> nums[i - 1] > nums[j]
        for (int i = 1; i < n; i++) {
            boolean didSwap = false;
            int j = i;
            while(j > 0 && nums[j - 1] > nums[j]) {
                int temp = nums[j - 1];
                nums[j - 1] = nums[j];
                nums[j] = temp;
                j--;
                didSwap = true;
            }

            // if there is no swap of elements, then it will break out of loop
            if(didSwap == false) {
                break;
            }
        }
        return nums;
    }
    // Time Complexity of Insertion Sort: O(N^2) [Worst, Average case scenario]
    // For best case scenario, time complexity of Insertion Sort: O(N) [if array is already sorted]
}
