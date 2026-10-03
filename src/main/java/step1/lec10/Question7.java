package step1.lec10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 * Link: https://leetcode.com/problems/valid-anagram/description/
 */
public class Question7 {
    // brute-force approach
    public boolean anagramStrings(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        // making char arrays of given strings
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();

        // sorting the arrays
        Arrays.sort(str1);
        Arrays.sort(str2);

        // comparing the characters of the strings
        for (int i = 0; i < str1.length; i++) {
            if(str1[i] != str2[i]) {
                return false;
            }
        }
        return true;
    }

    // time complexity of brute-force approach: O(N) + O(log N) (for sorting)
    // space complexity of brute-force approach: O(N)

    // optimal solution (using array hashing)
    public static boolean anagramString(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int[] freqS = new int[256];
        int[] freqT = new int[256];
        int n = s.length();

        //pre-compute
        for(int i = 0; i < n; i++) {
            freqS[s.charAt(i)]++;
            freqT[t.charAt(i)]++;
        }

        // fetch
        for (int i = 0; i < 256; i++) {
            if(freqS[i] != freqT[i]) {
                return false;
            }
        }

        return true;
    }

    public static boolean areAnagramStrings(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> frequencyS = new HashMap<>();
        Map<Character, Integer> frequencyT = new HashMap<>();
        int n = s.length();

        //pre-compute
        for(int i = 0; i < n; i++) {
            int freqS = 0, freqT = 0;
            if(frequencyS.containsKey(s.charAt(i))) {
                freqS = frequencyS.get(s.charAt(i));
            }
            freqS++;
            frequencyS.put(s.charAt(i), freqS);

            if(frequencyT.containsKey(t.charAt(i))) {
                freqT = frequencyT.get(t.charAt(i));
            }
            freqT++;
            frequencyT.put(t.charAt(i), freqT);

        }

        // directly comparing maps
        return frequencyS.equals(frequencyT);
    }

    // time complexity of optimal approach: O(N)
    // space complexity of optimal approach: O(N) (for extra arrays / extra maps)

}
