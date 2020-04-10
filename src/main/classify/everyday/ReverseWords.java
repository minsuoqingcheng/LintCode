package main.classify.everyday;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWords {

    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        //List中持有words数组的引用，reverse()方法会调换其中的顺序
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }


    public String reverseWords2(String s) {
        String arr[] = s.split(" ");
        StringBuilder sb = new StringBuilder("");
        for (int i=arr.length - 1;i>=0;i--){
            if("".equals(arr[i])){
                continue;
            }
            sb.append(arr[i]).append(" ");
        }
        String res = sb.toString();
        if("".equals(res)){
            return res;
        }
        return res.substring(0,res.length()-1);
    }

}
