package step1.lec11;

import java.util.ArrayList;

/**
 * Given an input string as an array of characters, write a function that reverses the string using recursion.
 */
public class Question4 {
    // brute-force solution without recursion
    public ArrayList<Character> reverseString(ArrayList<Character> s) {
        ArrayList<Character> t = new ArrayList<>();

        // dummy values addition
        for (int i = 0; i < s.size(); i++) {
            t.add(' ');
        }

        // replacing values
        for (int i = 0; i < s.size(); i++) {
            char temp = s.get(i);
            t.set(s.size() - 1 - i, temp);
        }

        // adding correct values
        for (int i = 0; i < t.size(); i++) {
            char temp = t.get(i);
            s.set(i, temp);
        }

        return s;
    }

    // optimal solution without recursion
    public ArrayList<Character> revString(ArrayList<Character> s) {
        // 2 pointer approach
        int i = 0, n = s.size(), j = n - 1;

        while (i < j) {
            char temp = s.get(i);
            s.set(i, s.get(j - i));
            s.set(j, temp);
            i++;
            j--;
        }

        return s;
    }

    // optimal solution using recursion
    public static ArrayList<Character> reverseAString(ArrayList<Character> s) {
        // 2 pointer approach
        return twoPointerApproach(s, 0, s.size() - 1);
    }

    private static ArrayList<Character> twoPointerApproach(ArrayList<Character> s, int i, int j) {
        if (i >= j) {
            return s;
        }

        char temp = s.get(i);
        s.set(i, s.get(j));
        s.set(j, temp);

        return twoPointerApproach(s, i + 1, j - 1);
    }
}
