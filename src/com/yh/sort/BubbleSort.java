package com.yh.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * <p>
 * 时间复杂度 O(n²)
 *
 * @author : yh
 * @date : 2021/4/11 20:21
 */
public class BubbleSort {

    public static void main(String[] args) {
        /*
          为了容易理解，我们将冒泡排序的演变过程，给大家展示
         */
        int[] arr = {3, 9, -1, 10, -2};
        //第一趟排序，就是将最大的数排在最后
        int temp;
        for (int j = 0; j < arr.length - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第一趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        //第二趟排序，就是将倒数第二大的数排在倒数第二个位置
        for (int j = 0; j < arr.length - 1 - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第二趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        //第三趟排序，就是将倒数第三大的数排在倒数第三个位置
        for (int j = 0; j < arr.length - 1 - 1 - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第三趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        //第四趟排序，就是将倒数第四大的数排在倒数第四个位置
        for (int j = 0; j < arr.length - 1 - 1 - 1 - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第四趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        System.out.println("=================冒泡排序=================");
        int[] array = new int[80000];
        for (int i = 0; i < 80000; i++) {
            array[i] = (int) (Math.random() * 8000000);
        }
        long start = System.currentTimeMillis();
        bubbleSort(array);
        long end = System.currentTimeMillis();
        System.out.println("共耗时：" + (end - start) / 1000 + "s");

    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        int len = arr.length;
        int temp;
        boolean flag;
        for (int i = 1; i < len; i++) {
            flag = false;
            for (int j = 0; j < len - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            //如果一次交换都没发生，说明排序完成
            if (!flag) {
                System.out.println("排序提前结束！");
                break;
            }
//            System.out.println("第" + i + "趟排序后的数组");
//            System.out.println(Arrays.toString(arr));
        }
    }
}
