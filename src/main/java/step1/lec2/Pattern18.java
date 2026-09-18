package step1.lec2;

public class Pattern18 {
    public void pattern1(int n){
        for (int i = 1; i <= n; i++){
            char ch = 'F';
            ch -= i;
            for (int j = 1; j <= i; j++){
                System.out.print(ch++ + " ");
            }
            System.out.println();
        }
    }
}
