package main.classify.everyday;

public class PatternMatching {

    public boolean patternMatching(String pattern, String value) {
        if (pattern.equals("a") || pattern.equals("b")) {
            return true;
        }
        if (pattern.length() == 0) {
            return value.length() == 0;
        }
        char[] pChars = pattern.toCharArray();
        char[] vChars = value.toCharArray();
        //value为0时，判断pattern是否只有a或者只有b
        if (value.length() == 0) {
            boolean aExist = false;
            boolean bExist = false;
            for (char c : pChars) {
                if (c == 'a') {
                    aExist = true;
                }
                if (c == 'b') {
                    bExist = true;
                }
                if (aExist && bExist) {
                    return false;
                }
            }
            return true;
        }
        //计算pattern中a和b的数量
        int countA = 0;
        int countB = 0;
        for (char c : pChars) {
            if (c == 'a') {
                countA++;
            }
            if (c == 'b') {
                countB++;
            }
        }
        int vLength = value.length();
        //只有a或者b的特殊情况
        if (countA * countB == 0) {
            int count = countA + countB;
            //不能拆分成count个子串，返回false
            if (vLength % count != 0) {
                return false;
            } else {
                //能够拆分，判断每个子串是否相等
                int len = vLength / count;
                for (int i = len; i < vLength; i += len) {
                    //判断每个子串和第0个是否相等
                    if (!stringEquals(vChars, 0, i, len)) {
                        return false;
                    }
                }
                return true;
            }
        }
        //寻找每个可能的字符串长度【从0-vLength】
        for (int i = 0; i <= vLength; i++) {
            //a的个数就不满足，不需要判断了
            if (vLength - countA * i < 0) {
                break;
            }
            int lengthB =(vLength - countA*i) / countB;
            //符合条件的切分方式，判断子串是否符合条件
            if (lengthB * countB + i * countA == vLength) {
                int index = 0;
                //设置pattern a和pattern b要比较的索引
                int[] ab = new int[]{-1, -1};
                boolean notMatch = false;

                //比较逻辑
                for (char c : pChars) {
                    if (c == 'a') {
                        //第一次出现pattern a
                        if (ab[0] == -1) {
                            ab[0] = index;
                        } else {

                            //不是第一次出现
                            if (!stringEquals(vChars, ab[0], index, i)) {
                                notMatch = true;
                                break;
                            }
                        }
                        //index偏移a的长度
                        index += i;
                    } else {
                        if (ab[1] == -1) {
                            ab[1] = index;
                        } else {
                            if (!stringEquals(vChars, ab[1], index, lengthB)) {
                                notMatch = true;
                                break;
                            }
                        }
                        index += lengthB;

                    }
                    // 判断a和b是否相同
                    if (lengthB == i) {
                        if (ab[0] != -1 && ab[1] != -1) {
                            if (stringEquals(vChars, ab[0], ab[1], lengthB)) {
                                notMatch = true;
                                break;
                            }
                        }
                    }
                }

                if (!notMatch) {
                    return true;
                }

            }
        }
        return false;
    }


    private boolean stringEquals(char[] chars, int index1, int index2, int length) {
        for (int i = 0; i < length; i++) {
            if (chars[index1+i] != chars[index2+i]) {
                return false;
            }
        }
        return true;
    }

}
