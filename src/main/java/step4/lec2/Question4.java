package step4.lec2;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 * LeetCode: https://leetcode.com/problems/subarray-sum-equals-k/description/
 * Code360: https://www.naukri.com/code360/problems/subarray-sums-i_1467103
 *
 */
public class Question4 {
    // brute-force solution
    public static int countSubarraysWithGivenSum(int[] nums, int k) {
        int count = 0, n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int sum = 0;
                for(int l = i; l <= j; l++) {
                    sum += nums[k];
                    if(sum == k) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    // Time Complexity: O(N^3)
    // Space Complexity: O(1)

    // better solution
    public static int countSubarraysSum(int[] nums, int k) {
        int count = 0, n = nums.length;
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += nums[k];
                if(sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)

    // optimal solution - hashing (Way 1)
    public static int countSubarraySum(int[] nums, int k) {
        int n = nums.length, subArrayCount = 0, currentPrefixSum = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1); // setting value for 0 sum in the map

        for(int i = 0; i < n; i++) {
            currentPrefixSum += nums[i]; // finding prefix sum till i
            int sumToRemove = currentPrefixSum - k; // finding remaining sum as per formula: remSum = prefixSum - k
            if(prefixSumMap.containsKey(sumToRemove)) {
                subArrayCount += prefixSumMap.get(sumToRemove); // adding occurrence of sumToremove into subarray count if sumToRemove present
            }
            if(prefixSumMap.containsKey(currentPrefixSum)) {
                int count = prefixSumMap.get(currentPrefixSum); // updating count of currentPrefixSum into map, if present
                prefixSumMap.put(currentPrefixSum, (count + 1));
            } else {
                prefixSumMap.put(currentPrefixSum, 1); // adding prefix sum with count 1 into map, if not present
            }
        }
        return subArrayCount;
    }

    // optimal solution - hashing (Way 2)
    public static int countSubarraysWithSum(int[] nums, int k) {
        int n = nums.length, subArrayCount = 0, currentPrefixSum = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1); // setting value for 0 sum in the map

        for(int i = 0; i < n; i++) {
            currentPrefixSum += nums[i]; // finding prefix sum till i
            int sumToRemove = currentPrefixSum - k; // finding remaining sum as per formula: remSum = prefixSum - k
            subArrayCount += prefixSumMap.getOrDefault(sumToRemove, 0); // adding occurrence of sumToremove into subarray count -> 0 by default if there is no key
            prefixSumMap.put(currentPrefixSum, prefixSumMap.getOrDefault(currentPrefixSum, 0) + 1); // updating current prefix sum count if present
        }
        return subArrayCount;
    }
    // Time Complexity: O(N) OR O(NlogN) (depending on the set data structure)
    // Space Complexity: O(N)
}
