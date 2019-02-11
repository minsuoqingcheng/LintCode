package main.LeetCode.easy_1.question119;

import java.util.ArrayList;
import java.util.List;

public class Pascal_Triangle_II {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> data = new ArrayList<>(rowIndex+1);
        if (rowIndex == 0) {
            data.add(1);
        }
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> pre = new ArrayList<>(data);
            data.clear();
            data.add(1);
            for (int j = 1; j < i; j++) {
                data.add(pre.get(j-1) + pre.get(j));
            }
            data.add(1);
        }
        return data;
    }


    public static void main(String[] args) {
        Pascal_Triangle_II test = new Pascal_Triangle_II();
        System.out.println(test.getRow(3));
    }

}
