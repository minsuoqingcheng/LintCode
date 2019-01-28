package main.LeetCode.order.question5;

public class LongestPalindrome {

    public String longestPalindrome(String s) {
        int maxOffset = 0;
        double maxIndex = 0;
        int length;
        if (s == null || (length = s.length()) == 0) {
            return "";
        }
        for (double i = 0.5; i < length; i+=0.5) {
            int offset = halfPalindromeLength(s, i, length);
            if (offset > maxOffset) {
                maxOffset = offset;
                maxIndex = i;
            } else if (offset == maxOffset){
                if (i % 1 == 0) {
                    maxIndex = i;
                }
            }
        }
        int middle = maxIndex % 1 == 0 ? 0 : 1;
        int start = (int)maxIndex - maxOffset + middle;
        int end = (int)maxIndex + maxOffset + 1;
        return s.substring(start, end);
    }

    private int halfPalindromeLength(String s, double index, int length) {
        int sameCount = 0;
        int offset = 0;
        int start;
        int end;
        while ((start = (int)Math.floor(index) - offset) >=0 && (end = (int)Math.ceil(index) + offset) < length) {
            if (s.charAt(start) == s.charAt(end)) {
                offset++;
                if (start == end) {
                    sameCount++;
                }
            } else {
                break;
            }
        }
        return offset - sameCount;
    }


    //solution2, with similar idea
    public String longestPalindrome2(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String s = longestPalindrome.longestPalindrome("ccc");
        System.out.println(s);
    }
}
