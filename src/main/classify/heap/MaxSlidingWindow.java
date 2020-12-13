package main.classify.heap;

import java.util.*;

public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {

        List<Integer> temp = new ArrayList<>();

        //存储index
        ArrayDeque<Integer> window = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            if (i >= k && window.peekFirst() <= i-k) {
                window.pollFirst();
            }

            while (!window.isEmpty() && nums[window.peekLast()] <= num) {
                window.pollLast();
            }

            window.addLast(i);

            if (i >= k-1) {
                temp.add(nums[window.peekFirst()]);
            }

        }

        int[] res = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(i);
        }

        return res;
    }

}
