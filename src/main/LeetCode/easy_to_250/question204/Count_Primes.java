package main.LeetCode.easy_to_250.question204;

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


    public int countPrimes0(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
            }
            for (int j = 2; j*i < n; j++) {
                notPrime[j*i] = true;
            }
        }
        return count;
    }

}
