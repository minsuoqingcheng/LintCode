package main.LeetCode.question13;

public class RomanToInt {

    public int romanToInt(String s) {
        char[] arrays = s.toCharArray();
        char lastChar = 0;
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            boolean isSubtraction = isSubtraction(lastChar, arrays[i]);
            if (isSubtraction) {
                sum -= toNumber(arrays[i]);
            } else {
                sum += toNumber(arrays[i]);
            }
            lastChar = arrays[i];
        }
        return sum;
    }

    private boolean isSubtraction(char lastChar, char currentChar) {
        return ((lastChar == 'V' || lastChar == 'X') && currentChar == 'I')
                || ((lastChar == 'L' || lastChar == 'C') && currentChar == 'X')
                || ((lastChar == 'D' || lastChar == 'M') && currentChar == 'C');
    }

    private int toNumber(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new IllegalArgumentException("Incorrect character");
        }
    }

}
