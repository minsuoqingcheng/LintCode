package main.classify.array;

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        int count = 0;
        int length = flowerbed.length;
        while (i < length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) &&
                    (i == flowerbed.length - 1 || flowerbed[i+1] == 0)) {
                flowerbed[i++] = 1;
                count++;
            }
            if (count >= n) {
                return true;
            }
            i++;
        }
        return false;
    }

}
