package main.classify.simple;

import java.util.LinkedList;
import java.util.List;

public class CreateTargetArray {

    public int[] createTargetArray(int[] nums, int[] index) {
        int length = nums.length;
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            list.add(index[i], nums[i]);
        }

        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
