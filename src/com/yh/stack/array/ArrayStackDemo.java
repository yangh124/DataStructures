package com.yh.stack.array;

import java.util.Scanner;

/**
 * @author : yh
 * @date : 2021/3/21 20:22
 */
public class ArrayStackDemo {

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("show：显示栈");
            System.out.println("exit：退出程序");
            System.out.println("push：添加数据到栈");
            System.out.println("pop：从栈取数据");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key) {
                case "show":
                    try {
                        arrayStack.list();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int i = scanner.nextInt();
                    try {
                        arrayStack.push(i);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "pop":
                    try {
                        int pop = arrayStack.pop();
                        System.out.println(pop);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
