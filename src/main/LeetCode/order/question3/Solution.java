package main.LeetCode.order.question3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));     //这边先将第0个元素添加进去，在将j加一
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);  //这边会与原来的i比较，因为i可能因为某一元素而移动，前面还有重复的元素，这时候i不应该移动，而是更新map
                                                        //a b c b,  a b b a
//                //代码等价于
//                if (map.get(s.charAt(j)) > i) {
//                    i = map.get(s.charAt(j)) + 1; //这时候put元素时不应该加1
//                }
            }
            map.put(s.charAt(j), j + 1);     //利用map的特性，相同的字符位置会被替换
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

    //将第二种方法的map转化成数组
    int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

}
