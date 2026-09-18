package step1.lec2;

public class Pattern19 {
    public void pattern1(int n){
        int initSpaces = 0;
       // first half
       for (int i = 1; i <= n; i++){
           // stars
           for(int j = 1; j <= n + 1 - i; j++){
               System.out.print("*");
           }

           // spaces
           for (int j = 0; j < initSpaces; j++) {
               System.out.print(" ");
           }


           // spaces
           for(int j = 1; j <= n + 1 - i; j++){
               System.out.print("*");
           }
           initSpaces += 2;
           System.out.println();
       }

       initSpaces = 2*n - 2;
       // second half
        for (int i = 1; i <= n; i++){
            // stars
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }

            // spaces
            for (int j = 0; j < initSpaces; j++) {
                System.out.print(" ");
            }


            // spaces
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            initSpaces -= 2;
            System.out.println();
        }
    }
}

/*
5, 0, 5
4, 2, 4
3, 4, 3
2, 6, 2
1, 8, 1
 */
