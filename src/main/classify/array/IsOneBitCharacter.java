package main.classify.array;

public class IsOneBitCharacter {

    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        int pre = 0;
        while (i < bits.length) {
            if (bits[i] == 1) {
                i += 2;
                pre = 1;
            } else {
                i++;
                pre = 0;
            }
        }
        return pre == 0;
    }

}
