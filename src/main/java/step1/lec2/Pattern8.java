package step1.lec2;

public class Pattern8 {
    // approach if starting from 0
    public void pattern(int n) {
        for (int i = 0; i < n; i++) {
            // spaces
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }

            // stars
            for (int j = 0; j < 2*n - (2*i + 1); j++) {
                System.out.print("*");
            }

            // spaces
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }

            System.out.println();
        }
    }

    // approach if starting from 1
    public void pattern1(int n) {
        for (int i = 1; i <= n; i++) {
            // spaces
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }

            // stars
            // in pattern 7, we did 2*i - 1, now we will be subtracting from 2n
            // j = 2*n - (2*i - 1) => 2*(n - i) + 1
            for (int j = 1; j <= 2*n - (2*i - 1); j++) {
                System.out.print("*");
            }

            // spaces
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
