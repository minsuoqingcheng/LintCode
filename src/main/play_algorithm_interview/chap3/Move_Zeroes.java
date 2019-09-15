package main.play_algorithm_interview.chap3;

import java.util.ArrayList;
import java.util.List;

public class Move_Zeroes {

    public void moveZeroes(int[] nums) {

        List<Integer> unZero = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                unZero.add(nums[i]);
            }
        }
        for (int i = 0; i < unZero.size(); i++) {
            nums[i] = unZero.get(i);
        }

        for (int i = unZero.size(); i < nums.length; i++) {
            nums[i] = 0;
        }

    }


    public void moveZeroes2(int[] nums) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


    public void moveZeroes3(int[] nums) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != k) {
                    swap(nums, i, k);
                }
                k++;
            }
        }
    }

    private void swap(int[] nums, int i, int k) {
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }

}
