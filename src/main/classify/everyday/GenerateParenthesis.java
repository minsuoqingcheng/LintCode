package main.classify.everyday;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    /**
     * 先加左括号，然后加右括号
     * @param left
     * @param right
     * @param curStr
     */
    private void dfs(int left, int right, String curStr) {
        if (left == 0 && right == 0) { // 左右括号都不剩余了，递归终止
            res.add(curStr);
            return;
        }

        if (left > 0) { // 如果左括号还剩余的话，可以拼接左括号
            dfs(left - 1, right, curStr + "(");
        }
        if (right > left) { // 如果右括号剩余多于左括号剩余的话，可以拼接右括号，右括号等于左括号就不可以
            dfs(left, right - 1, curStr + ")");
        }
    }


    public static void main(String[] args) {
        GenerateParenthesis test = new GenerateParenthesis();
        System.out.println(test.generateParenthesis(3));
    }
}
