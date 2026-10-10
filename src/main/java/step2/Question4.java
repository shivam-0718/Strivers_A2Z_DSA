package step2;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers called nums, sort the array in non-decreasing order using the merge sort algorithm and
 * return the sorted array.
 *
 * A sorted array in non-decreasing order is an array where each element is greater than or equal to all preceding
 * elements in the array.
 */
public class Question4 {
    public static int[] mergeSort(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int[] mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return nums;
        }
        int mid = (low + high) / 2;  // finding the middle index of the array
        int[] firstHalf = mergeSort(nums, low, mid);  // first half -> from 0 to mid
        int[] secondHalf = mergeSort(nums, mid + 1, high);  // second half -> from mid + 1 to high
        return merge(nums, low, mid, high); // merging both the sorted halves and returning the sorted array
    }

    private static int[] merge(int[] nums, int low, int mid, int high) {
        List<Integer> list = new ArrayList<>();
        int left = low; //starting index of left half of array
        int right = mid + 1; //starting index of right half of array

        //storing elements in the temporary arraylist in a sorted manner
        while(left <= mid && right <= high) {
            if(nums[left] <= nums[mid]) {
                list.add(nums[left]);
                left++;
            } else {
                list.add(nums[right]);
                right++;
            }
        }

        // add remaining elements from the left half of array if right half elements are
        // already added in the arraylist
        while (left <= mid) {
            list.add(nums[left]);
            left++;
        }

        // add remaining elements from the right half of array if left half elements are
        // already added in the arraylist
        while (right <= high) {
            list.add(nums[right]);
            right++;
        }

        // 1st way: Add the sorted elements from the arrayList into actual array and return the same
        /*
            for (int i = low; i <= high; i++) {
                nums[i] = list.get(i - low);
            }
            return nums;
        */


        // 2nd way: convert the arraylist into array using stream API concept
        return list.stream().mapToInt(i -> i).toArray();
    }

    /**
     * <h2>Time Complexity: O(N log N)</h2>
     * <ol>
     *   <li><b>Divide</b> — the array is split in half at each step, giving
     *       {@code log2(N)} levels of recursion. (Splitting into 10 parts
     *       instead would give {@code log10(N)} levels.)</li>
     *   <li><b>Merge</b> — at every level, merging touches all N elements
     *       once, so each level costs {@code O(N)}.</li>
     *   <li><b>Total</b> — {@code log2(N)} levels × {@code O(N)} per level
     *       = {@code O(N log N)}.</li>
     * </ol>
     * <p>
     * The cost is the same in the best, average and worst case, because the
     * split does not depend on the order of the data.
     *
     * <h2>Space Complexity: O(N)</h2>
     * <p>
     * A temporary array is used while merging. The recursion stack adds
     * {@code O(log N)}, which is smaller than N. Merge Sort is therefore
     * <b>not in-place</b>, but it is <b>stable</b>.
     *
     */
}
