package step5.lec2;

/**
 * Given a sorted array of nums consisting of distinct integers and a target value, return the index if the target
 * is found. If not, return the index where it would be if it were inserted in order.
 *
 * LeetCode: https://leetcode.com/problems/search-insert-position/
 * Code360: https://www.naukri.com/code360/problems/algorithm-to-find-best-insert-position-in-sorted-array_839813
 */
public class Question1 {
    // brute-force solution
    public int searchInsertPosition(int[] nums, int target) {
        int index = nums.length;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= target) {
                index = i;
                break;
            }
        }
        return index;
    }
    // Time Complexity: O(N)
    // Space Complexity: O(1)

    // optimal solution - binary search
    public static int searchInsert(int[] nums, int target) {
        int index = nums.length, low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] >= target) {
                index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }
    // Time Complexity: O(log2 N)
    // Space Complexity: O(1)
}
