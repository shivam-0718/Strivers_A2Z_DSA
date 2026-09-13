package step1.lec2;

/**
 * link: same as the link in Pattern 5
 */
public class Pattern6 {
    // approach if starting from 0
    public void pattern(int n){
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - i; j++) {
                System.out.print((j + 1) + " ");
            }
            System.out.println();
        }
    }

    // approach if starting from 1
    public void pattern1(int n){
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n + 1 - i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
