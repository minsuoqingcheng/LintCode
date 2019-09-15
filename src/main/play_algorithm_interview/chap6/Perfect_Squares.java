package main.play_algorithm_interview.chap6;

import java.util.LinkedList;
import java.util.Queue;

public class Perfect_Squares {

    public int numSquares(int n) {

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(n, 0));

        boolean[] visited = new boolean[n+1];
        visited[n] = true;

        while (!queue.isEmpty()) {

            Pair head = queue.poll();
            int num = head.first;
            int step = head.second;

            for (int i = 1; ; i++) {
                int left = num - i * i;
                //已经达到要求
                if (left == 0) {
                    return step + 1;
                }
                if (left < 0) {
                    break;
                }
                if (!visited[left]) {
                    queue.add(new Pair(left, step+1));
                    visited[left] = true;
                }
            }

        }

        return -1;
    }


    static class Pair {

        private int first;
        private int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

    }

}
