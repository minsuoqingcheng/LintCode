package main.classify.array;

import java.util.*;

public class FindShortestSubArray {

    public int findShortestSubArray(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Map<Integer, List<Integer>> numIndexes = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<Integer> indexes = numIndexes.getOrDefault(num, new ArrayList<>());
            indexes.add(i);
            numIndexes.put(num, indexes);
        }
        int degree = 0;
        int interval = Integer.MAX_VALUE;
        List<List<Integer>> indexesList = new ArrayList<>(numIndexes.values());
        for (List<Integer> indexes : indexesList) {
            int size = indexes.size();
            if (size > degree) {
                interval = indexes.get(indexes.size()-1) - indexes.get(0) + 1;
                degree = size;
            } else if (size == degree) {
                int temp = indexes.get(indexes.size()-1) - indexes.get(0) + 1;
                if (temp < interval) {
                    interval = temp;
                }
            }
        }
        return interval;
    }


    public static void main(String[] args) {
        FindShortestSubArray test = new FindShortestSubArray();
        int res = test.findShortestSubArray(new int[]{1,2,2,3,1,4,2});
        System.out.println(res);
    }

}
