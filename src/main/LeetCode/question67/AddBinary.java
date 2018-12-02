package main.LeetCode.question67;

public class AddBinary {


    public String goodSolution(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        int length = Math.max(a.length(), b.length());
        char[] arr = new char[length];

        while(length > 0){
            int val1 = (i < 0) ? 0 : a.charAt(i--) - '0';
            int val2 = (j < 0) ? 0 : b.charAt(j--) - '0';

            arr[--length] = (char)('0' + (val1 + val2 + carry) % 2);
            carry = (val1 + val2 + carry) / 2;
        }

        String newString = new String(arr);
        if(carry == 1)
            newString = "1" + newString;

        return newString;
    }


    public String addBinary(String a, String b) {
        char[] achar = a.toCharArray();
        int alength = achar.length;
        char[] bchar = b.toCharArray();
        int blength = bchar.length;
        char[] larger;
        char[] smaller;
        if (alength >= blength) {
            larger = achar;
            smaller = bchar;
        } else {
            larger = bchar;
            smaller = achar;
        }
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        int smallerLength = smaller.length;
        int largerLength = larger.length;
        for (int i = smallerLength-1; i >= 0; i--) {
            int snumber = smaller[i]-48;
            int lnumber = larger[largerLength-1-(smallerLength-1-i)]-48;
            int plusRes = snumber + lnumber + carry;
            carry = plusWithCarry(builder, plusRes);
        }
        for (int i = largerLength - smallerLength - 1; i >=0 ; i--) {
            int lnumber = larger[i] - 48;
            int plusRes = lnumber + carry;
            carry = plusWithCarry(builder, plusRes);
        }
        if (carry == 1) {
            builder.append(1);
        }
        return builder.reverse().toString();
    }


    private int plusWithCarry(StringBuilder builder, int plusRes) {
        int carry;
        if (plusRes < 2) {
           builder.append(plusRes);
           carry = 0;
        } else  {
            builder.append(plusRes-2);  //可能结果为3
            carry = 1;
        }
        return carry;
    }


    public static void main(String[] args) {
        AddBinary test = new AddBinary();
        System.out.println(test.addBinary("100", "110010"));
    }

}
