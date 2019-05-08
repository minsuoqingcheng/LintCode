package main.classify.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> element = new ArrayList<>();
        backtrack(lists, element, nums);
        return lists;
    }

    private void backtrack(List<List<Integer>> lists, List<Integer> element, int[] nums) {
        if (element.size() == nums.length) {
            lists.add(new ArrayList<>(element));
        }
        for (int num : nums) {
            if (element.contains(num)) {
                continue;
            }
            element.add(num);
            backtrack(lists, element, nums);
            element.remove(element.size() - 1);
        }
    }

}
