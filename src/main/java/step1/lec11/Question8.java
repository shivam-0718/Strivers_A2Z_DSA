package step1.lec11;

import java.util.ArrayList;

/**
 * Given an array nums of n integers, return true if the array nums is sorted in non-decreasing order or else false.
 * Use recursion
 */
public class Question8 {
    public static boolean isSorted(ArrayList<Integer> nums) {
        return compare(nums, 0, 1);
    }

    private static boolean compare(ArrayList<Integer> nums, int i, int j) {
        if (j == nums.size()) {
            return true;
        }

        if (nums.get(i) > nums.get(j)) {
            return false;
        }

        return compare(nums, i + 1, j + 1);

    }
}
