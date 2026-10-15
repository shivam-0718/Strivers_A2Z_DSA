package step3.lec1;

import java.util.Arrays;

/**
 * Given an array of integers nums, return the value of the largest element in the array
 */
public class Question2 {
    // Brute-force solution
    public static int largestElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1];
    }
    // Time Complexity: O(N log N) (sorting)
    // Space Complexity: O(1)

    // Optimal solution
    public static int largestElementArray(int[] nums) {
        int largestElement = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > largestElement) {
                largestElement = nums[i];
            }
        }

        return largestElement;
    }
    // Time Complexity: O(N)
    // Space Complexity: O(1)

}
