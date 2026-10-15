package step3.lec1;

/**
 * Given an integer array nums, rotate the array to the left by one.
 */
public class Question5 {
    public static void rotateArrayByOne(int[] nums) {
        int temp = nums[0];

        for(int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }

        nums[nums.length - 1] = temp;
    }
    // Time Complexity: O(N - 1)(as traversing through N - 1 elements and shifting them to left)
    // Space Complexity: O(1)
}
