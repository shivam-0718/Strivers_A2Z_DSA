package step3.lec3;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of even length consisting of an equal number of positive and negative integers.
 * Return the answer array in such a way that the given conditions are met:
 *      1. Every consecutive pair of integers have opposite signs.
 *      2. For all integers with the same sign, the order in which they were present in nums is preserved.
 *      3. The rearranged array begins with a positive integer.
 */
public class Question3 {
    public static int[] rearrangeTheArray(int[] nums) {
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                positive.add(nums[i]);
            } else {
                negative.add(nums[i]);
            }
        }

        for(int i = 0; i < nums.length / 2; i++) {
            nums[2*i] = positive.get(i);
            nums[2*i + 1] = negative.get(i);
        }

        return nums;
    }
    // Time Complexity: O(N) + O(N/2)
    // Space Complexity: O(N/2) + O(N/2) -> O(N)

    public static int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int posIndex = 0, negIndex = 1;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) {
                ans[negIndex] = nums[i];
                negIndex += 2;
            } else {
                ans[posIndex] = nums[i];
                posIndex += 2;
            }
        }

        return ans;
    }
    // Time Complexity: O(N)
    // Space Complexity: O(N)
}
