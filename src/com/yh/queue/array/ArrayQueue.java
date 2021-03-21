package com.yh.queue.array;

/**
 * @author : yh
 * @date : 2021/3/21 20:22
 */
class ArrayQueue {

    /**
     * 队列最大容量
     */
    private int maxSize;

    /**
     * 队列头下标
     * 初始值为-1
     */
    private int front;

    /**
     * 队列尾下标
     * 初始值为-1
     */
    private int rear;

    /**
     * 队列
     */
    private int[] arr;

    public ArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        this.arr = new int[maxSize];
        this.front = -1;
        this.rear = -1;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean addQueue(int num) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        rear++;
        arr[rear] = num;
        return true;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    public int getHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }
}
