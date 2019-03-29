package main.algorithm;

import java.util.HashMap;
import java.util.Map;

public class BasicRecursion {

    private Map<Integer, Integer> hasSolvedProblem = new HashMap<>();

    /**
     * 最基础的递归，不优化
     * @param n
     * @return
     */
    private int f1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return f1(n-1) + f1(n-2);
    }


    /**
     * 优化后的递归，保存中间变量
     * @param n
     * @return
     */
    private int f2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (hasSolvedProblem.containsKey(n)) {
            return hasSolvedProblem.get(n);
        }
        int ret = f2(n-1) + f2(n-2);
        hasSolvedProblem.put(n, ret);
        return ret;
    }


    /**
     * 非递归实现
     * @param n
     * @return
     */
    private int f3(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int ret = 0;
        int pre = 2;
        int prepre = 1;
        for (int i = 3; i <= n; i++) {
            ret = pre + prepre;
            pre = ret;
            prepre = pre;
        }
        return ret;
    }

}
