package com.yh.stack.array;

/**
 * 数组栈
 *
 * @author : yh
 * @date : 2021/3/21 20:24
 */
class ArrayStack {

    /**
     * 栈的大小
     */
    private int maxSize;

    /**
     * 数组模拟栈
     */
    private int[] stack;

    /**
     * top表示栈顶
     */
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * 栈是否满了
     *
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 栈是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int val) {
        if (isFull()) {
            throw new RuntimeException("栈满了");
        }
        top++;
        stack[top] = val;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        int val = stack[top];
        top--;
        return val;
    }

    /**
     * 从栈顶开始遍历
     */
    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        for (int i = top; i > -1; i--) {
            System.out.println(i + ":" + stack[i]);
        }
    }
}
