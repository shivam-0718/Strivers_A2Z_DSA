package step1.lec2;

public class Pattern9 {
    //same as pattern 7 and pattern8
    // following only approach starting from 0
    public void pattern(int n) {
        // implementation of pattern 7
        for(int i = 0; i < n; i++) {
            // spaces
            for (int j = 0; j < n - 1 - i; j++) {
                System.out.print(" ");
            }

            // stars
            for (int j = 0; j < 2*i + 1; j++) {
                System.out.print("*");
            }

            // spaces
            for (int j = 0; j < n - i - i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }

        // implementation of pattern 8
        for (int i = 0; i < n; i++) {
            // spaces
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            // stars
            for (int j = 0; j < 2*n - (2*i + 1); j++) {
                System.out.print("*");
            }

            // spaces
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
