package com.yh.stack.calculator;

/**
 * 计算器栈
 *
 * @author : yh
 * @date : 2021/3/21 20:24
 */
class CalArrayStack {

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

    public CalArrayStack(int maxSize) {
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

    public int peek() {
        return stack[top];
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

    //返回运算符的优先级
    //数字越大，优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public boolean isOper(char val) {
        return val == '*' || val == '/' || val == '+' || val == '-';
    }

    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                //注意顺序
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                //注意顺序
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}

