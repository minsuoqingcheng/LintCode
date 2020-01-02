package main.classify.array;

public class FindSpecialInteger {

    /**
     * 更好地解答：
     * 只有一个元素的出现次数大于25%，且数组排过序
     * 所以该元素出现的跨度大于25%，
     * int amountRequired = arr.length / 4;
     * arr[i] == arr[i + amountRequired]
     * @param arr
     * @return
     */
    public int findSpecialInteger2(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int amountRequired = arr.length / 4;
        if (arr.length % 4 != 0) {
            amountRequired++;
        }
        for (int i = 0; i + amountRequired < arr.length; i++) {
            if (arr[i] == arr[i + amountRequired]) {
                return arr[i];
            }
        }
        return -1;
    }

    public int findSpecialInteger(int[] arr) {
        int length = arr.length;
        if (length <= 2) {
            return arr[0];
        }
        int maxTimes = -1;
        int result = -1;
        int temp = 1;
        for (int i = 0; i < length - 1; i++) {
            if (arr[i+1] == arr[i]) {
                temp++;
                if (i+1 == length-1) {
                    maxTimes = temp;
                    result = arr[i];
                    temp = 1;
                }
            } else {
                if (temp > maxTimes) {
                    maxTimes = temp;
                    result = arr[i];
                    temp = 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindSpecialInteger findSpecialInteger = new FindSpecialInteger();
        System.out.println(findSpecialInteger.findSpecialInteger(new int[]{1, 2, 3, 3}));
    }
}
