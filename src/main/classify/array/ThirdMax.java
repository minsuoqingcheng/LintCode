package main.classify.array;

public class ThirdMax {

    public int thirdMax(int[] nums) {
        Integer max = null;
        Integer secondMax = null;
        Integer thirdMax = null;
        for (int num : nums) {
            if (max == null || num > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = num;
                continue;
            }
            if (num != max && (secondMax == null || num > secondMax)) {
                thirdMax = secondMax;
                secondMax = num;
                continue;
            }
            if (num != max && num != secondMax && (thirdMax == null || num > thirdMax)) {
                thirdMax = num;
            }
        }
        return thirdMax == null ? max : thirdMax;
    }


    public static void main(String[] args) {
        ThirdMax test = new ThirdMax();
        System.out.println(test.thirdMax(new int[]{1,2,2,5,3,5}));
    }

}
