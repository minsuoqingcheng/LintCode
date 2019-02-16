package main.LeetCode.easy_to_160.question118;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pascal_Triangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        res.add(Collections.singletonList(1));
        for (int row = 1; row < numRows; row++) {
            List<Integer> current = new ArrayList<>();
            List<Integer> pre = res.get(row-1);
            current.add(1);
            for (int i = 1; i < row; i++) {
                current.add(pre.get(i-1) + pre.get(i));
            }
            current.add(1);
            res.add(current);
        }
        return res;
    }

}
