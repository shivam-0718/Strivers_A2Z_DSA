package step5.lec1;

/**
 * Given a sorted array of integers nums with 0-based indexing, find the index of a specified target integer.
 * Use Binary Search for this question
 * If the target is found in the array, return its index. If the target is not found, return -1.
 *
 * LeetCode: https://leetcode.com/problems/binary-search/description/
 * Code360: https://www.naukri.com/code360/problems/binary-search_972
 */
public class Question1 {
    // brute-force solution - linear search
    public static int searchNumber(int[] nums, int target) {
        int n = nums.length, index = -1;
        for(int i = 0; i < n; i++) {
            if(nums[i] == target) {
                index = i;
                break;
            }
        }
        return index;
    }
    // Time Complexity: O(N)
    // Space Complexity: O(1)

    // optimal solution - binary search - iterative method
    public static int binarySearchIterative(int[] nums, int target) {
        int n = nums.length, index = -1;
        int low = 0, high = n - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] < target) {
                low = mid + 1;
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                index = mid;
                break;
            }
        }
        return index;
    }

    // optimal solution - binary search - recursive method
    public static int binarySearchRecursive(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private static int binarySearch(int[] nums, int target, int low, int high) {
        if(low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if(nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, high);
        } else if(nums[mid] > target) {
            return binarySearch(nums, target, low, mid - 1);
        } else {
            return mid;
        }
    }
    // Time Complexity: O(log2 N)
    // Space Complexity: O(1)
}
