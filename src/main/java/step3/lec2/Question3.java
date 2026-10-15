package step3.lec2;

/**
 * Given an integer array of size n containing distinct values in the range from 0 to n (inclusive),
 * return the only number missing from the array within this range.
 */
public class Question3 {
    // Brute-force solution
    public static int missingNumberFromArray(int[] nums) {
        int missingNumber = -1;
        int n = nums.length + 1; // range to find missing number from 0 till n

        for(int i = 0; i <= n; i++) {
            boolean flag = false;
            for(int j = 0; j < nums.length; j++) {
                if(nums[j] == i) {
                    flag = true;
                    break;
                }
            }
            if(flag == false) {
                missingNumber = i;
                break;
            }
        }
        return missingNumber;
    }
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)

    // Better solution
    public static int missingNumberArray(int[] nums) {
        int missingNumber = -1;
        int n = nums.length + 1;
        int[] hash = new int[n];

        // pre-computation
        for(int i = 0; i < nums.length; i++) {
            hash[nums[i]]++;
        }

        for(int i = 0; i < hash.length; i++) {
            if(hash[i] == 0) {
                missingNumber = i;
                break;
            }
        }
        return missingNumber;
    }
    // Time Complexity: O(N)(for pre-computation into hash array) + O(N)(traversing hash array to find freq = 0 and fetch index) -> O(2N)
    // Space Complexity: O(N + 1)(for frequency of the numbers from O to N)

    // Optimal solution
    public static int missingNumberFromTheArray(int[] nums) {
        int n = nums.length;
        int sumA = 0, sumN = (n * (n + 1)) / 2;

        for(int i = 0; i < nums.length; i++) {
            sumA += nums[i];
        }

        return sumN - sumA;
    }
    // Time Complexity: O(N)
    // Space Complexity: O(1)
}
