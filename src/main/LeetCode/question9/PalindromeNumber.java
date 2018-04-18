package main.LeetCode.question9;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String numbers = String.valueOf(x);
        int i = 0;
        int j = numbers.length() - 1;
        while (i < j) {
            if (numbers.charAt(i) != numbers.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
