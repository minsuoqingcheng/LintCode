package main.LeetCode.order.question6;

public class ZigZagConversion {

    public String convert(String s, int numRows) {
        int length = s.length();
        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            builders[i] = new StringBuilder();
        }
        int i = 0;
        while (i < length) {
            for (int index = 0; index < numRows && i < length; index++) {
                builders[index].append(s.charAt(i++));
            }
            for (int index = numRows - 2; index >= 1 && i < length; index--) {
                builders[index].append(s.charAt(i++));
            }
        }
        for (int j = 1; j < numRows; j++) {
            builders[0].append(builders[j]);
        }
        return builders[0].toString();
    }


    public static void main(String[] args) {
        ZigZagConversion conversion = new ZigZagConversion();
        String result = conversion.convert("PAYPALISHIRING", 3);
        System.out.println(result);
    }

}
