package main.classify.everyday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersect {

    public int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> temp = new ArrayList<>();
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums1) {
            int count = numMap.getOrDefault(num, 0);
            count++;
            numMap.put(num, count);
        }

        for (int num : nums2) {
            Integer count = numMap.get(num);
            if (count != null && count > 0) {
                count--;
                temp.add(num);
                numMap.put(num, count);
            }
        }

        int[] res = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(i);
        }

        return res;
    }

}
