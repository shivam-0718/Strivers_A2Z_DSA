package step2;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 4, 1, 5, 3};
        System.out.println("Array before sorting: ");

        System.out.print("[");
        for (int num : nums) {
            System.out.print(num + ",");
        }
        System.out.print("]");
        System.out.println();

        int[] ansArray = Question1.selectionSort(nums);
        System.out.println("Array after sorting: ");

        System.out.print("[");
        for (int num : ansArray) {
            System.out.print(num + ",");
        }
        System.out.print("]");
        System.out.println();
    }
}
