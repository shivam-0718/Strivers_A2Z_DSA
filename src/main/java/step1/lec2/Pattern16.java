package step1.lec2;

public class Pattern16 {
    // approach if starting from 0
    public void pattern(int n){
        char ch = 'A';
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(ch + " ");
            }
            ch++;
            System.out.println();
        }
    }

    // approach if starting from 1
    public void pattern1(int n){
        char ch = 'A';
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(ch + " ");
            }
            ch++;
            System.out.println();
        }
    }
}
