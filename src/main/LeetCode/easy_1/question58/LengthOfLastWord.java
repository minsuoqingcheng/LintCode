package main.LeetCode.easy_1.question58;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int length = s.length();
        int res = 0;
        boolean last = false;
        for (int i = length-1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && !last) {
                continue;
            }
            if (s.charAt(i) != ' ') {
                res++;
                last = true;
            } else {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LengthOfLastWord test = new LengthOfLastWord();
        int length = test.lengthOfLastWord("Hello ");
        System.out.println(length);
    }

}
