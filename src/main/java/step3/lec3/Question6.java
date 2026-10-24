package step3.lec3;

/**
 * Given an integer r, return all the values in the rth row (1-indexed) in Pascal's Triangle in correct order.
 * In Pascal's triangle:
 *
 * - The first row has one element with a value of 1.
 * - Each row has one more element in it than its previous row.
 * - The value of each element is equal to the sum of the elements directly above it when arranged in a triangle format.
 */
public class Question6 {
    //brute-force solution
    public static int[] findNthRowElementsOfPascalTriangle(int r) {
        int[] ans = new int[r];
        int row = r - 1;
        ans[0] = 1; // first element will always be 1

        // Each element of the row can be computed as C(n-1, i)
        for(int i = 1; i < ans.length; i++) {
            ans[i] = NthElementPascalTriangle(row, i); // Using direct nCr function instead of factorials
        }

        return ans;
    }

    // Function to calculate nCr iteratively (avoids large factorials)
    // nCr = (n * (n-1) * ... * (n-r+1)) / (1 * 2 * ... (r-1) * r)
    private static int NthElementPascalTriangle(int row, int col) {
        long ans = 1;

        // Run loop exactly r times (i = 0 → r-1)
        // Each step multiplies numerator by (n - i)
        // and divides denominator by (i + 1)
        for(int i = 0; i < col; i++) {
            ans = ans * (row - i);
            ans = ans / (i + 1);
        }

        return (int) ans;
    }
    // Time Complexity: O(r)
    // Space Complexity: O(1)

    // optimal solution
    public static int[] pascalTriangleII(int r) {
        int[] ans = new int[r];
        ans[0] = 1; // first element is always 1
        int res = 1;

        // Each element can be derived from the previous one.
        for(int i = 1; i < r; i++) {
            res = res * (r - i);
            res = res / i;
            ans[i] = res;
        }

        return ans;
    }
    // Time Complexity: O(r)
    // Space Complexity: O(1)
}
