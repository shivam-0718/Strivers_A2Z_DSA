package step1.lec9;

import java.util.Map;
import java.util.HashMap;

/**
 * Write a program to find the sum of the frequencies of the highest occurring number and lowest occurring number.
 */
public class Question3 {
    public static int sumOfHighestAndLowestFrequency(int[] nums) {
        boolean[] visited = new boolean[10000]; // tracking whether the number visited or not
        int n = nums.length;
        int maxFreq = 0, minFreq = n;

        for (int i = 0; i < n; i++) {
            // if the number not visited then we can count that number
            // if already used and repeated, then skip
            if(visited[nums[i]]) {
                continue;
            }
            int freq = 0; // local counter of the number nums[i] selected
            for (int j = 0; j < n; j++) {
                if(nums[j] == nums[i]) {
                    freq++;
                    visited[nums[i]] = true; // counting the occurrence of the given element
                }
            }

            // if frequency of nums[i] > maxFreq and < minFreq, assign it to both
            // else if greater than maxFreq, assign the value to it
            // else if lesser than minFreq, assign the value to it
            if(freq > maxFreq && freq < minFreq) {
                maxFreq = freq;
                minFreq = freq;
            } else if (freq > maxFreq) {
                maxFreq = freq;
            } else if (freq < minFreq) {
                minFreq = freq;
            }
        }

        return maxFreq + minFreq; // returning the sum as per the question
    }
    // Time complexity for brute-force -> O(N^2)
    // Space complexity for brute-force -> O(N)

    public static int sumHighestAndLowestFrequency(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0, minFreq = nums.length;

        // pre-computation
        for (int num : nums) {
            int freq = 0;
            if (map.containsKey(num)) {
                freq = map.get(num);
            }
            freq++;
            map.put(num, freq);
        }

        // fetching the frequency
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            if(freq > maxFreq && freq < minFreq) {
                maxFreq = freq;
                minFreq = freq;
            } else if (freq > maxFreq) {
                maxFreq = freq;
            } else if (freq < minFreq) {
                minFreq = freq;
            }
        }

        return maxFreq + minFreq;
    }

    // Time complexity for brute-force -> O(N)
    // Space complexity for brute-force -> O(N)
}
