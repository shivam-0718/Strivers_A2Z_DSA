package step1.lec10;

/**
 * Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
 * A shift on s consists of moving the leftmost character of s to the rightmost position.
 * For example, if s = "abcde", then it will be "bcdea" after one shift.
 *
 * Link: https://leetcode.com/problems/rotate-string/description/
 */
public class Question6 {
    // brute-force solution
    public static boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            return true;
        }

        StringBuilder tempString = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String part1 = s.substring(0, (i + 1)); // taking part of substring
            String part2 = s.substring(i + 1); // taking another part of substring
            tempString.append(part2).append(part1); // appending part 2 with part 1

            // checking if tempString equals to goal
            if (tempString.toString().equals(goal)) {
                return true;
            }
        }
        return false;
    }

    // time complexity of brute-force approach: O(N^2) -> Generate N rotations and each comparison takes O(N) time.
    // space complexity of brute-force approach: O(N).

    // optimal solution
    public static boolean rotateStringToGoal(String s, String goal) {
        if(s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            return true;
        }

        // appending s with s and comparing whether the goal contains in s
        // if yes, then s can be rotated to take to goal
        String sToS = s + s;
        return sToS.contains(goal);
    }

    // time complexity of brute-force approach: O(N) , because checking for a substring in s + s is linear in time.
    // space complexity of brute-force approach: O(N).
}
