package step3.lec1;

import java.util.Arrays;

/**
 * Given an array of integers nums, return the second-largest element in the array.
 * If the second-largest element does not exist, return -1.
 */
public class Question3 {
    // Brute-force solution
    public static int secondLargestElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int largestElement = nums[n - 1];
        int secondLargestElement = -1;

        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] != largestElement) {
                secondLargestElement = nums[i];
                break;
            }
        }

        return secondLargestElement;
    }
    // Time Complexity: O(N log N)(sorting) + O(N - 2)(iterating to find the second-largest element from sorted array) -> O(N log N) + O(N - 2) -> O(N log N  + N)
    // Space Complexity: O(1)

    // Better solution
    public static int secondLargestElementArray(int[] nums) {
        int largestElement = nums[0], secondLargest = -1;

        // one pass to find the largest element
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > largestElement) {
                largestElement = nums[i];
            }
        }

        // one pass to find the secondLargest element
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > secondLargest && nums[i] != largestElement) {
                secondLargest = nums[i];
            }
        }

        return secondLargest;
    }
    // Time Complexity: O(N)(one pass to find largest element) + O(N)(one pass to find second-largest element) -> O(2N)
    // Space Complexity: O(1)

    // Optimal solution
    public static int secondLargestElementInAnArray(int[] nums) {
        int largestElement = nums[0], secondLargestElement = -1;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > largestElement) {
                secondLargestElement = largestElement;
                largestElement = nums[i];
            } else if (nums[i] > secondLargestElement && nums[i] != largestElement) {
                secondLargestElement = nums[i];
            }
        }

        return secondLargestElement;
    }
    // Time Complexity: O(N)(one pass to find largest and second-largest element) -> O(N)
    // Space Complexity: O(1)
}
