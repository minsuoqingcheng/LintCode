package main;

/**
 * Created by imccl on 2017/12/23.
 * 设计一个算法，找出只含素因子2，3，5 的第 n 小的数。
 * 关键点：构造对应的数组，2,3,5三个因素。2的一次方，3的一次方，2的平方，5的一次方，各个索引
 * index2: 1    1   2   2   3
 * index3: 0    1   1   1   2
 * index5: 0    0   0   1   5
 * 每一位数乘以2,3,5的情况都要考虑
 */
public class Question4 {

    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        int[] sortedResult = new int[n];
        sortedResult[0] = 1;
        int twoIndex = 0;
        int threeIndex = 0;
        int fiveIndex = 0;
        for (int i = 1; i < n; i++) {
            sortedResult[i] = Math.min(sortedResult[twoIndex]*2, Math.min(sortedResult[threeIndex]*3, sortedResult[fiveIndex]*5));
            if (sortedResult[i] / sortedResult[twoIndex] == 2) {
                twoIndex++;
            }
            if (sortedResult[i] / sortedResult[threeIndex] == 3) {
                threeIndex++;
            }
            if (sortedResult[i] / sortedResult[fiveIndex] == 5) {
                fiveIndex++;
            }
        }
        return sortedResult[n-1];
    }


}
