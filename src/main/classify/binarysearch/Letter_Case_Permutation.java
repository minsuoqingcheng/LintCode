package main.classify.binarysearch;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Letter_Case_Permutation {


    public List<String> letterCasePermutation(String S) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(S); //add the element to tail
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (!Character.isDigit(c)) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    String ele = queue.poll();//remove the head element
                    char[] chars = ele.toCharArray();
                    //lower
                    chars[i] = Character.toLowerCase(c);
                    queue.offer(new String(chars));
                    //upper
                    chars[i] = Character.toUpperCase(c);
                    queue.offer(new String(chars));
                }
            }
        }
        return new LinkedList<>(queue);
    }



}
