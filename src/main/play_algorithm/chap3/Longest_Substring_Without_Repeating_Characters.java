package main.play_algorithm.chap3;

public class Longest_Substring_Without_Repeating_Characters {

    public int lengthOfLongestSubstring(String s) {

        byte[] freq = new byte[256];
        int l = 0, r = -1;      //滑动窗口[l, r]
        int res = 0;

        int length = s.length();

        while (l < length) {

            if (r + 1 < length && freq[s.charAt(r+1)] == 0) {
                r++;
                freq[s.charAt(r)] = 1;
            } else {
                freq[s.charAt(l)] = 0;
                l++;
            }

            res = Math.max(res, r-l+1);

        }

        return res;

    }

}
