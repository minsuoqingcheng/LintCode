package main.play_algorithm_interview.chap8;

import java.util.ArrayList;
import java.util.List;

public class Letter_Combinations_of_PN {

    private List<String> result = new ArrayList<>();

    private String[] map = new String[]{
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        if ("".equals(digits) || digits == null) {
            return result;
        }
        findCombinations(digits, 0, "");
        return result;
    }

    private void findCombinations(String digits, int index, String combination) {
        if (index == digits.length()) {
            result.add(combination);
            return;
        }

        int digit = digits.charAt(index) - '0';
        String letters = map[digit];
        for (int i = 0; i < letters.length(); i++) {
            findCombinations(digits, index+1, combination+letters.charAt(i));
        }
    }

}
