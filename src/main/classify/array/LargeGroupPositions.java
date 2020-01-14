package main.classify.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargeGroupPositions {

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        int N = S.length();
        for (int j = 0; j < N; j++) {
            if (j == N - 1 || S.charAt(j) != S.charAt(j+1)) {
                if (j-i+1 >= 3) {
                    res.add(Arrays.asList(i, j));
                }
                i = j + 1;
            }

        }
        return res;
    }


    public static void main(String[] args) {
        LargeGroupPositions test = new LargeGroupPositions();
        System.out.println(test.largeGroupPositions("aaa"));
    }
}
