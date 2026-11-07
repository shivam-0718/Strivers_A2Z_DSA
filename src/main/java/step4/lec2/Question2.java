package step4.lec2;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums of size n and an integer k, find the length of the longest sub-array that sums to k.
 * If no such sub-array exists, return 0.
 *
 * Leetcode: https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/description/
 * Code 360: https://www.naukri.com/code360/problems/longest-subarray-with-sum-k_5713505
 */
public class Question2 {
    // brute-force solution
    public static int longestSubarrayInAnArray(int[] nums, int val) {
        int n = nums.length;
        int maxLen = 0;
        // creating subarrays
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int sum = 0;
                for(int k = i; k <= j; k++) { // add all the elements of subarray
                    sum += nums[k];
                    if(sum == val) {
                       maxLen = Math.max(maxLen, j - i + 1);
                    }
                }
            }
        }
        return maxLen;
    }
    // Time Complexity: O(N^3)
    // Space Complexity: O(1)


    // slight better version of brute-force
    public static int longestSubarrayInArray(int[] nums, int val) {
        int n = nums.length;
        int maxLen = 0;
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += nums[j];
                if(sum == val) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)

    // optimal solution - applicable when array has both positives and negatives AND only positives with zeroes.
    public static int longestSubarray(int[] nums, int k) {
        int n = nums.length, maxLen = 0;
        Map<Long, Integer> prefixSumMap = new HashMap<>();
        long sum = 0L;

        for(int i = 0; i < n; i++) {
            sum += nums[i]; // calculate the prefix sum till index i
            if((int)sum == k) {
                maxLen = Math.max(maxLen, i + 1); // if the sum equals k, update maxLen
            }

            long remSum = sum - k; // calculate the sum of remaining part i.e., sum - k
            if(prefixSumMap.containsKey(remSum)) { // if remSum exists in map, find the length of remaining portion and update maxLen
                int len = i - prefixSumMap.get(remSum);
                maxLen = Math.max(len, maxLen);
            }

            // update the map if sum is not already present
            if(!prefixSumMap.containsKey(sum)) {
                prefixSumMap.put(sum, i);
            }
        }

        return maxLen;
    }
    // Time Complexity: O(N)
    // Space Complexity: O(N) (using hashMap)

    // optimal solution - applicable only when array has only positive elements and zeroes.
    public static int longestSubarrayInGivenArray(int[] nums, int k) {
        int left = 0, right = 0; // Pointers to mark the start and end of window
        int n = nums.length, sum = nums[0], maxLen = 0;

        // Traverse all the elements
        while(right < n) {
            // Store the maximum length
            if(sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;

            // If the sum exceeds K, shrink the window
            while(left <= right && sum > k) {
                sum -= nums[left];
                left++;
            }

            if(right < n) {
                sum += nums[right];
            }
        }

        return maxLen;
    }
    // Time Complexity: O(N)
    // Space Complexity: O(1)
}
