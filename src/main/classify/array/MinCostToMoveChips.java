package main.classify.array;

/**
 * 题目意思：数组中有若干个元素，需要将这些元素移动到同一个位置
 * 移动规则：向左向右移动两个位置消耗0；向左向右移动一个位置消耗1
 * 求出将这些元素移动到同一个位置最小消耗
 *
 * 偶数位置的元素全部移动到0，消耗0
 * 奇数位置的元素全部移动到1，消耗0
 * 找出元素最少的 移动到元素多的位置
 */
public class MinCostToMoveChips {

    public int minCostToMoveChips(int[] chips) {
        int oddNum = 0;
        int evenNum = 0;
        for (int chip : chips) {
            if (chip % 2 == 0) {
                evenNum++;
            } else {
                oddNum++;
            }
        }
        return Math.min(oddNum, evenNum);
    }

}
