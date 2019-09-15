package main.play_algorithm_interview.chap8;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return res;
        }
        boolean[] flags = new boolean[nums.length];
        generate(nums, new ArrayList<>(), flags);
        return res;
    }


    private void generate(int[] nums, List<Integer> permutation, boolean[] flags) {
        if (permutation.size() == nums.length) {
            res.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!flags[i]) {
                permutation.add(nums[i]);
                flags[i] = true;
                generate(nums, permutation, flags);
                permutation.remove(permutation.size()-1);
                flags[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        System.out.println(permutations.permute(new int[]{1, 2, 3}));
    }

}
