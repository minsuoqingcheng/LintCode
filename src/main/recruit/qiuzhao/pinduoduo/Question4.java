package main.recruit.qiuzhao.pinduoduo;

import java.util.Scanner;

public class Question4 {

    private static int result = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] edges = new int[N];
        int[] weights = new int[N];
        for (int i = 0; i < N; i++) {
            edges[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            weights[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            int lastEdge = edges[i];
            int lastWeight = weights[i] * 7;
            boolean[] visited = new boolean[N];
            visited[i] = true;
            int matched = 1;
            searchLeft(N, edges, weights, 1, lastEdge, lastWeight, visited, matched);
        }

        System.out.println(result);
    }


    private static int searchLeft(int N, int[] edges, int[] weights, int index, int lastEdge, int lastWeight, boolean[] visited, int matched) {
        if (index > N) {
            return matched;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                if (edges[i] < lastEdge && weights[i] <= lastWeight) {
                    matched++;
                    visited[i] = true;
                    int newLastEdge = edges[i];
                    int newLastWeight = Math.min(weights[i]*7, lastWeight-weights[i]);
                    int newMatched = searchLeft(N, edges, weights, index++, newLastEdge, newLastWeight, visited, matched);
                    result = Math.max(result, newMatched);
                    visited[i] = false;
                    matched--;
                }
            }
        }

        return matched;
    }
}
