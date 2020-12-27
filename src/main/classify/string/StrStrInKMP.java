package main.classify.string;

public class StrStrInKMP {

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }

        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();

        int haLength = haystack.length();
        int needleLength = needle.length();

        return kmp(haystackArray, haLength, needleArray, needleLength);
    }

    private int kmp(char[] haystackArray, int haLength, char[] needleArray, int needleLength) {
        int[] next = next(needleArray, needleLength);
        int j = 0;
        for (int i = 0; i < haLength; i++) {
            while (j > 0 && haystackArray[i] != needleArray[j]) {
                j = next[j-1] + 1;
                if (needleLength - j + i > haLength) {
                    return -1;
                }
            }
            if (haystackArray[i] == needleArray[j]) {
                j++;
            }
            if (j == needleLength) {
                return i - needleLength + 1;
            }
        }
        return -1;
    }


    private int[] next(char[] needleArray, int needleLength) {
        int[] next = new int[needleLength];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < needleLength; i++) {
            while (k!=-1 && needleArray[k+1] != needleArray[i]) {
                k = next[k];
            }
            if (needleArray[k+1] == needleArray[i]) {
                k++;
            }
            next[i] = k;
        }
        return next;
    }

    public static void main(String[] args) {
        StrStrInKMP test = new StrStrInKMP();
        System.out.println(test.strStr("mississippi", "issip"));
    }
}
