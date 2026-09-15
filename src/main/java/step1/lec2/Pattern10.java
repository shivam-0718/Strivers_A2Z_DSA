package step1.lec2;

public class Pattern10 {
    public void pattern(int n){
        for (int i = 1; i <= 2*n - 1; i++) {
            int stars = i;

            // important logic
            if(i > n) {
                stars = 2*n - i;
            }

            for (int j = 1; j <= stars; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
