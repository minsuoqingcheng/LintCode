package main.recruit.bytedance;

import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int count = scanner.nextInt();
            int[] scores = new int[count];
            for (int j = 0; j < count; j++) {
                scores[j] = scanner.nextInt();
            }
            System.out.println(getMinAwards(scores));
        }
    }

    private static int getMinAwards(int[] scores) {
        if (scores.length == 1) {
            return 1;
        }
        int min = 0;
        int minIndex = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
                minIndex = i;
                break;
            }
        }
        int length = scores.length;
        int totalAwards = 1;
        int lastForwardAwards = 1;
        int lastBackwardAwards = 1;
        int lastForwardScore = min;
        int lastBackWardScore = min;
        int i = 1;
        while (true) {
            int forward = minIndex + i;
            forward = forward >= length ? (forward - length) : forward;
            int backward = minIndex - i;
            backward = backward >= 0 ? backward : (length + backward);
            if (backward == forward) {
                //相等
                int score = scores[forward];
                if (score > lastForwardAwards) {
                    lastForwardAwards += 1;
                }
                totalAwards += lastForwardAwards;
                break;
            } else {
                int forwardScore = scores[forward];
                int backwardScore = scores[backward];
                if (backwardScore > lastBackWardScore) {
                    lastBackwardAwards += 1;
                    lastBackWardScore = backwardScore;
                }
                if (forwardScore > lastForwardScore) {
                    lastForwardScore = forwardScore;
                    lastForwardAwards += 1;
                }
                totalAwards += lastBackwardAwards;
                totalAwards += lastForwardAwards;
            }
            i++;
        }
        return totalAwards;
    }

}
