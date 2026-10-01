package step1.lec9;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a program to find the highest occurring element in an array. If there are multiple highest occurring elements, find the smallest of them.
 * Link: https://leetcode.com/problems/frequency-of-the-most-frequent-element/
 */
public class Question1 {
    // brute-force solution
    public static int mostFrequentElement(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[10000]; // tracking whether the number visited or not
        int element = -1, maxFreq = 0;

        for (int i = 0; i < n; i++) {
            // if the number not visited then we can count that number
            // if already used and repeated, then skip
            if(visited[nums[i]]) {
                continue;
            }
            int count = 0; // local counter of the number nums[i] selected

            for (int j = 0; j < n; j++) {
                if(nums[i] == nums[j]) {
                    visited[nums[i]] = true;
                    count++; // counting the occurrence of the given element
                }
            }

            // if the count of nums[i] is more than maxFreq, then return the given element
            if (count > maxFreq) {
                element = nums[i];
                maxFreq = count;
            } else if (count == maxFreq && nums[i] < element) {
                // if the count is same and nums[i] < previous element, then return that
                element = nums[i];
            }
        }
        return element;
    }

    // Time complexity for brute-force -> O(N^2)
    // Space complexity for brute-force -> O(N)

    // optimal solution
    public static int mostFreqElement(int[] nums) {
        int n = nums.length;
        int maxEle = 0, maxFreq = 0;
        Map<Integer, Integer> map = new HashMap<>();

        //pre-compute
        for (int num : nums) {
            int freq = 0;
            if (map.containsKey(num)) {
                freq = map.get(num);
            }
            freq++;
            map.put(num, freq);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int element = entry.getKey();
            int freq = entry.getValue();

            if(freq > maxFreq) {
                maxFreq = freq;
                maxEle = element;
            } else if (freq == maxFreq && element < maxEle) {
                maxEle = element;
            }
        }
        return maxEle;
    }

    // Time complexity for optimal -> O(N)
    // Space complexity for optimal -> O(N)

}
