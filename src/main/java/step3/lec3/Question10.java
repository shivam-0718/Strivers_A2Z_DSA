package step3.lec3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target. Return the indices(0 - indexed) of two elements in nums such
 * that they add up to target.
 * Each input will have exactly one solution, and the same element cannot be used twice. Return the answer in any order.
 */
public class Question10 {
    // brute-force solution
    public static int[] twoSumBrute(int[] nums, int target) {
        int[] ans = new int[2];
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }
        return ans;
    }
    // Time Complexity: ~O(N^2)
    // Space Complexity: O(1)

    // better solution - hashing (optimal if the question asks for indexes to be returned)
    public static int[] twoSumBetterOptimal(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for(int i = 0; i < nums.length; i++) {
            int need = target - nums[i]; // we know sum of 2 numbers makes target, so we need to find other number that when added with arr[i] makes target
            if(map.containsKey(need)) {
                ans[0] = i;
                ans[1] = map.get(need);
                break;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
    // Time Complexity: O(N)
    // Space Complexity: O(N)(for set)

    // optimal solution - 2 pointer approach(only valid if the return type is boolean)
    public static boolean twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        boolean ans = false;
        int i = 0, j = nums.length - 1;
        while(i < j) {
            int sum = nums[i] + nums[j];

            if(sum < 0) {
                i++;
            } else if(sum > 0) {
                j--;
            } else {
                ans = true;
                break;
            }
        }
        return ans;
    }
    // Time Complexity: O(N) + O(N*logN)
    // Space Complexity: O(1)
}
