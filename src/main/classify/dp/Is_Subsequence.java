package main.classify.dp;

public class Is_Subsequence {

    public boolean isSubsequence(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if (sLength == 0) {
            return true;
        }

        int indexS = 0;
        int indexT = 0;
        while (indexT < tLength) {
            if (t.charAt(indexT) == s.charAt(indexS)) {
                indexS++;
                if (indexS == sLength) {
                    return true;
                }
            }
            indexT++;
        }

        return false;
    }

}
