package step1.lec10;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 *
 * Link: https://leetcode.com/problems/isomorphic-strings/description/
 */
public class Question5 {
    //brute-force solution
    public static boolean isomorphicString(String s, String t) {
        int[] sMap = new int[256];
        int[] tMap = new int[256];

        if(s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            // first we have to see whether the sMap or tMap has been assigned
            // to each other values.
            // if the values are not matching, then means both strings are NOT isomorphic strings.
            // if same values are there, then update for the next iteration
            if(sMap[s.charAt(i)] != tMap[t.charAt(i)]) {
                return false;
            }

            // if not mapped, then map these values to index + 1
            sMap[s.charAt(i)] = i + 1;
            tMap[t.charAt(i)] = i + 1;
        }
        return true;
    }

    // time complexity of brute-force approach: O(N)
    // space complexity of brute-force approach: O(k) ~ O(1)

    // optimal solution
    public static boolean areIsomorphicStrings(String s, String t) {
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            // mapST
            // check if key for s.charAt(i) exists in map
            if(mapST.containsKey(s.charAt(i))) {
                // if value do not match, then both are not isomorphic Strings
                if(mapST.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                // if key is not there, then map s.charAt(i) with t.charAt(i)
                mapST.put(s.charAt(i), t.charAt(i));
            }

            // mapTS
            // check if key for t.charAt(i) exists in map
            if(mapTS.containsKey(t.charAt(i))) {
                if(mapTS.get(t.charAt(i)) != s.charAt(i)) {
                    return false;
                }
            } else {
                // if key is not there, then map t.charAt(i) with s.charAt(i)
                mapTS.put(t.charAt(i), s.charAt(i));
            }

        }
        return true;
    }

    // time complexity of optimal approach: O(N)
    // space complexity of optimal approach: O(k) ~ O(1)
}
