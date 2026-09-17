package step1.lec2;

public class Pattern15 {
    // approach if starting from 0
    public void pattern(int n){
        for (int i = 0; i < n; i++) {
            char ch = 'A';
            for (int j = 0; j < n - i; j++) {
                System.out.print(ch++ + " ");
            }
            System.out.println();
        }
    }

    // approach if starting from 1
    public void pattern1(int n){
        for (int i = 1; i <= n; i++) {
            char ch = 'A';
            for (int j = 1; j <= n + 1 - i; j++) {
                System.out.print(ch++ + " ");
            }
            System.out.println();
        }
    }
}
