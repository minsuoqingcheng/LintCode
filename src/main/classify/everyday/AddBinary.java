package main.classify.everyday;

public class AddBinary {

    public String addBinary(String a, String b) {
        char carry = '0';

        StringBuilder builder = new StringBuilder();
        int aLength = a.length();
        int bLength = b.length();
        int max = Math.max(aLength, bLength);
        for (int i = 1; i <= max; i++) {
            char a1 =  i <= aLength ? a.charAt(aLength-i) : '0';
            char b1 = i <= bLength ? b.charAt(bLength-i) : '0';
            if (a1 == '1' && b1 == '1') {
                builder.append(carry);
                carry = '1';
            } else if (a1 == '0' && b1 == '0'){
                builder.append(carry);
                carry = '0';
            } else {
                if (carry == '1') {
                    builder.append('0');
                    carry = '1';
                } else {
                    builder.append('1');
                    carry = '0';
                }
            }
        }
        if (carry == '1') {
            builder.append('1');
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary test = new AddBinary();
        System.out.println(test.addBinary("11", "1"));
    }

}
