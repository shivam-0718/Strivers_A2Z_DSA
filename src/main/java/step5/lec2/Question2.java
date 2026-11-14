package step5.lec2;

/**
 * Given a sorted array nums and an integer x. Find the floor and ceil of x in nums.
 * The floor of x is the largest element in the array which is smaller than or equal to x (nums[i] <= x).
 * The ceiling of x is the smallest element in the array greater than or equal to x (nums[i] >= x).
 * If no floor or ceil exists, output -1.
 *
 * Write using binary search only
 *
 * LeetCode: NA
 * Code 360: https://www.naukri.com/code360/problems/ceiling-in-a-sorted-array_1825401
 */
public class Question2 {
    public int[] getFloorAndCeil(int[] nums, int x) {
        return new int[]{findFloor(nums, x), findCeil(nums, x)};
    }

    private static int findCeil(int[] nums, int x) {
        int ceil = -1, low = 0, high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] >= x) {
                ceil = nums[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ceil;
    }

    private static int findFloor(int[] nums, int x) {
        int floor = -1, low = 0, high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] <= x) {
                floor = nums[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return floor;
    }
    // Time Complexity: O(log2 N)
    // Space Complexity: O(1)
}
