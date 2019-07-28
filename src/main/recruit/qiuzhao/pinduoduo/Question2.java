package main.recruit.qiuzhao.pinduoduo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Question2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        String[] array = input1.split(" ");
        List<Character> start = new ArrayList<>();
        List<Character> end = new ArrayList<>();
        for (String a : array) {
            start.add(a.charAt(0));
            end.add(a.charAt(a.length()-1));
        }

        start.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1 - o2;
            }
        });

        end.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1-o2;
            }
        });

        boolean result = true;
        for (int i = 0; i < start.size(); i++) {
            if (start.get(i) != end.get(i)) {
                result = false;
                break;
            }
        }

        System.out.println(result);
    }

}
