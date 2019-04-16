package main.random.design;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

    private PriorityQueue<Integer> maxQueue, minQueue;

    /** initialize your data structure here. */
    public MedianFinder() {
        maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        minQueue = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxQueue.add(num);
        minQueue.add(maxQueue.poll());
        if (maxQueue.size() < minQueue.size()) {
            maxQueue.add(minQueue.poll());
        }
    }
    
    public double findMedian() {
        if (maxQueue.size() == minQueue.size()) {
            return (maxQueue.peek() + minQueue.peek()) * 0.5;
        } else {
            return maxQueue.peek();
        }
    }


    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(0);
        finder.addNum(0);
        System.out.println(finder.findMedian());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */