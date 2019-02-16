package main.LeetCode.easy_to.question171;

public class Excel_Sheet_Column_Number {

    public int titleToNumber(String s) {
        int number = 0;
        int base = 26;
        int length = s.length();
        int count = 1;
        for (int i = length - 1; i >= 0; i--) {
            if (i == length - 1) {
                number += s.charAt(i) - 'A' + 1;
            } else {
                number += Math.pow(base, count) * (s.charAt(i) - 'A' + 1);
                count++;
            }
        }
        return number;
    }


    public static void main(String[] args) {
        Excel_Sheet_Column_Number test = new Excel_Sheet_Column_Number();
        System.out.println(test.titleToNumber("AAA"));
    }
}
