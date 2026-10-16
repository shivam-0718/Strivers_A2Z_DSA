package step3.lec2;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two sorted arrays, nums1 and nums2, return an array containing the intersection of these two arrays.
 * Each element in the result must appear as many times as it appears in both arrays; that is, if an element appears
 * x times in nums1 and y times in nums2, it should appear min(x, y) times in the result.
 *
 * The intersection of two arrays is an array where all values are present in both arrays.
 * Since both input arrays are sorted, the resulting intersection array should also be in sorted order.
 */
public class Question5 {
    // brute-force solution
    public static int[] intersectionOfArrays(int[] nums1, int[] nums2) {
        int[] visited = new int[nums2.length];
        List<Integer> intersection = new ArrayList<>();

        // picking one element from nums1, and iterating it through nums2 for each element
        for(int i = 0; i < nums1.length; i++) {

            // taken nums1[i] and iterating throughout the nums2 array
            for(int j = 0; j < nums2.length; j++) {
                // visited array will tell if nums1[i] and nums2[j] are equal and then visited[] will tell
                // whether the value has been taken or not.
                // If not taken, then add the element and break out, else continue
                if(nums1[i] == nums2[j] && visited[j] == 0) {
                    intersection.add(nums1[i]);
                    visited[j] = 1;
                    break;
                }
                // if at any point of time, nums2[j] becomes greater, there is no point in going forward, so break out
                if(nums2[j] > nums1[i]) {
                    break;
                }
            }
        }
        return intersection.stream().mapToInt(num -> num).toArray();
    }
    // Time Complexity: O(n1 x n2)
    // Space complexity: O(n2)

    // Optimal solution
    public static int[] intersectionArray(int[] nums1, int[] nums2) {
        int i = 0, j = 0, n1 = nums1.length, n2 = nums2.length;
        List<Integer> intersect = new ArrayList<>();

        while(i < n1 && j < n2) {
            if(nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                intersect.add(nums2[j]);
                i++;
                j++;
            }
        }

        return intersect.stream().mapToInt(num -> num).toArray();
    }
    // Time Complexity: O(n1 + n2)
    // Space Complexity: O(n1 + n2)
}
