package step1.lec3;

import java.util.*;

/**
 * Java Collection Framework
 * 1. Custom Classes (Done)
 * 2. Collection Interface
 *      a. List Interface
 *          i. ArrayList Class (Done)
 *          ii. LinkedList Class (Done)
 *          iii. Stack Class (Done)
 *          iv. Vector Class (Done)
 *      b. Set Interface
 *          i. HashSet Class (Time Complexity: O(1)) -> can be used if the elements can be stored in any order
 *          ii. TreeSet Class (Time Complexity: O(log N)) -> can be used if the elements can be stored in sorted order
 *      c. Queue Interface
 *          i. ArrayDeque Class (Done)
 *          ii. LinkedList Class (Done)
 *          iii. PriorityQueue Class (Done)
 * 3. Map Interface
 *      a. HashMap Class (Done) -> use this if we are dealing with key value pairs and order does not matter -> has time complexity of O(1) {put, get and remove, all work in O(1)}
 *      b. TreeMap Class (Done) -> use this if we are dealing with key value pairs in sorted order of keys -> has time complexity of O(log N) {put, get and remove, all work in O(log N)}
 * 4. Iterator
 *      a. ListIterator (Done)
 * 5. Custom Comparators (Done)
 * 6. Common Algorithms (Done)
 *      a. Collections.sort(list) (Done)
 *      b. Collections.max(list) (Done)
 *      c. Collections.min(list) (Done)
 *      d. Collections.reverse(list) (Done)
 *      e. Arrays.sort(array) (Done)
 *      f. Collections.frequency(list, element) (Done)
 *      g. Math.pow(base, exponent) (Done)
 *      h. Collections.binarySearch(list, key) (See afterward)
 */

class Data {
    // for industry, the fields must be private
    // for DSA, we can make it public for online assessments
    // for DSA, use * to import all the packages to avoid writing classes import statements
    private Integer num;
    private String name;

    Data(Integer num, String name) {
        this.num = num;
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public String getName() {
        return name;
    }
}

public class CollectionConcept {
    public static void main(String[] args) {
        // 1. ArrayList
        List<Integer> aList = new ArrayList<>();
        aList.add(10);
        aList.add(20);
        aList.add(30);
        aList.add(40);
        System.out.println(aList);
        System.out.println(aList.size());
        System.out.println(aList.get(2));
        System.out.println(aList.remove(2)); // removes the value from the arrayList and also tells us what value has been removed from that index
        System.out.println(aList);
        aList.add(2, 35); // lot of time complexity when adding at any other index apart from end
        System.out.println(aList);
        System.out.println(aList.contains(2));
        System.out.println("=====================================================================");

        // ArrayList is one ended list. It's values can only be added from the end, while adding at end time complexity is O(1), but while adding in between, there will be a lot of time complexity

        // 2. LinkedList
        // The difference is that in LinkedList, you can add from end also and start also, and also you can add anywhere
        // without multiple changes
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.addFirst(3);
        list.addLast(4);
        System.out.println(list);
        list.removeLast();// removes the last element from the list and returns the same to the user
        System.out.println(list);
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println("=====================================================================");

        // 3. Stack - LIFO
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        System.out.println("=====================================================================");

        // 4. Vector - same as list, but it is Thread-safe. To prevent race conditions (when multiple entities access the data at the same time), Vector helps to overcome the same.
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        System.out.println(vector);
        System.out.println(vector.capacity());
        System.out.println("=====================================================================");

        // 5. HashSet - data structure storing unique elements in random order
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(3);
        System.out.println(hashSet); // typically, hashset does not guarantee that elements are in sorted order
        System.out.println(hashSet.remove(2)); // returns boolean value if the element has been removed successfully.
        System.out.println(hashSet);
        System.out.println("=====================================================================");

        // 6. TreeSet - data structure storing unique elements in sorted order - implements Red-Black Tree Algorithm
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(12);
        treeSet.add(9);
        treeSet.add(1);
        treeSet.add(4);
        System.out.println(treeSet); // treeset will print the values in the sorted order
        System.out.println(treeSet.floor(8)); // this will print the first value which is lesser than or equal to input
        System.out.println(treeSet.ceiling(8)); // this will print the first value which is higher than or equal to input
        System.out.println("=====================================================================");

        // 7. ArrayDeque - implements Queue which is FIFO data structure, ArrayDeque is doubly ended queue
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.offer(1);
        arrayDeque.offer(2);
        arrayDeque.offer(6);
        arrayDeque.offer(9);
        arrayDeque.offer(10);
        System.out.println(arrayDeque);
        System.out.println(arrayDeque.poll()); // this will remove the first entered element
        System.out.println(arrayDeque);
        System.out.println(arrayDeque.peek()); // this will tell the first entered element without removing it
        System.out.println(arrayDeque);
        System.out.println("=====================================================================");

        // 8. PriorityQueue - This implements the Min Heap data structure, stores elements in form of tree data structure
        // whenever you ask for the peek, it will give smallest element
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(1);
        priorityQueue.offer(2);
        priorityQueue.offer(5);
        priorityQueue.offer(0);
        priorityQueue.offer(4);
        System.out.println(priorityQueue);
        priorityQueue.poll(); // this will remove the first entered element
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.peek());
        priorityQueue.poll();
        System.out.println(priorityQueue.peek());
        // iterating elements in priorityQueue

        while(!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.peek());
            priorityQueue.poll();
        }
        System.out.println("=====================================================================");

        // 9. HashMap - Data structure storing the elements in key value pairs - it does not store duplicates
        HashMap<Integer, String> mp = new HashMap<>();
        mp.put(1, "Shivam");
        mp.put(2, "Satyam");
        mp.put(3, "Rohan");
        System.out.println(mp); // hasMap does not necessarily store keys in the sorted order

        System.out.println(mp.get(2));
        System.out.println(mp.size());
        System.out.println(mp.remove(2));
        System.out.println(mp);
        System.out.println(mp.get(4)); // it will return null as this key is itself not there
        System.out.println("=====================================================================");

        // 10. TreeMap - this will store sorted key-value pairs in sorted order of keys - it does not store duplicates
        TreeMap<Integer, String> tmp = new TreeMap<>();
        tmp.put(12, "Shivam");
        tmp.put(1, "Satyam");
        tmp.put(8, "Rohan");
        tmp.put(8, "Raj");
        System.out.println(tmp); // hasMap does not necessarily store keys in the sorted order

        System.out.println(tmp.get(2));
        System.out.println(tmp.size());
        System.out.println(tmp.remove(2));
        System.out.println(tmp);
        System.out.println(tmp.get(4)); // it will return null as this key is itself not there
        System.out.println(tmp.ceilingKey(2)); // this will return the key which is greater or equal to the key
        System.out.println(tmp.floorKey(2)); // this will return the key which is lesser or equal to the key
        System.out.println(tmp.keySet()); // returns the set of keys
        System.out.println("=====================================================================");

        // 11. Iterator
        // Use interface reference and child object as per OOPs concept
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        for (var num : arrayList) {
            System.out.println(num);
        }

        System.out.println("Using Iterator");

        // iterating through a collection in general
        // Iterator is just before first element
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("=====================================================================");

        // 12. Common Algorithms
        List<Integer> ListDs = new ArrayList<>();
        ListDs.add(12);
        ListDs.add(21);
        ListDs.add(3);
        ListDs.add(8);
        System.out.println(ListDs);
        Collections.sort(ListDs); // sorting a collection
        System.out.println(ListDs);

        System.out.println(Collections.max(ListDs)); // returning the max of collection

        Collections.reverse(ListDs); // reversing the collection
        System.out.println(ListDs);

        System.out.println(Collections.frequency(ListDs, 10)); // finding the frequency of a number
        System.out.println("=====================================================================");

        // 13. Comparator
        List<Integer> ListD = new ArrayList<>();
        ListD.add(12);
        ListD.add(21);
        ListD.add(3);
        ListD.add(8);
        System.out.println(ListD);

        // implementing comparator with anonymous class used to sort the numbers in descending order
//        Comparator<Integer> comparator = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if(o1 > o2) {
//                    return -1; // negative number means no change needed in the order
//                } else if (o1 < o2) {
//                    return 1; // positive number means to reverse the order
//                }
//                return 0; // numbers are equal
//            }
//        };

        // implementing comparator with lambda expressions to sort the numbers in descending order
        Comparator<Integer> comparator = (Integer o1, Integer o2) -> {
            if(o1 > o2) {
                return -1; // negative number means no change needed in the order
            } else if (o1 < o2) {
                return 1; // positive number means to reverse the order
            }
            return 0; // numbers are equal
        };

        Collections.sort(ListD, comparator);
        System.out.println(ListD);

    }
}
