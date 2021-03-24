package com.yh.recursion;

/**
 * 递归
 *
 * @author : yh
 * @date : 2021/3/24 20:42
 */
public class RecursionTest {

    public static void main(String[] args) {
        test(4);
        //1*2*3
        System.out.println(factorial(3));
    }

    //打印问题
    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n=" + n);
    }

    //阶乘
    public static int factorial(int n) {
        if (n == 1) {
            return 1;

        } else {
            return factorial(n - 1) * n;
        }
    }
}
