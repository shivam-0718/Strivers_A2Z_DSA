package step3.lec1;

/**
 * Given a binary array nums, return the maximum number of consecutive 1s in the array.
 * A binary array is an array that contains only 0s and 1s.
 */
public class Question4 {
    // Optimal solution
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max1s = 0, count = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                count++;
                max1s = Math.max(max1s, count);
            } else {
                count = 0;
            }
        }

        return max1s;
    }
    // Time Complexity: O(N)
    // Space Complexity: O(1)
}
