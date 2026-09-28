package step1.lec2;

public class Pattern20 {
    public void pattern20(int n) {
        int spaces = 2*n;
        for (int i = 1; i <= (2*n - 1); i++) {
            // stars
            int stars = i;
            if (i > n) {
                stars = 2*n - i;
            }

            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }

            // spaces
            spaces = (i > n) ? spaces + 2 : spaces - 2;
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }

            // stars
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
/*
1, 6, 1
2, 4, 2
3, 2, 3
4, 0, 4
3, 2, 3
2, 4, 2
1, 6, 1
 */
