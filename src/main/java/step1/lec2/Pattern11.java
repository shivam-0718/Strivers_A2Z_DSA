package step1.lec2;

/**
 * Link: https://www.naukri.com/code360/problems/binary-number-triangle_6581890
 */
public class Pattern11 {
    // approach if starting from 0
    public void pattern(int n){
        int ans = 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                ans = 1;
            } else {
                ans = 0;
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(ans + " ");
                ans = 1 - ans;
            }
            System.out.println();
        }
    }

    // approach if starting from 1
    public void pattern1(int n){
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                ans = 0;
            } else {
                ans = 1;
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(ans + " ");
                ans = 1 - ans;
            }
            System.out.println();
        }
    }
}
