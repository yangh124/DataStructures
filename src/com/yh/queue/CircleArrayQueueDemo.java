package com.yh.queue;

import java.util.Scanner;

/**
 * @author : yh
 * @date : 2021/3/15 15:24
 */
public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        CircleArrayQueue arrayQueue = new CircleArrayQueue(4);//实际最多存3个  预留一个空位（位置不固定）
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列取数据");
            System.out.println("h(head)：查看队列头数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    try {
                        arrayQueue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    try {
                        int i = scanner.nextInt();
                        arrayQueue.addQueue(i);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int head = arrayQueue.getHead();
                        System.out.printf("查询出的数据是%d\n", head);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

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