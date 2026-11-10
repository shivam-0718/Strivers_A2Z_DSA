package step4.lec2;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer k, return the total number of subarrays whose XOR equals to k.
 *
 * LeetCode: NA
 * Code360: https://www.naukri.com/code360/problems/subarrays-with-xor-k_6826258
 */
public class Question5 {
    // brute-force solution
    public static int countSubarraysWithGivenXor(int[] nums, int k) {
        int count = 0, n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int xorSum = 0;
                for(int l = i; l <= j; l++) {
                    xorSum ^= nums[l];
                }
                if(xorSum == k) {
                    count++;
                }
            }
        }
        return count;
    }
    // Time Complexity: O(N^3)
    // Space Complexity: O(1)

    // better solution
    public static int countSubarraysXor(int[] nums, int k) {
        int count = 0, n = nums.length;
        for(int i = 0; i < n; i++) {
            int xorSum = 0;
            for(int j = i; j < n; j++) {
                xorSum ^= nums[j];
                if(xorSum == k) {
                    count++;
                }
            }
        }
        return count;
    }
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)

    // optimal solution - hashing (Way 1)
    public int countSubarraysWithXorK(int[] nums, int k) {
        Map<Integer, Integer> prefixXorMap = new HashMap<>();
        int n = nums.length, xor = 0, subArrayCount = 0;

        for(int i = 0; i < n; i++) {
            xor ^= nums[i]; // prefix xor till index i
            if(xor == k) {
                subArrayCount++;
            }
            int x = xor ^ k; // finding remaining xor as per previous formula: xor ^ k = x
            if(prefixXorMap.containsKey(x)) {
                subArrayCount += prefixXorMap.get(x); // add the occurrence of x into count
            }
            if(prefixXorMap.containsKey(xor)) {
                int count = prefixXorMap.get(xor); // update the xor if present by updating the count
                prefixXorMap.put(xor, ++count);
            } else {
                prefixXorMap.put(xor, 1); // add xor into map with count 1, if not present
            }
        }

        return subArrayCount;
    }

    // optimal solution - hashing (Way 2)
    public static int subarraysWithXorK(int[] nums, int k) {
        Map<Integer, Integer> prefixXorMap = new HashMap<>();
        int n = nums.length, xor = 0, count = 0;
        prefixXorMap.put(0, 1); // setting the value of 0

        for(int i = 0; i < n; i++) {
            xor = xor ^ nums[i]; // prefix xor till index i
            int x = xor ^ k; // finding remaining xor as per formula: x = xor ^ k
            count += prefixXorMap.getOrDefault(x, 0); // add the occurrence of x into count

            if(prefixXorMap.containsKey(xor)) { // update the xor if present by updating the count; otherwise add into map with count 1
                prefixXorMap.put(xor, prefixXorMap.get(xor) + 1);
            } else {
                prefixXorMap.put(xor, 1);
            }
        }
        return count;
    }
    // Time Complexity: O(N) OR O(NlogN) (depending on the map data structure)
    // Space Complexity: O(N)
}
