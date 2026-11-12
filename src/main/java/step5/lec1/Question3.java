package step5.lec1;

/**
 * Given a sorted array of nums and an integer x, write a program to find the upper bound of x.
 * The upper bound of x is defined as the smallest index i such that nums[i] > x.
 *
 * If no such index is found, return the size of the array.
 *
 * LeetCode: NA
 * Code360: https://www.naukri.com/code360/problems/implement-upper-bound_8165383
 */
public class Question3 {
    // brute-force solution - linear search
    public static int findUUpperBound(int[] nums, int x) {
        int index = nums.length;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > x) {
                index = i;
                break;
            }
        }
        return index;
    }
    // Time Complexity: O(N)
    // Space Complexity: O(1)

    // optimal solution - binary search
    public static int upperBound(int[] nums, int x) {
        int index = nums.length, low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] > x) {
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
