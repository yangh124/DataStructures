package com.yh.queue.circle;

/**
 * @author : yh
 * @date : 2021/3/21 20:23
 */
class CircleArrayQueue {

    /**
     * 数组最大容量
     */
    private int maxSize;

    /**
     * 队列头下标
     * 初始值为0
     */
    private int front;

    /**
     * 队列尾下标+1
     * 初始值为0
     */
    private int rear;

    /**
     * 队列
     */
    private int[] arr;

    public CircleArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        this.arr = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean addQueue(int num) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        arr[rear] = num;
        rear = (rear + 1) % maxSize;
        return true;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    public int getHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }
}
