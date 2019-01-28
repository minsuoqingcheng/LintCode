package main.LeetCode.order.question22;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            res.add(str);
            return;
        }
        if (open < max) {
            backtrack(res, str + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(res, str + ")", open , close + 1, max);
        }
    }

}
