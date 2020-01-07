package main.classify.array;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans.add(i+1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindDisappearedNumbers test = new FindDisappearedNumbers();
        System.out.println(test.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }
}
