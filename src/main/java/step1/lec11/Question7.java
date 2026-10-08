package step1.lec11;

/**
 * Given an array nums of n integers, return reverse of the array. Use recursion
 */
public class Question7 {
    public static int[] reverseArray(int[] nums) {
        return reverse(nums, 0, nums.length - 1);
    }

    private static int[] reverse(int[] nums, int i, int j) {
        if (i >= j) {
            return nums;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = nums[i];

        return reverse(nums, i + 1, j - 1);
    }
}
