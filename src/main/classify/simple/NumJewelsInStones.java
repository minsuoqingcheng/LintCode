package main.classify.simple;

import java.util.HashSet;
import java.util.Set;

public class NumJewelsInStones {

    public int numJewelsInStones(String J, String S) {
        int num = 0;
        char[] chars = J.toCharArray();
        Set<Character> kind = new HashSet<>();
        for (char c : chars) {
            kind.add(c);
        }
        for (char c : S.toCharArray()) {
            if (kind.contains(c)) {
                num++;
            }
        }
        return num;
    }

}
