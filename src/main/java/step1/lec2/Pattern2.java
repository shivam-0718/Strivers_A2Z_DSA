package step1.lec2;

/**
 * link: https://www.naukri.com/code360/problems/n-2-forest_6570178
 */
public class Pattern2 {
    // approach if starting from 0
    public void pattern(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // approach if starting from 0
    public void pattern1(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
