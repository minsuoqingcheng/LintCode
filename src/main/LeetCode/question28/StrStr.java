package main.LeetCode.question28;

public class StrStr {

    public int strStr(String haystack, String needle) {
        int len = needle.length();
        if(len == 0) return 0;
        for(int i = 0; i<=haystack.length()-len; i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                int cnt = 1;
                for(int j = 1; j<len; j++){
                    if(haystack.charAt(i+j)!=needle.charAt(j)){
                        break;
                    }
                    cnt++;
                }
                if(cnt == len) return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        System.out.println(strStr.strStr("mississippi", "issipi"));
    }

}
