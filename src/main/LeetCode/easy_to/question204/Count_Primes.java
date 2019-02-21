package main.LeetCode.easy_to.question204;

public class Count_Primes {

    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        int ans = 1;
        boolean[] notPrime = new boolean[n];
        int upper = (int) Math.sqrt(n);
        for (int i = 3; i < n; i += 2) {
            if (notPrime[i]) {
                continue;
            }
            ans++;
            if (i > upper) {
                continue;
            }
            for (int j = i * i; j < n; j += 2 * i) {
                notPrime[j] = true;
            }
        }
        return ans;
    }

}
