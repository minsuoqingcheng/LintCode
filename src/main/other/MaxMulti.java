package main.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxMulti {

    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());  //小朋友的人数
        String[] str1 = bf.readLine().split(" ");
        int[] child = new int[n];
        for (int i = 0; i < n; i++) {
            child[i] = Integer.parseInt(str1[i]);
        }
        int m = Integer.parseInt(bf.readLine());  //巧克力的个数
        String[] str2 = bf.readLine().split(" ");
        int[] cho = new int[m];
        for (int j = 0; j < m; j++) {
            cho[j] = Integer.parseInt(str2[j]);
        }
        System.out.println(maxChild(n, child, m, cho));

    }


        private static int maxChild(int n, int[] h, int m, int[] w){
            if (n == 0 || m == 0)
                return 0;
            Arrays.sort(h);
            Arrays.sort(w);
            int max = 0;
            int i = 0;  //指向小朋友
            int j = 0;  //指向巧克力
            while (i < n && j < m) {
                if (w[j] >= h[i]) {
                    max++;
                    i++;
                }
                j++;
            }
            return max;
        }


}
