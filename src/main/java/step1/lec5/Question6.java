package step1.lec5;

/**
 * Write a program to find the factorial of a given number
 */
public class Question6 {
   public static int factorial(int number) {
       int factorial = 1;
       for (int i = number; i > 1; i--) {
           factorial *= i;
       }
       return factorial;
   }
}
