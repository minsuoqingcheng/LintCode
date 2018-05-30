package main.LeetCode.question12;

public class IntToRoman {

    public String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0) {
            while (num - values[i] >= 0) {
                sb.append(strs[i]);
                num = num - values[i];
            }
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IntToRoman intToRoman = new IntToRoman();
        String roman = intToRoman.intToRoman(37);
        System.out.println(roman);
    }

}
