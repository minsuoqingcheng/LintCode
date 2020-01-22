package main.classify.array;

/**
 * 先计算出各个元素出现的次数
 * 然后求出最大公共除数，Greatest Common Divisor(GCD)
 */
public class GroupsSizeX {

    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[1000];
        for (int num : deck) {
            count[num]++;
        }
        int g = -1;
        for (int c : count) {
            if (c > 0) {
                if (g == -1) {
                    g = c;
                } else {
                    g = gcd(g, c);
                }
            }
        }
        return g >= 2;
    }


    private int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }



}
