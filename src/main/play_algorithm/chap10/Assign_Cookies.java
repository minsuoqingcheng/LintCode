package main.play_algorithm.chap10;

import java.util.Arrays;

public class Assign_Cookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int si = s.length - 1;
        int gi = g.length - 1;
        int result = 0;

        while (si >= 0 && gi >= 0) {
            if (s[si] >= g[gi]) {
                result++;
                si--;
                gi--;
            } else {
                gi--;
            }
        }

        return result;
    }

}
