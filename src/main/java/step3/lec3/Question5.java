package step3.lec3;

/**
 * Given row and col, print the element from a Pascal Triangle.
 */
public class Question5 {
    // brute-force solution
    public static int findNthElementPascalTriangle(int r, int c) {
        // General nCr = (n!) / (r! * (n-r)!)
        // Here, n = row - 1 and r = col - 1
        int row = r - 1,  col = c - 1;
        int num = factorial(row); // finding factorial of row
        int den = factorial(col) * factorial(row - col); // finding factorial of col and (row - col)

        return num / den; // returning the element
    }

    // finding the factorial using recursion method
    // as per nCr formula -> finding factorial of each values
    private static int factorial(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    // Time Complexity: O(r) + O(c) + O(r - c)
    // Space Complexity: O(1)

    // optimal solution
    // Using direct nCr calculation instead of factorials
    public static int pascalTriangleI(int r, int c) {
        int row = r - 1, col = c - 1; // reducing the row and column to 1 as we will be calculating based on 0-based indexing
        long ans = 1; // storing ans in long to prevent integer overflow

        // Run loop exactly r times (i = 0 → c-1)
        // Each step multiplies numerator by (row - i)
        // and divides denominator by (i + 1)
        for(int i = 0; i < col; i++) {
            ans = ans * (row - i);
            ans = ans / (i + 1);
        }
        return (int) ans;
    }
    // Time Complexity: O(c)
    // Space Complexity: O(1)
}
