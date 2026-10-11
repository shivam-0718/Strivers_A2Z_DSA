package step2;
/**
 * Given an array of integers called nums, sort the array in non-decreasing order using the quick sort algorithm and
 * return the sorted array.
 *
 * A sorted array in non-decreasing order is an array where each element is greater than or equal to all preceding
 * elements in the array.
 */
public class Question5 {
    /**
     * Quick Sort logic: Pick a pivot and place it in its correct position, so smaller
     * elements go to its left and larger ones to its right (partition).
     * Then repeat the same for the left and right parts (recursion).
     * Time: O(n log n) average, O(n²) worst (bad pivot) | Space: O(log n) stack | Not stable
     */
    public static int[] quickSort(int[] nums) {
        quickSort(nums, 0,  nums.length - 1);
        return nums;
    }

    private static void quickSort(int[] nums, int low, int high) {
        if(low < high) {
            int partitionIndex = partition(nums, low, high);
            quickSort(nums, low, partitionIndex - 1); // sorting the left half of the array
            quickSort(nums, partitionIndex + 1, high); // sorting the right half of the array
        }
    }

    private static int partition(int[] nums, int low, int high) {
        // picking pivot from the start: pivot = nums[low]
        int i = low, j = high;

        while(i < j) {
            // finding the element from the left greater than pivot
            while(nums[i] <= nums[low] && i < high) { // to prevent exception hence we are keeping till high - 1
                i++;
            }

            // finding the element from the right smaller than pivot
            while(nums[j] > nums[low] && j > low) { // to prevent exception hence we are keeping till low + 1
                j--;
            }

            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        // swapping nums[j] and pivot (nums[low]) to place the pivot at the correct place
        int temp = nums[low];
        nums[low] = nums[j];
        nums[j] = temp;

        return j; // as j has crossed i, so j is our partitionIndex where the pivot has been correctly placed
    }

    /**
     * <h2>Time Complexity: O(N log N) average, O(N²) worst</h2>
     * <ol>
     *   <li><b>Partition</b> — the pivot is compared with every element in the
     *       current range once, so each level of recursion costs {@code O(N)}.</li>
     *   <li><b>Divide</b> — after partitioning, the pivot sits in its final place
     *       and the two sides are sorted recursively. If the pivot lands near the
     *       middle, the range halves each time, giving {@code log2(N)} levels.</li>
     *   <li><b>Total (average/best)</b> — {@code log2(N)} levels × {@code O(N)}
     *       per level = {@code O(N log N)}.</li>
     *   <li><b>Worst case</b> — if the pivot is always the smallest or largest
     *       element (e.g. first-element pivot on an already sorted array), one side
     *       is empty and the other has {@code N - 1} elements. That gives {@code N}
     *       levels × {@code O(N)} = {@code O(N²)}. A random or middle pivot makes
     *       this very unlikely.</li>
     * </ol>
     * <p>
     * Unlike Merge Sort, the cost depends on the data, because the split
     * depends on where the pivot lands.
     *
     * <h2>Space Complexity: O(log N) average, O(N) worst</h2>
     * <p>
     * Partitioning swaps elements inside the same array, so no temporary
     * array is needed. The only extra space is the recursion stack:
     * {@code O(log N)} levels on average, {@code O(N)} in the worst case.
     * Quick Sort is therefore <b>in-place</b>, but it is <b>not stable</b>
     * (swaps can change the order of equal elements).
     *
     */
}
