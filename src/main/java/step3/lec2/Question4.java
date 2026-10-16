package step3.lec2;

import java.util.Set;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;

/**
 * Given two sorted arrays nums1 and nums2, return an array that contains the union of these two arrays.
 * The elements in the union must be in ascending order.
 *
 * The union of two arrays is an array where all values are distinct and are present in either the first array,
 * the second array, or both.
 */
public class Question4 {
    // brute-force & better solution
    public static int[] unionArray(int[] nums1, int[] nums2) {
        Set<Integer> tempSet = new LinkedHashSet<>();
        List<Integer> union = new ArrayList<>(nums1.length + nums2.length);

        // adding elements of nums1 into set
        for (int i = 0; i < nums1.length; i++) {
            tempSet.add(nums1[i]);
        }

        // adding elements of nums2 into set
        for (int i = 0; i < nums2.length; i++) {
            tempSet.add(nums2[i]);
        }

        // adding elements of set into unionArray
        int index = 0;
        Iterator<Integer> iterator = tempSet.iterator();
        while (iterator.hasNext()) {
            union.add(index++, iterator.next());
        }

        int[] unionArray = union.stream().mapToInt(num -> num).toArray();
        Arrays.sort(unionArray);
        return unionArray;
    }

    public int[] unionOfArrays(int[] nums1, int[] nums2) {
        Set<Integer> tempSet = new LinkedHashSet<>();

        for(int i = 0; i < nums1.length; i++) {
            if(tempSet.contains(nums1[i])) {
                continue;
            } else {
                tempSet.add(nums1[i]);
            }
        }

        for(int i = 0; i < nums2.length; i++) {
            if(tempSet.contains(nums2[i])) {
                continue;
            } else {
                tempSet.add(nums2[i]);
            }
        }

        int[] unionArray = new int[tempSet.size()];
        int index = 0;

        Iterator<Integer> iterator = tempSet.iterator();
        while(iterator.hasNext()) {
            unionArray[index++] = iterator.next();
        }

        Arrays.sort(unionArray);
        return unionArray;
    }
    // Time Complexity: O(n1 + n2)(set inserts elements (avg O(1) each)) + O(u) copy + O(u log u) sort [u -> n1 + n2] -> O((n1 + n2) log (n1 + n2))
    // Space Complexity: O(u) set + O(u) list → O(n1 + n2) auxiliary (u = unique count)

    // optimal solution
    public static int[] unionOf2Arrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length, i = 0, j = 0;
        List<Integer> union = new ArrayList<>();

        while(i < n1 && j < n2) {
            if(nums1[i] < nums2[j]) {
                if(!union.contains(nums1[i])) {
                    union.add(nums1[i]);
                }
                i++;
            } else {
                if(union.size() == 0 || union.get(union.size() - 1) != nums2[j]) {
                    union.add(nums2[j]);
                }
                j++;
            }
        }

        while(i < n1) {
            if(union.size() == 0 || union.get(union.size() - 1) != nums1[i]) {
                union.add(nums1[i]);
            }
            i++;
        }

        while(j < n2) {
            if(union.size() == 0 || union.get(union.size() - 1) != nums2[j]) {
                union.add(nums2[j]);
            }
            j++;
        }

        return union.stream().mapToInt(num -> num).toArray();
    }
    // Time Complexity: O(n1 + n2)
    // Space Complexity: O(n1 + n2)
}
