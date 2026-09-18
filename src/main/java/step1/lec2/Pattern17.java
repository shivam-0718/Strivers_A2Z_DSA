package step1.lec2;

public class Pattern17 {
    // approach if starting from 1
    public void pattern1(int n){
        for (int i = 1; i <= n; i++){
            char ch = 'A';
            // spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // character
            // breakPoint needed as before this, ch++ happens
            // and after breakPoint, ch-- happens
            int breakPoint = (2*i + 1) / 2;
            for(int j = 1; j <= 2*i - 1; j++){
                System.out.print(ch);
                if(j < breakPoint){
                    ch++;
                } else {
                    ch--;
                }
            }

            // spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
/*

3, 1, 3
2, 3, 2
1, 5, 1
0, 7, 0
 */
