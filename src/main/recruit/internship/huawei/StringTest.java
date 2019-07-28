package main.recruit.internship.huawei;

import java.util.*;

public class StringTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        while (in.hasNext()) {
            String temp = in.next();
            input.add(temp);
        }
        List<String> valid = new ArrayList<>();
        List<String> invalid = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            String data = input.get(i);
            data = preHandle(data);
            if (isValid(data)) {
                if (!valid.contains(data)) {
                    valid.add(data);
                }
            } else {
                String convert = handleInvalid(data);
                invalid.add(convert);
            }
        }
        List<String> convertList = new ArrayList<>();
        for (int i = 0; i < valid.size(); i++) {
            String data = valid.get(i);
            System.out.print(data + " ");
            convertList.add(getConvertString(data));
        }
        System.out.println();
        for (int i = 0; i < invalid.size(); i++) {
            System.out.print(invalid.get(i));
        }
        System.out.println();
        for (int i = 0; i < convertList.size(); i++) {
            System.out.print(convertList.get(i) + " ");
        }
        System.out.println();
        convertList.sort(String::compareTo);
        for (int i = 0; i < convertList.size(); i++) {
            System.out.print(convertList.get(i) + " ");
        }
    }

    private static String preHandle(String data) {
        int i = data.length() - 1;
        if (data.charAt(i) != ' ') {
            return data;
        }
        for (; i > 0; i--) {
            if (data.charAt(i) != ' ') {
                break;
            }
        }
        return data.substring(0, i+1);
    }


    private static boolean isValid(String data) {
        for (int i = 0; i < data.length() - 1; i++) {
            char ele = data.charAt(i);
            if (!((ele >= '0' && ele <= '9') || (ele >= 'a' && ele <= 'z') || (ele >= 'A' && ele <= 'Z'))) {
                return false;
            }
        }
        return true;
    }

    private static String handleInvalid(String data) {
        String[] split = data.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (split[i].length() > 0) {
                builder.append(split[i]);
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    private static String getConvertString(String data) {
        int length = data.length();
        if (length > 10) {
            return data.substring(10, data.length()) + data.substring(0, 10);
        } else {
            int index = 10 % length;
            if (index == 0) {
                return data.substring(length-1, length) + data.substring(index, length-1);
            } else {
                return data.substring(index, length) + data.substring(0, index);
            }

        }
    }



}


//    public static void main(String[] args) {
//        String result = getConvertString("abc");
//        System.out.println(result);
//
//        List<String> test = new ArrayList<>();
//        test.add("1234555");
//        test.add("2344");
//        test.add("BCA");
//        test.sort(String::compareTo);
//        System.out.println(test);
//    }
