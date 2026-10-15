package step3.lec1;

/**
 * Given an array of integers nums and an integer target, find the smallest index (0 based indexing) where the target
 * appears in the array. If the target is not found in the array, return -1
 */
public class Question1 {
    // Brute-force solution
    public int linearSearch(int[] nums, int target) {
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                ans = i;
                break;
            }
        }
        return ans;
    }
    // Time Complexity: O(N)
    // Space Complexity: O(1)
}
