package main.recruit.qiuzhao.sina;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution {

    private HashMap<Integer, Integer> cache = new HashMap<>();
    private int capacity;
    private int size;
    private LinkedList<Integer> keys = new LinkedList<>();

    public Solution(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        Integer value = cache.get(key);
        if (value == null) {
            return -1;
        } else {
            int originIndex = keys.indexOf(key);
            keys.remove(originIndex);
            keys.addLast(key);
        }
        return value;
    }

    public void put(int key, int value) {
        if (size < capacity) {
            keys.addLast(key);
            size++;
        } else {
            Integer removedKey = keys.removeFirst();
            cache.remove(removedKey);
            keys.remove(removedKey);
            keys.addLast(key);
        }
        cache.put(key, value);
    }


    public static void main(String[] args) {
        Solution solution = new Solution(2);
        solution.put(1, 1);
        solution.put(2, 2);
        System.out.println(solution.get(1));
        solution.put(3, 3);
        System.out.println(solution.get(2));
        solution.put(4, 4);
        System.out.println(solution.get(1));
        System.out.println(solution.get(3));
        System.out.println(solution.get(4));
    }
}