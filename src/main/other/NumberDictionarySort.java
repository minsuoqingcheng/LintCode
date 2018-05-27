package main.other;

public class NumberDictionarySort {


    private static int[] findNearestNumber(int[] numbers) {
        //找到逆序区的前一位
        int index = findTransferPoint(numbers);
        if (index == 0) {
            return numbers;
        }
        //把逆序区域的前一位和逆序区域中刚刚大于它的数字交换位置
        exchangeHead(numbers, index);
        //将交换后的可逆区排序翻转，之前是降序，改为升序
        reverseArea(numbers, index);
        return numbers;
    }


    private static int findTransferPoint(int[] numbers) {
        for (int i = numbers.length - 1; i > 0 ; i--) {
            if (numbers[i] > numbers[i-1]) {
                return i;
            }
        }
        return 0;
    }

    private static void exchangeHead(int[] numbers, int index) {
        int head = numbers[index-1];
        int exchangeIndex = 0;
        int temp = numbers[index];
        for (int i = index; i < numbers.length; i++) {
            if (numbers[i] > head && numbers[i] <= temp) {
                temp = numbers[i];
                exchangeIndex = i;
            }
        }
        numbers[exchangeIndex] = head;
        numbers[index-1] = temp;
    }


    private static void reverseArea(int[] numbers, int index) {
        for (int i = index, j = numbers.length - 1; i < j; i++, j--) {
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
    }

    private static void printArray(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number);
        }
        System.out.println(sb.toString());
    }


    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 2};
        printArray(numbers);
        int[] result = findNearestNumber(numbers);
        assert result != null;
        printArray(result);
    }
}
