package main.LeetCode.easy_to_160.question125;

public class Valid_Palindrome {

    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        Valid_Palindrome test = new Valid_Palindrome();
        System.out.println(test.isPalindrome("0P"));
        System.out.println(Character.isLetterOrDigit('0'));
    }

}
