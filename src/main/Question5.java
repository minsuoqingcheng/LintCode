package main;

import java.util.PriorityQueue;

/**
 * 设计一个算法：找出数组中第K大元素
 * 关键：将找第K大转换为找第(length-k+1)个最小元素
 * 然后利用快速排序
 *
 * 或者使用PriorityQueue
 */

public class Question5 {

    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    //1058s
    public int kthLargestElement(int k, int[] nums) {
        int length = nums.length;
        k = length - k;
        int low = 0;
        int high = length - 1;
        while (low < high) {
            int j = partition(nums, low, high);
            if (j < k) {
                low = j + 1;
            } else if (j > k) {
                high = j -1;
            } else {
                break;
            }
        }
        return nums[k];

    }


    private int partition(int[] nums, int low, int high) {
        int i = low;
        int j = high + 1;
        while (true) {
            while (i < high && nums[++i] < nums[low]);
            while (j > low && nums[--j] > nums[low]);
            if (i >= j) {
                break;
            }
            exchange(nums, i, j);
        }
        exchange(nums, low, j);
        return j;
    }

    private void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    //1137s
    public int kthLargestElement2(int k, int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }

}
