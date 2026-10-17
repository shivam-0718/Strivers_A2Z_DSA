package step3.lec3;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums of size n, return the majority element of the array.
 * The majority element of an array is an element that appears more than n/2 times in the array.
 * The array is guaranteed to have a majority element.
 */
public class Question1 {
    // brute-force solution
    public static int majorityElementInAnArray(int[] nums) {
        int n = nums.length;
        int majorityElement = 0; // this can be anything as per constraints. It differs as per different constraints

        // run a loop, pick an element from the array. With the selected element, run an inner loop to find the count
        // of the selected element in the array
        for(int i = 0; i < n; i++) {
            int count = 0;
            int element = nums[i];

            for(int j = 0; j < n; j++) {
                if(nums[j] == element) {
                    count++;
                }
            }

            // if the count of the selected element is more than half of array's length
            // then that element is majorityElement
            if(count > (n / 2)) {
                majorityElement = element;
                break;
            }
        }

        return majorityElement;
    }
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)

    // better solution
    public static int majorityElementArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int majorityElement = -10000; // as per constraints, the element can be between -10000, and +10000. It differs as per different constraints

        // pre-computation of count of elements in hashing
        for(int i = 0; i < nums.length; i++) {
            int freq = 0;
            if(map.containsKey(nums[i])) {
                freq = map.get(nums[i]);
            }
            freq++;
            map.put(nums[i], freq);
        }

        // iterating through map, checking if value is greater than half of array's length, then return key.
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() > (nums.length / 2)) {
                majorityElement = entry.getKey();
                break;
            }
        }

        return majorityElement;
    }
    // Time Complexity: O(N log N)(to add elements into HashMap) + O(N)(iterating through hashmap to find majority element)
    // Space Complexity: O(N)(using extra hashMap, if elements are unique)

    // optimal solution
    // Boyer Moore's Majority Voting Algorithm
    public static int majorityElement(int[] nums) {
        int count = 0, ele = 0; // count to keep track of count of current element
        int majorityElement = -10000;

        // Applying Moore's majority voting algorithm
        for(int i = 0; i < nums.length; i++) {
            if(count == 0) {
                count++;
                ele = nums[i];
            } else if(ele == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        // verifying if ele is the majorityElement
        int countEle = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == ele) {
                count++;
            }
        }

        if(countEle > (nums.length / 2)) {
            majorityElement = ele;
        }

        return majorityElement;
    }
    // Time Complexity: O(N)(for algorithm) + O(N)(verifying if element is majority element)
    // Space Complexity: O(1)
}
