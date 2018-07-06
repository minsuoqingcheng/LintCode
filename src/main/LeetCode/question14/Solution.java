package main.LeetCode.question14;

class Solution {

    //这边的关键是prefix，这里指字母的开头要相同
    private String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length()-1);
            }
            i++;
        }
        return pre;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"bcd", "bc"}));    //bc
        System.out.println(solution.longestCommonPrefix(new String[]{"bc", "abc"}));    //""
    }
}