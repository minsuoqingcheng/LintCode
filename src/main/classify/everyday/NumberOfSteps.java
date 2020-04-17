package main.classify.everyday;

public class NumberOfSteps {

    public int numberOfSteps (int num) {
        int count = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num--;
            }
            count++;
        }
        return count;
    }

}
