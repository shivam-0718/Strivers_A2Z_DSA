package step1.lec9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashingConcept {
    // Number hashing
    public static void numberHashing() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        // adding the elements of the array as per the size
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        // pre-compute the freq of elements in input array and storing them in the freq array
        // taking the max size of array as 10^5
        int[] freqArray = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            freqArray[arr[i]]++;
        }

        // calculation
        System.out.println("Total times this needs to be tested: ");
        int input = sc.nextInt();

        while(input-- > 0) {
            System.out.println("Enter the number whose frequency to be checked: ");
            int num = sc.nextInt();

            // fetching the frequency as per freq array and providing the answer
            System.out.println("Frequency of " + num + " is: " + freqArray[num]);
        }
    }

    // Character hashing with arrays
    public static void charHashing() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string: ");
        String str = sc.nextLine();

        // pre-compute
        // as char in a string can be converted into int as per type casting, so using int array
        int[] hashArray = new int[256];
        for(int i = 0; i < str.length(); i++) {
            hashArray[str.charAt(i)]++;
        }

        System.out.println("Total times this needs to be tested: ");
        int input = sc.nextInt();

        while(input-- > 0) {
            System.out.println("Enter the character whose frequency to be checked: ");
            char ch = sc.next().charAt(0);

            // fetch
            System.out.println("Frequency of character " + ch + " is: " + hashArray[ch]);
        }
    }

    // Number hashing using HashMap
    public static void numberHashingMap() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        // adding the elements of the array as per the size as an input
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        // fetching the key
        // if it has freq, increment it and store it in hashMap
        // else put the key into map with its freq starting from 0
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            int freq = 0;
            if(map.containsKey(i)) {
                freq = map.get(i);
            }
            freq++;
            map.put(i, freq);
        }

        // iterating through the map
        System.out.println("Map iteration (Key -> Value): ");
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // calculation
        System.out.println("Total times this needs to be tested: ");
        int input = sc.nextInt();

        while(input-- > 0) {
            System.out.println("Enter the number whose frequency to be checked: ");
            int num = sc.nextInt();

            // fetching the frequency as per freq array and providing the answer
            System.out.println("The frequency of " + num + " is: " + map.getOrDefault(num, 0));
            // if number is not present in map, give freq as 0
        }
    }

    // Number hashing using HashMap
    public static void charHashingMap() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string: ");
        String str = sc.nextLine();

        // fetching the key
        // if it has freq, increment it and store it in hashMap
        // else put the key into map with its freq starting from 0
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            int freq = 0;
            if(map.containsKey(ch)) {
                freq = map.get(ch);
            }
            freq++;
            map.put(ch, freq);
        }

        // iterating through the map
        System.out.println("Map iteration (Key -> Value): ");
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // calculation
        System.out.println("Total times this needs to be tested: ");
        int input = sc.nextInt();

        while(input-- > 0) {
            System.out.println("Enter the character whose frequency to be checked: ");
            char ch = sc.next().charAt(0);

            // fetching the frequency as per freq array and providing the answer
            System.out.println("The frequency of " + ch + " is: " + map.getOrDefault(ch, 0));
            // if character is not present in map, give freq as 0
        }
    }

    public static void main(String[] args) {
//        numberHashing();
//        charHashing();
//        numberHashingMap();
        charHashingMap();
    }
}
