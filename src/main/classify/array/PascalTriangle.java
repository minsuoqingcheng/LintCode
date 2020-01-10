package main.classify.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return Collections.emptyList();
        }
        if (numRows == 1) {
            return Collections.singletonList(Collections.singletonList(1));
        }
        if (numRows == 2) {
            return Arrays.asList(Collections.singletonList(1), Arrays.asList(1, 1));
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(Collections.singletonList(1));
        res.add(Arrays.asList(1, 1));
        for (int i = 3; i <= numRows; i++) {
            List<Integer> pre = res.get(i - 2);
            List<Integer> current = new ArrayList<>();
            current.add(1);
            for (int j = 0; j < pre.size() - 1; j++) {
                current.add(pre.get(j)+pre.get(j+1));
            }
            current.add(1);
            res.add(current);
        }
        return res;
    }

}
