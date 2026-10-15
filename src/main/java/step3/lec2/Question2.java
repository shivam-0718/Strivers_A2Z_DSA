package step3.lec2;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Given an integer array nums sorted in non-decreasing order, remove all duplicates in-place so that each unique
 * element appears only once.
 * Return the number of unique elements in the array.
 */
public class Question2 {
    // Brute-force solution
    public static int removeTheDuplicatesFromSortedArray(int[] nums) {
        Set<Integer> uniqueNumbers = new LinkedHashSet<>();

        for(int i = 0; i < nums.length; i++) {
            uniqueNumbers.add(nums[i]);
        }

        Iterator<Integer> itr = uniqueNumbers.iterator();
        int index = 0;
        while(itr.hasNext()) {
            nums[index++] = itr.next();
        }

        return index; // This will return the number of unique elements in the array
    }
    // Time Complexity: O(N log N)(adding elements into set) + O(N)(entering elements from set back to array, if all are unique elements) -> O(N log N + N)
    // Space Complexity: O(N)(taking an extra space for set)

    // Brute-force solution
    public static int removeDuplicatesFromSortedArray(int[] nums) {
        int i = 0, j = 1;
        while(j < nums.length) {
            if(nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                i++;
            }
            j++;
        }
        return i + 1; // This will return the number of unique elements in the given array
    }
    // Time Complexity: O(N)
    // Space Complexity: O(1)

}
