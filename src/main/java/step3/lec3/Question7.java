package step3.lec3;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return the first n (1-Indexed) rows of Pascal's triangle.
 * In Pascal's triangle:
 *
 * - The first row has one element with a value of 1.
 * - Each row has one more element in it than its previous row.
 * - The value of each element is equal to the sum of the elements directly above it when arranged in a triangle format.
 */
public class Question7 {
    // optimal solution
    public List<List<Integer>> pascalTriangleIII(int n) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            List<Integer> ans = nthRow(i);
            pascalTriangle.add(ans);
        }

        return pascalTriangle;

    }

    private List<Integer> nthRow(int row) {
        List<Integer> nthRowPascal = new ArrayList<>();
        nthRowPascal.add(1); // adding first element
        int C = row - 1;
        long res = 1L;

        for(int i = 1; i <= C; i++) { // again issue, I already did row - 1, and i was doing <C, when I fixed it like <= C, then worked
            res = res * (row - i);
            res = res / i;
            nthRowPascal.add((int)res);
        }

        return nthRowPascal;
    }
    // Time Complexity: O(n * C)
    // Space Complexity: O(1)
}
