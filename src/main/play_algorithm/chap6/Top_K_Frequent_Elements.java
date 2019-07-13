package main.play_algorithm.chap6;

import java.util.*;

public class Top_K_Frequent_Elements {

    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> num2count = new HashMap<>();
        //遍历数组得到计数
        for (int i = 0; i < nums.length; i++) {
            int count = num2count.getOrDefault(nums[i], 0);
            count++;
            num2count.put(nums[i], count);
        }
        //最小堆
        PriorityQueue<Pair> minCount = new PriorityQueue<>(k, Comparator.comparing(Pair::getFirst));
        for (Map.Entry<Integer, Integer> entry : num2count.entrySet()) {
            Pair data = new Pair(entry.getValue(), entry.getKey());
            if (minCount.size() == k) {
                int count = minCount.peek().getFirst();
                if (data.getFirst() > count) {
                    minCount.poll();
                    minCount.add(data);
                }
            } else if (minCount.size() < k) {
                minCount.add(data);
            }
        }
        //取出元素
        List<Integer> result = new ArrayList<>(k);
        while (!minCount.isEmpty()) {
            int element = minCount.poll().getSecond();
            result.add(element);
        }
        return result;
    }


    static class Pair {

        private int first;
        private int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public void setFirst(int first) {
            this.first = first;
        }

        public int getSecond() {
            return second;
        }

        public void setSecond(int second) {
            this.second = second;
        }
    }

    //[]
    //2
    public static void main(String[] args) {
        Top_K_Frequent_Elements test = new Top_K_Frequent_Elements();
        System.out.println(test.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2));
    }
}
