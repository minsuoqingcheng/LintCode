package main.classify.array;

import java.util.Arrays;

public class NumSmallerByFrequency {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordNum = new int[11];
        int[] charCount = new int[26];
        for (String word : words) {
            char[] chars = word.toCharArray();
            for (char c : chars) {
                charCount[c-'a']++;
            }
            fillWordNum(wordNum, charCount);
            Arrays.fill(charCount, 0);
        }
        int length = queries.length;
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            String query = queries[i];
            char[] chars = query.toCharArray();
            for (char c : chars) {
                charCount[c-'a']++;
            }
            int minCount = getMinCount(charCount);
            int total = 0;
            for (int j = minCount + 1; j < 11; j++) {
                if (wordNum[j] != 0) {
                    total += wordNum[j];
                }
            }
            ans[i] = total;
            Arrays.fill(charCount, 0);
        }

        return ans;
    }

    private void fillWordNum(int[] wordNum, int[] c) {
        for (int i = 0; i < 26; i++) {
            if (c[i] != 0) {
                wordNum[c[i]]++;
                break;
            }
        }
    }

    private int getMinCount(int[] c) {
        for (int i = 0; i < 26; i++) {
            if (c[i] != 0) {
                return c[i];
            }
        }
        return 1;
    }


    public static void main(String[] args) {
        NumSmallerByFrequency test = new NumSmallerByFrequency();
        int[] ans = test.numSmallerByFrequency(new String[]{"cbd"}, new String[]{"zaaaz"});
        System.out.println(Arrays.toString(ans));
    }
}
