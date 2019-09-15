package main.play_algorithm_interview.chap4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersection_of_Two_Arrays_II {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> first = new HashMap<>();
        for (int num : nums1) {
            int value = first.getOrDefault(num, 0);
            value++;
            first.put(num, value);
        }

        List<Integer> temp = new ArrayList<>();
        for (int num : nums2) {
            int value = first.getOrDefault(num, 0);
            if (value > 0) {
                temp.add(num);
                value--;
                first.put(num, value);
            }
        }

        int[] res = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(i);
        }

        return res;
    }

}
