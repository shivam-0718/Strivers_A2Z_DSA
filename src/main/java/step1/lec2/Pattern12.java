package step1.lec2;

public class Pattern12 {
    // approach if starting from 1
    public void pattern1(int n){
        int spaces = 2*n - 2;
        for (int i = 1; i <= n; i++){
            // number
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            // space
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }

            // number
            for(int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
            spaces -= 2;

        }
    }
}
