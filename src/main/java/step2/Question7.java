package step2;
/**
 * Given an array of integers nums, sort the array in non-decreasing order using the recursive Insertion Sort algorithm,
 * and return the sorted array.
 * - A sorted array in non-decreasing order is an array where each element is greater than or equal to the previous one.
 * - You must implement Insertion Sort using recursion only.
 * - Do not use built-in sorting functions (sort, sorted, Arrays.sort, etc.).
 */
public class Question7 {
    public static int[] insertionSort(int[] nums) {
        return recursiveInsertionSort(nums, 1);
    }

    private static int[] recursiveInsertionSort(int[] nums, int range) {
        if (range > nums.length - 1) {
            return nums;
        }
        int j = range;
        while (j > 0 && nums[j - 1] >= nums[j]) {
            int temp = nums[j - 1];
            nums[j - 1] = nums[j];
            nums[j] = temp;
            j--;
        }

        return recursiveInsertionSort(nums, range + 1);
    }
}
