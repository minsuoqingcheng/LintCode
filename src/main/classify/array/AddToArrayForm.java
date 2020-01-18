package main.classify.array;

import java.util.ArrayList;
import java.util.List;

public class AddToArrayForm {

    public List<Integer> addToArrayForm(int[] A, int K) {
        int carry = 0;
        for (int i = A.length-1; i >= 0; i--) {
            A[i] = A[i] + K % 10 + carry;
            carry = A[i] / 10;
            A[i] = A[i] % 10;
            K = K / 10;
        }
        List<Integer> leftK = new ArrayList<>();
        while (K != 0) {
            int sum = K % 10 + carry;
            carry = sum / 10;
            leftK.add(sum % 10);
            K = K / 10;
        }
        int resLength = Math.max(leftK.size(), A.length) + 1;
        List<Integer> res = new ArrayList<>(resLength);
        if (carry > 0) {
            res.add(carry);
        }
        for (int i = leftK.size() - 1; i >= 0; i--) {
            res.add(leftK.get(i));
        }
        for (int num : A) {
            res.add(num);
        }
        return res;
    }


    public static void main(String[] args) {
        AddToArrayForm test = new AddToArrayForm();
        List<Integer> res = test.addToArrayForm(new int[]{0}, 10000);
        System.out.println(res);
    }
}
