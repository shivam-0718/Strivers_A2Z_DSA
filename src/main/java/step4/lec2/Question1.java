package step4.lec2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array nums of n integers, return the length of the longest sequence of consecutive integers.
 * The integers in this sequence can appear in any order.
 *
 * LeetCode: https://leetcode.com/problems/longest-consecutive-sequence/description/
 * Code360: https://www.naukri.com/code360/problems/longest-successive-elements_6811740
 */
public class Question1 {
    // brute-force solution
    public static int longestSequenceConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }

        int longest = 1; // initialize the longest sequence length
        for(int i = 0; i < n; i++) {
            int x = nums[i]; // current element from the array
            int count = 1; // count of the current sequence

            // search for consecutive numbers, if present in the sequence
            while(linearSearch(nums, x + 1)) {
                count = count + 1; // increment the count of the sequence
                x = x + 1; // move to the next number in the sequence
            }

            longest = Math.max(longest, count); // update the longest sequence found so far
        }

        return longest;
    }

    // Helper function to perform linear search
    private static boolean linearSearch(int[] nums, int x) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == x) {
                return true;
            }
        }
        return false;
    }
    // Time Complexity: O(N^3)
    // Space Complexity: O(1)

    // better solution
    public static int longestConsecutiveSequenceInArray(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }

        Arrays.sort(nums); // sort the array
        int longest = 1;  // initialize the longest sequence length
        int lastSmaller = Integer.MIN_VALUE; // last smaller element in current sequence
        int count = 0; // current sequence length

        for(int i = 0; i < n; i++) { // if consecutive number exists, increment sequence count
            if(nums[i] - 1 == lastSmaller) {
                count += 1;
                lastSmaller = nums[i]; // update last smaller element
            } else if(nums[i] != lastSmaller) { // else if no consecutive numbers are there, then reset count for current sequence
                count = 1;
                lastSmaller = nums[i]; // update last smaller number
            }
            longest = Math.max(longest, count); // update longest
        }

        return longest;
    }
    // Time Complexity: O(NlogN) + O(N)
    // Space Complexity: O(1)(but input array has been distorted)

    // optimal solution
    public static int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }

        int longest = 1; // initialize the longest sequence length
        Set<Integer> set = new HashSet<>(); // initialize the set to store unique elements

        // Adding all elements into set
        for(int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        // Traversing set to find the longest sequence
        for(int element : set) {
            if(!set.contains(element - 1)) {  // if element is starting number of sequence
                int count = 1;  // starting the count of sequence
                int x = element; // starting element of the sequence

                while(set.contains(x + 1)) {  // if consecutive element is present in set
                    x = x + 1; // move to the next element of the sequence
                    count += 1; // increment the count of the sequence
                }

                longest = Math.max(longest, count); // update the longest sequence length
            }
        }

        return longest;
    }
    // Time Complexity: O(N) + O(2N) ~ O(3N)
    // Space Complexity: O(N)
}
