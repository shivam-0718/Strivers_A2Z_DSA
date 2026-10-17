package step3.lec3;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums, return a list of all the leaders in the array.
 *
 * A leader in an array is an element whose value is strictly greater than all elements to its right in the given array.
 * The rightmost element is always a leader.
 * The elements in the leader array must appear in the order they appear in the nums array.
 */
public class Question2 {
    // brute-force solution
    public static List<Integer> leadersInList(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            boolean isLeader = true; // considering that the selected element is the leader.

            for(int j = i + 1; j < n; j++) {
                if(nums[j] >= nums[i]) { // if any element on the right >= selected element, then that element is not a leader
                    isLeader = false;
                    break;
                }
            }

            // if the element is a leader, add it in the arraylist
            if(isLeader) {
                ans.add(nums[i]);
            }
        }

        return ans;
    }
    // Time Complexity ~ O(N^2)
    // Space Complexity = O(N)

    // optimal solution
    public static List<Integer> leaders(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int max = Integer.MIN_VALUE; // this can be set as per the constraints in the question

        for(int i = n - 1; i >= 0; i--) {
            if(nums[i] > max) {
                max = nums[i];
                ans.add(nums[i]);
            }
        }

        reverseArrayList(ans); // this is optional, depends on how we want the list to be returned
        return ans;
    }

    private static void reverseArrayList(List<Integer> list) {
        int i = 0, j = list.size() - 1;

        while(i < j) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
            i++;
            j--;
        }
    }
    // Time Complexity: O(N) + O(N log N)(if sorting is required)
    // Space Complexity: O(N)
}
