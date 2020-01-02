package main.classify.array;

public class DuplicateZeros {


    /**
     * 找出可以填充的0的个数，抛弃数组后面的元素
     * 从后往前遍历 arr[i+possibleDup] = arr[i];
     * @param arr
     */
    public void duplicateZeros2(int[] arr) {
        int possibleDup = 0;
        int length = arr.length - 1;


        for (int i = 0; i <= length - possibleDup; i++) {
            /**
             * 特殊情况
             * An example of the edge case is - [8,4,5,0,0,0,0,7].
             * In this array there is space to accommodate the duplicates of first and second occurrences of zero.
             * But we don't have enough space for the duplicate of the third occurrence of zero.
             * Hence when we are copying we need to make sure for the third occurrence we don't copy twice.
             * Result = [8,4,5,0,.0.,0,.0.,0]
             */
            if (arr[i] == 0) {
                if (i == length - possibleDup) {
                    arr[length] = 0;
                    length -= 1;
                    break;
                }
                possibleDup++;
            }
        }


        int last = length - possibleDup;
        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i+possibleDup] = 0;
                possibleDup--;
                arr[i+possibleDup] = 0;
            } else {
                arr[i+possibleDup] = arr[i];
            }
        }

    }

    public void duplicateZeros(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                move(arr, i);
                arr[i+1] = 0;
                i++;

            }
        }

    }

    private void move(int[] arr, int index) {
        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i-1];
        }
    }

}
