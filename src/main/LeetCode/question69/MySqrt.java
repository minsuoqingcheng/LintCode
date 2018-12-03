package main.LeetCode.question69;

public class MySqrt {

    public int mySqrt(int x) {
        int low = 0;
        int high = x;
        while (low <= high) {
           int middle = (low + high) >> 1;
           long square = (long) middle * (long) middle;
           if (square == x) {
               return middle;
           } else if (square < x) {
               long temp = (long) (middle + 1)  * (long) (middle + 1);
               if (temp > x) {
                   return middle;
               }
               if (temp == x) {
                   return middle+1;
               }
               low = middle;
           } else {
               long temp = (long) (middle - 1) * (long) (middle - 1);
               if (temp <= x) {
                   return middle-1;
               }
               high = middle;
           }
        }
        return 0;
    }


    public static void main(String[] args) {

        MySqrt test = new MySqrt();
        System.out.println(test.mySqrt(2147395599));
    }

}
