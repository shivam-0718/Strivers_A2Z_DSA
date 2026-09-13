package step1.lec2;

/**
 * link: https://www.naukri.com/code360/problems/reverse-number-triangle_6581889
 */
public class Pattern5 {
    // approach if starting from 0
    public void pattern(int n){
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - i; j++) {
                System.out.print(("* "));
            }
            System.out.println();
        }
    }

    // approach if starting from 1
    public void pattern1(int n){
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n + 1 - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

}
