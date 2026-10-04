package step1.lec10;

import java.util.*;

/**
 * You are given a string s. Return the array of unique characters, sorted by highest to lowest occurring characters.
 * If two or more characters have same frequency then arrange them in alphabetic order.
 *
 * Link: https://leetcode.com/problems/sort-characters-by-frequency/description/
 */
public class Question8 {
    public static List<Character> frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> sortedChar = new ArrayList<>();

        //1. pre-computation
        for (int i = 0; i < s.length(); i++) {
            int freq = 0;
            if(map.containsKey(s.charAt(i))) {
                freq = map.get(s.charAt(i));
            }
            freq++;
            map.put(s.charAt(i), freq);
        }

        //2. converting the map to list using below private method
        List<Map.Entry<Character, Integer>> list = createList(map);

        //4. Add keys after custom sorting into List<Character> and return
        for (Map.Entry<Character, Integer> entry : list) {
            sortedChar.add(entry.getKey());
        }

        return sortedChar;
    }

    //3. Writing custom sorting logic with comparator
    private static List<Map.Entry<Character, Integer>> createList(Map<Character, Integer> map) {
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());

        Comparator<Map.Entry<Character, Integer>> c = new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return -1; // no swapping needed as o1 value is already greater than o2
                } else if (o1.getValue() < o2.getValue()) {
                    return 1;
                } else if ((o1.getKey() < o2.getKey())) {
                    return -1; // as freq are same, so no swapping needed as char are in alphabetical order
                } else if ((o1.getKey() > o2.getKey())) {
                    return 1;
                }
                return 0;
            }
        };

        list.sort(c);
        return list;
    }
}
