package main.classify.array;

public class MaxDistToClosest {

    public int maxDistToClosest(int[] seats) {
        int res = 0;
        int n = seats.length;
        int last = -1;  //上一个出现1的位置
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                res = last < 0 ? i : Math.max(res, (i - last) / 2);
                last = i;
            }
        }
        return Math.max(res, n-last-1); //max是为了解决[1, 0, 0, 0, 0]的情况，这个时候到最后0没有计算
    }

}
