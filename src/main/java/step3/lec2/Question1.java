package step3.lec2;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums, move all the 0's to the end of the array. The relative order of the other elements must remain the same.
 * This must be done in place, without making a copy of the array.
 */
public class Question1 {
    // Brute-force solution
    public static void moveZeroesToEnd(int[] nums) {
        List<Integer> nonZeroNos = new ArrayList<>();

        // add non-zero nos to separate list
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nonZeroNos.add(nums[i]);
            }
        }

        // putting non-zero numbers to array
        int index = 0;
        for(Integer num : nonZeroNos) {
            nums[index++] = num;
        }

        // adding zero to the remaining end places
        for(int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
    // Time Complexity: O(N)(moving non-zero elements to another array, worst case if there are no 0s) + O(N)(placing all non-zero elements back to array) + O(k)(placing 0s to the end, if there)\
    // Space Complexity: O(N)(extra arraylist to store non-zero elements)

    // Optimal solution
    public static void moveZeroesEnd(int[] nums) {
        int zeroIndex = 0; // this index will point to the element having 0 in the array
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[zeroIndex];
                nums[zeroIndex] = temp;
                zeroIndex++;
            }
        }
    }
    // Time Complexity: O(N)
    // Space Complexity: O(1)
}
