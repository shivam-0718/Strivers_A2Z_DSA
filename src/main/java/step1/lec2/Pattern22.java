package step1.lec2;

public class Pattern22 {
    public void pattern22(int n){
        for (int i = 0; i <= 2*n - 2; i++) {
            for (int j = 0; j <= 2*n - 2; j++) {
                int top = i;
                int bottom = (2*n - 2) - i;
                int left = j;
                int right = (2*n - 2) - j;
                System.out.print(n - Math.min(Math.min(top, bottom), Math.min(left, right)) + " ");
            }
            System.out.println();
        }
    }
}
