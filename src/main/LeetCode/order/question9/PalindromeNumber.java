package main.LeetCode.order.question9;

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


    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        int origin = x;
        int res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x /10;
        }
        return res == origin;
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        boolean result = palindromeNumber.isPalindrome2(1001);
        System.out.println(result);
    }

}
