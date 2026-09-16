package step1.lec2;

public class Pattern13 {
    // approach if starting from 0
    public void pattern(int n){
        int sum = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(sum++ + " ");
            }
            System.out.println();
        }
    }

    // approach if starting from 1
    public void pattern1(int n){
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(sum++ + " ");
            }
            System.out.println();
        }
    }
}
