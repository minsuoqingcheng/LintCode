package main.datastruct;

/**
 * 用数组实现循环队列
 *
 * 一、
 * 队列为空的情况是 head == tail
 * 队列满的情况是 (tail + 1) % n == head
 * 会有一个位置无法放置元素
 *
 * 二、
 * 可以再加一个变量size用于记录数组中实际元素的数量
 *
 */
public class CircularQueue {

    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public CircularQueue(int capacity) {
        this.n = capacity;
        items = new String[capacity];
    }

    public boolean enqueue(String element) {
        if ((tail + 1) % n == head) {
            return false;
        }
        items[tail] = element;
        tail = (tail + 1) % n;
        return true;
    }

    public String dequeue(String element) {
        if (head == tail) {
            return null;
        }
        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }
}
