package step2;

/**
 * Given an array of integers nums, sort the array in non-decreasing order using the recursive Bubble Sort algorithm,
 * and return the sorted array.
 * - A sorted array in non-decreasing order is an array where each element is greater than or equal to the previous one.
 * - You must implement Bubble Sort using recursion only.
 * - Do not use built-in sorting functions (sort, sorted, Arrays.sort, etc.).
 */
public class Question6 {
    public static int[] bubbleSort(int[] nums) {
        return recursiveBubbleSort(nums, nums.length - 1);
    }

    private static int[] recursiveBubbleSort(int[] nums, int range) {
        // base condition: if range is less than 1, return the nums array
        if(range < 1) {
            return nums;
        }

        // for the given range traverse from 0 till range - 1
        // and swap as per the bubble sort logic
        for (int j = 0; j <= range - 1; j++) {
            if (nums[j] > nums[j + 1]) {
                int temp = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = temp;
            }
        }

        // return the array and reduce the range as max number moved to the end of array
        return recursiveBubbleSort(nums, range - 1);
    }
}
