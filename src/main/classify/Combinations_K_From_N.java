package main.classify;

import java.util.ArrayList;
import java.util.List;

public class Combinations_K_From_N {


    /**
     * 回溯法
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0 || n < k) {
            return new ArrayList<>();
        }
        List<Integer> item = new ArrayList<>();
        dfs(n, k, 1, item, result);
        return result;
    }


    private void dfs(int n, int k, int start, List<Integer> temp, List<List<Integer>> result) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            dfs(n, k , i+1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }




}
