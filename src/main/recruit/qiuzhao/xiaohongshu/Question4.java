package main.recruit.qiuzhao.xiaohongshu;

import java.util.*;

public class Question4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseCount = scanner.nextInt();
        int[] xs = new int[caseCount];
        int[] hs = new int[caseCount];
        int[] sum = new int[caseCount];
        for (int i = 0; i < caseCount; i++) {
            xs[i] = scanner.nextInt();
            hs[i] = scanner.nextInt();
            sum[i] = xs[i] + hs[i];
        }
        Set<Integer> sell = new HashSet<>();
        for (int i = 0; i < caseCount; i++) {
            sell.add(sum[i]);
        }
        System.out.println(sell.size());
    }

}
