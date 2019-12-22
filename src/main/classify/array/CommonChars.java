package main.classify.array;

import java.util.ArrayList;
import java.util.List;

public class CommonChars {

    public List<String> commonChars(String[] A) {
        if (A.length == 1) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        String first = A[0];
        int[] firstCount = new int[26];
        for (char c : first.toCharArray()) {
            firstCount[c-'a']++;
        }
        for (int i = 1; i < A.length; i++) {
            String compare = A[i];
            int[] compareCount = new int[26];
            for (char c : compare.toCharArray()) {
                compareCount[c-'a']++;
            }
            for (int j = 0; j < 26; j++) {
                firstCount[j] = Math.min(firstCount[j], compareCount[j]);
            }
        }
        for (int i = 0; i < 26; i++) {
            int count = firstCount[i];
            while (count > 0) {
                result.add(String.valueOf((char)('a'+i)));
                count--;
            }
        }
        return result;
    }

}
