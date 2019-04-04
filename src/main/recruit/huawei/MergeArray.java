package main.recruit.huawei;

import java.util.*;

public class MergeArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        List<List<String>> input = new ArrayList<>();
        Map<Integer, Integer> records = new HashMap<>();
        int index = 0;
        while (in.hasNext()) {
            String input1 = in.next();
            String[] array1 = input1.split(",");
            List<String> arr1List = Arrays.asList(array1);
            input.add(arr1List);
            records.put(index, 0);
            index++;
        }
        int total = input.size();
        int complete = 0;
        List<String> result = new ArrayList<>();
        while (complete < total) {
            for (int i = 0; i < total; i++) {
                int record = records.get(i);
                if (record >= input.size()) {
                    continue;
                }
                List<String> data = input.get(i);
                int end = record + length;
                if (end <= data.size()) {
                    result.addAll(data.subList(record, end));
                } else {
                    result.addAll(data.subList(record, data.size()));
                }
                if (end >= data.size()) {
                    complete++;
                }
                records.put(i, end);
            }
        }

        for (int k = 0; k < result.size(); k++) {
            if (k != result.size() - 1) {
                System.out.print(result.get(k) + ",");
            } else {
                System.out.print(result.get(k));
            }
        }
    }

    //2,5,6,7,1,7,4,3,9,5,7,4
    //2,5,6,7,1,7,4,3,9,5,7,4

    //2,5,6,1,7,4,7,9,5,3,4,7
    //2,5,6,1,7,4,7,9,5,3,4,7
}
