package step4.lec2;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given an integer array arr of size n which contains both positive and negative integers.
 * Your task is to find the length of the longest contiguous subarray with sum equal to 0.
 *
 * Return the length of such a subarray. If no such subarray exists, return 0.
 *
 * Leetcode: https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
 * Code 360: https://www.naukri.com/code360/problem-details/longest-subarray-with-zero-sum_6783450
 *
 * NOTE: It is the same as previous question, so we referred the same answer. The only thing which we have
 * done is assigned the given val / k to 0
 */
public class Question3 {
    // brute-force solution
    public static int longestSubarrayInAnArray(int[] nums, int val) {
        val = 0;
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
        val = 0;
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
        k = 0;
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
        k = 0;
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
