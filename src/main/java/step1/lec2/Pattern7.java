package step1.lec2;

/**
 * link: https://www.naukri.com/code360/problems/star-triangle_6573671
 */
public class Pattern7 {
    // approach if starting from 1
    public void pattern(int n) {
        for (int i = 1; i <= n; i++) {
            // spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // stars
            for (int j = 1; j <= 2*i - 1; j++) {
                System.out.print("* ");
            }

            // spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
