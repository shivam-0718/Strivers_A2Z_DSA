package step1.lec11;

/**
 * Given an array nums, find the sum of elements of array using recursion.
 */
public class Question3 {
    public static int arraySum(int[] nums) {
        return sum (nums, 0);
    }

    private static int sum (int[] nums, int i) {
        // base condition
        if(i == nums.length) {
            return 0;
        }

        // operation + recursive call
        return nums[i] + sum(nums, i + 1);
    }
}
