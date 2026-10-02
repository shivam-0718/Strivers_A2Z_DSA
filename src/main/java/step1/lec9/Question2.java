package step1.lec9;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a program to find the second highest occurring element in an array. If there are multiple second highest occurring elements, find the smallest of them.
 * If none of them are present, return -1
 */
public class Question2 {
    // brute-force
    public static int secondMostFrequentElement(int[] nums) {
        boolean[] visited = new boolean[10000]; // tracking whether the number visited or not
        int maxEle = -1, secondMaxEle = -1, maxFreq = 0, secondMaxFreq = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // if the number not visited then we can count that number
            // if already used and repeated, then skip
            if (visited[nums[i]]) {
                continue;
            }
            int freq = 0; // local counter of the number nums[i] selected

            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    freq++;
                    visited[nums[i]] = true; // counting the occurrence of the given element
                }
            }

            // if freq of element is greater than max freq
            // transfer the contents from maxEle, maxFreq into secondMaxEle and secondMax
            // and then assign new values onto maxEle and maxFreq
            if (freq > maxFreq) {
                secondMaxEle = maxEle;
                secondMaxFreq = maxFreq;
                maxEle = nums[i];
                maxFreq = freq;
            } else if ((freq == maxFreq) && (nums[i] < maxEle)) {
                // if freq and maxFreq are same, and number is small, then change only maxEle and maxFreq
                maxEle = nums[i];
                maxFreq = freq;
            } else if ((freq > secondMaxFreq) && (freq < maxFreq)) { // if freq is less than maxFreq but greater than secondMaxElement
                // then change values only of secondMaxEle and secondMaxFreq
                secondMaxEle = nums[i];
                secondMaxFreq = freq;
            } else if (freq == secondMaxFreq && nums[i] < secondMaxEle) { // if freq and secondMaxFreq are same, and number is small,
                // then change only secondMaxEle and secondMaxFreq
                secondMaxEle = nums[i];
            }
        }

        return secondMaxEle;
    }

    public static int secondMostFreqElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxEle = -1, secondMaxEle = -1, maxFreq = 0, secondMaxFreq = 0;

        // pre-computation
        for (int num : nums) {
            int freq = 0;
            if (map.containsKey(num)) {
                freq = map.get(num);
            }
            freq++;
            map.put(num, freq);
        }

        // finding the second most freq element
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int ele = entry.getKey();
            int freq = entry.getValue();

            // if freq of element is greater than max freq
            // transfer the contents from maxEle, maxFreq into secondMaxEle and secondMax
            // and then assign new values onto maxEle and maxFreq
            if (freq > maxFreq) {
                secondMaxEle = maxEle;
                secondMaxFreq = maxFreq;
                maxEle = ele;
                maxFreq = freq;
            } else if ((freq == maxFreq) && (ele < maxEle)) {
                // if freq and maxFreq are same, and number is small, then change only maxEle and maxFreq
                maxEle = ele;
                maxFreq = freq;
            } else if ((freq > secondMaxFreq) && (freq < maxFreq)) { // if freq is less than maxFreq but greater than secondMaxElement
                // then change values only of secondMaxEle and secondMaxFreq
                secondMaxEle = ele;
                secondMaxFreq = freq;
            } else if (freq == secondMaxFreq && ele < secondMaxEle) { // if freq and secondMaxFreq are same, and number is small,
                // then change only secondMaxEle and secondMaxFreq
                secondMaxEle = ele;
            }
        }

        return secondMaxEle;
    }
}
