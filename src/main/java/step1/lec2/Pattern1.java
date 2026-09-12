package step1.lec2;

/**
 * Link: https://www.naukri.com/code360/problems/n-forest_6570177
 */
public class Pattern1 {
    // approach if starting from 0
    public void pattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // approach starting from 1
    public void pattern1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
