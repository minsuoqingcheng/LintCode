package main.LeetCode.question10;

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
