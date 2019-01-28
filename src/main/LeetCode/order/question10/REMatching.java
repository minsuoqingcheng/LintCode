package main.LeetCode.order.question10;

public class REMatching {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] db = new boolean[s.length()+1][p.length()+1];
        db[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && db[0][i-1]) {
                db[0][i+1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    db[i+1][j+1] = db[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    db[i+1][j+1] = db[i][j];
                }
                /*
                    如果规则字符是'*'，那么对应两种情况
                    1：*前一个字符既不和当前字符相等，也不为.，那么这个字符的匹配结果只能是当前字符与前两个字符匹配的结果相同，即
                        *和前一个规则字符置为空
                    2：第一种的反面情况，则当前结果为db[i+1][j]，*为空；db[i][j+1]，前一个字符为.或相等；db[i+1][j-1] *和前一个规则字符置为空；
                 */
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        db[i+1][j+1] = db[i+1][j-1];
                    } else {
                        db[i+1][j+1] = db[i+1][j] || db[i][j+1] || db[i+1][j-1];
                    }
                }
            }
        }
        return db[s.length()][p.length()];
    }

}
