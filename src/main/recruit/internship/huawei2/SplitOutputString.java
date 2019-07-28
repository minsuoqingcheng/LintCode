package main.recruit.internship.huawei2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SplitOutputString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] data = input.split(" ");
        List<String> result = new ArrayList<>();
        for (int i = 1; i < data.length; i++) {
            String s = data[i];
            result.addAll(parseString(s));
        }
        result.sort(String::compareTo);
        for (int i = 0; i < result.size(); i++) {
            if (i != result.size() - 1) {
                System.out.print(result.get(i) + " ");
            } else {
                System.out.print(result.get(i));
            }
        }
    }


    private static List<String> parseString(String s) {
        if (s.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        int add = 8 - s.length() % 8;
        int i = 8;
        while (i < s.length()) {
            String split = s.substring(i-8, i);
            i += 8;
            result.add(split);
        }
        StringBuilder last = new StringBuilder(s.substring(i - 8, s.length()));
        for (int j = 0; j < add; j++) {
            last.append("0");
        }
        result.add(last.toString());
        return result;
    }


}
