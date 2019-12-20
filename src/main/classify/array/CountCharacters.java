package main.classify.array;

import java.util.Arrays;

public class CountCharacters {

    public int countCharacters(String[] words, String chars) {
        int[] all = new int[26];
        for (char c : chars.toCharArray()) {
            all[c - 'a']++;
        }
        int count = 0;
        for (String word : words) {
            int[] copy = Arrays.copyOf(all, 26);
            char[] array = word.toCharArray();
            int temp = 0;
            for (char c : array) {
                if (copy[c - 'a'] > 0) {
                    copy[c- 'a']--;
                    temp++;
                }
            }
            if (temp == word.length()) {
                count += temp;
            }
        }
        return count;
    }

}
