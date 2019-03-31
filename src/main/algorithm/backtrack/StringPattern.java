package main.algorithm.backtrack;

public class StringPattern {

    private boolean matched;
    private char[] pattern;     //正则表达式
    private int plen;           //正则表达式的长度


    public StringPattern(char[] pattern, int plen) {
        this.pattern = pattern;
        this.plen = plen;
    }


    /**
     *
     * @param text 要匹配的文本
     * @param tlen 文本的长度
     * @return
     */
    public boolean match(char[] text, int tlen) {
        rematch(0, 0, text, tlen);
        return matched;
    }


    /**
     *
     * @param ti 文本匹配到的位置
     * @param pj 正则表达式匹配到的文职
     * @param text 文本
     * @param tlen 文本长度
     */
    private void rematch(int ti, int pj, char[] text, int tlen) {
        if (matched) {
            return;
        }
        if (pj == plen) {
            if (ti == tlen) {
                matched = true;
            }
            return;
        }
        if (pattern[pj] == '*') {   //匹配任意个字符
            for (int i = 0; i <= tlen - ti; i++) {
                rematch(ti+i, pj+1, text, tlen);
            }
        } else if (pattern[pj] == '?') {    //匹配0-1个字符
            rematch(ti, pj+1, text, tlen);
            rematch(ti+1, pj+1, text, tlen);
        } else if (ti < tlen && pattern[pj] == text[ti]) {      //纯字符匹配
            rematch(ti+1, pj+1, text, tlen);
        }
    }
}
