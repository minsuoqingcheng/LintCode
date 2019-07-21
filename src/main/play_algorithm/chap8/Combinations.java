package main.play_algorithm.chap8;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || k > n) {
            return res;
        }
        generate(n, k, 1, new ArrayList<>());
        return res;
    }

    private void generate(int n, int k, int start, List<Integer> combination) {
        if (combination.size() == k) {
            res.add(new ArrayList<>(combination));
            return;
        }

        //优化，继续遍历也无法找到满足条件的数组，剪枝
        for (int i = start; i <= (n - (k-combination.size()))+1; i++) {
            combination.add(i);
            generate(n, k, i+1, combination);
            combination.remove(combination.size()-1);
        }
    }

}
