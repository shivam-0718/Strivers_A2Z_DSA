package step1.lec10;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program to reverse the characters in a list without using extra
 * arraylist or list
 * Link: https://leetcode.com/problems/reverse-string/description/
 */
public class Question1 {
    // brute-force solution
    public static void reverseString(List<Character> s) {
        // creating a temp list to store characters in reverse order
        int n = s.size();
        List<Character> temp = new ArrayList<Character>(n);

        // setting dummy values in temp list
        for (int i = 0; i < s.size(); i++) {
            temp.add(' ');
        }

        // fetching values from i in s list and placing them
        // at n - i - 1 position in temp list
        for (int i = 0; i < s.size(); i++) {
            temp.set(i, s.get(n - i - 1));
        }

        for (int i = 0; i < s.size(); i++) {
            s.set(i, temp.get(i));
        }

        System.out.println(s);

    }

    // Time complexity for brute-force -> O(N)
    // Space complexity for brute-force -> O(N)

    // optimal solution
    public static void reverseAString(List<Character> s) {
        int i = 0;
        int j = s.size() - 1;

        while(i < j) {
            char temp = s.get(i);
            s.set(i, s.get(j));
            s.set(j, temp);
            i++;
            j--;
        }

        System.out.println(s);
    }

    // Time complexity for optimal -> O(N)
    // Space complexity for optimal -> O(1)
}
