package main.LeetCode.easy_to_250.question205;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic_Strings {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            Character sPrevious = s2t.get(sc);
            if (sPrevious == null) {
                s2t.put(sc, tc);
            } else {
                if (sPrevious != tc) {
                    return false;
                }
            }
            Character tPrevious = t2s.get(tc);
            if (tPrevious == null) {
                t2s.put(tc, sc);
            } else {
                if (tPrevious != sc) {
                    return false;
                }
            }
        }
        return true;
    }



    public boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sMark = new int[256];
        int[] tMark = new int[256];
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (sMark[sArray[i]] != tMark[tArray[i]]) {
                return false;
            }
            sMark[sArray[i]] = i + 1;
            tMark[tArray[i]] = i + 1;
        }
        return true;
    }


}
