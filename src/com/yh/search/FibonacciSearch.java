package com.yh.search;

import java.util.Arrays;

/**
 * 斐波那契查找
 *
 * @author : yh
 * @date : 2021/5/15 12:45
 */
public class FibonacciSearch {

    private static final int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println(fibSearch(arr, 1234));
    }

    //非递归方式得到一个斐波那契数列   斐波那契数列中的数相当于数组的下标
    public static int[] fib() {
        int[] f = new int[20];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     * 斐波那契算法（使用非递归方式）
     *
     * @param arr 有序数组
     * @param key 要查找的关键字（元素）
     * @return 下标
     */
    public static int fibSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        //表示斐波那契分割数值的下标
        int k = 0;
        //分割点 mid下标
        int mid;
        int[] f = fib();
        //获取k
        while (arr.length > f[k] - 1) {
            k++;
        }
        //因为 f[k] 的值可能大于 arr 的长度，因此我们需要使用Arrays类，创建一个新数组(扩容)
        //多出的部分默认为0
        int[] temp = Arrays.copyOf(arr, f[k] - 1);
        //将0替换为arr[high]    {1, 8, 10, 89, 1000, 1234, 0, 0} => {1, 8, 10, 89, 1000, 1234, 1234, 1234}
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        //开始查找
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            //向左查找
            if (key < temp[mid]) {
                high = mid - 1;
                /**
                 * 说明
                 * 1. 数组全部元素 = 前面的元素 + 后面的元素 + mid元素
                 * 2. f[k] = f[k-1] + f[K-2]  =>  f[k-1] = f[k-2] + f[K-3]
                 *  即下次循环 mid = f[k-1-1] - 1
                 *
                 */
                k--;
                //向右查找
            } else if (key > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                // 由于数组后面的数据都是最后一个元素填充的，mid可能是那些填充数据的下标，因此需要比较与真实数组长度的大小
                return Math.min(mid, high);
            }
        }
        return -1;
    }
}
