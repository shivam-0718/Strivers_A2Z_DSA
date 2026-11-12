package step5.lec1;

/**
 * Given a sorted array of nums and an integer x, write a program to find the lower bound of x.
 * The lower bound algorithm finds the first and smallest index in a sorted array where the
 * value at that index is greater than or equal to a given key i.e. x.
 *
 * If no such index is found, return the size of the array.
 *
 * LeetCode: https://leetcode.com/problems/search-insert-position/
 * Code360: https://www.naukri.com/code360/problems/lower-bound_8165382
 */
public class Question2 {
    // brute-force solution - linear search
    public static int findLowerBound(int[] nums, int x) {
       int index = nums.length;
       for(int i = 0; i < nums.length; i++) {
           if(nums[i] >= x) {
               index = i;
               break;
           }
       }
       return index;
    }
    // Time Complexity: O(N)
    // Space Complexity: O(1)

    // optimal solution - binary search
    public static int lowerBound(int[] nums, int x) {
        int index = nums.length, low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] >= x) {
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
