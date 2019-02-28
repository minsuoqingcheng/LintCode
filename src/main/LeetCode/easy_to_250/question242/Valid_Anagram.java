package main.LeetCode.easy_to_250.question242;

import java.util.Arrays;

public class Valid_Anagram {

    public boolean isAnagram(String s, String t) {
        char[] s_char = s.toCharArray();
        Arrays.sort(s_char);
        char[] t_char = t.toCharArray();
        Arrays.sort(t_char);
        if (s_char.length != t_char.length) {
            return false;
        }
        for (int i = 0; i < s_char.length; i++) {
            if (s_char[i] != t_char[i]) {
                return false;
            }
        }
        return true;
    }


    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }


    public boolean isAnagram3(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        // standard ascii table has 128 elements.
        int[] map = new int[128];
        for (char c: s.toCharArray()) {
            map[c]++;
        }

        for( char c: t.toCharArray()) {
            if (map[c] == 0) return false;
            else map[c]--;
        }

        return true;
    }

    public static void main(String[] args) {
        Valid_Anagram test = new Valid_Anagram();
        System.out.println(test.isAnagram("a", "b"));
    }

}
