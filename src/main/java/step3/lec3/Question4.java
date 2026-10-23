package step3.lec3;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an M * N matrix, print the elements in a clockwise spiral manner.
 * Return an array with the elements in the order of their appearance when printed in a spiral manner.
 */
public class Question4 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();

        //Initializing boundaries of matrix
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;

        //Continuing spiral traversal within boundaries
        while(top <= bottom && left <= right) {
            //1. Left to right along top row
            for (int i = left; i <= right; i++) {
                answer.add(matrix[top][i]);
            }
            top++; //move top boundary downwards

            //2. Top to Bottom along Right column
            for (int i = top; i <= bottom; i++) {
                answer.add(matrix[i][right]);
            }
            right--;  //Move right boundary leftwards

            //3. Right to left along Bottom row
            //Check if there's still a row to traverse (prevents revisiting in single-row case)
            if(top <= bottom) {
                for (int i = right; i >= left; i--) {
                    answer.add(matrix[bottom][i]);
                }
                bottom--; //Move bottom boundary upwards
            }

            //4. Bottom to top
            //Check if there's still a column to traverse (prevents revisiting in single-column case)
            if(left <= right) {
                for (int i = bottom; i >= top; i--) {
                    answer.add(matrix[i][left]);
                }
                left++; //Move left boundary rightwards
            }
        }
        return answer;
    }
    // Time Complexity: O(N×M)
    // Space Complexity: O(1) (as not considering extra space)
}

