package step1.lec10;

import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Link: https://leetcode.com/problems/longest-common-prefix/description/
 */
public class Question4 {
    public static String longestCommonPrefix(String[] str) {
        Arrays.sort(str); // sort the array of strings
        String str1 = str[0];
        String str2 = str[str.length - 1];
        StringBuilder ans = new StringBuilder();

        int n = Math.min(str1.length(), str2.length());

        // compare the first and the last string because if the
        // common prefix are there in the first and last string
        // then it will be there in the strings present in between them
        // as well. Doing till min length of str1 and str2
        for (int i = 0; i < n; i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                break;
            }
            ans.append(str1.charAt(i));
        }

        return ans.toString();
    }

    // time complexity -> O(log N) (sorting) + O(min(str1.length, str2.length) (traversal)
    // space complexity -> O(1)
}
