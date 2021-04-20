package com.yh.sort;

import java.util.Arrays;

/**
 * 希尔排序
 *
 * @author : yh
 * @date : 2021/4/20 20:36
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        /*
            演变过程
        */
        int temp;
        //第一轮 将10个数据分为5(10/2)组
        for (int i = 5; i < arr.length; i++) {
            for (int j = i - 5; j >= 0; j -= 5) {
                //第一个数和第6个数比较 交换位置
                if (arr[j] > arr[j + 5]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }
        System.out.println("第1轮排序后");
        System.out.println(Arrays.toString(arr));
        //第二轮  将10个数据分为2(5/2)组
        for (int i = 2; i < arr.length; i++) {
            for (int j = i - 2; j >= 0; j -= 2) {
                //第一个数和第6个数比较 交换位置
                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }
        System.out.println("第2轮排序后");
        System.out.println(Arrays.toString(arr));
        //第三轮  将10个数据分为1(2/2)组
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j -= 1) {
                //第一个数和第6个数比较 交换位置
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("第3轮排序后");
        System.out.println(Arrays.toString(arr));

        System.out.println("===============希尔排序===============");
        int[] array = ArrayUtil.getArray();
        long start = System.currentTimeMillis();
        shellSortPro(array);
        long end = System.currentTimeMillis();
        System.out.println("共耗时：" + (end - start) + "ms");
    }

    /**
     * 采用的交换法
     * 效率不高
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int len = arr.length;
        int temp;
        for (int gap = len / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < len; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    //第一个数和第6个数比较 交换位置
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    /**
     * 采用移位法
     * 效率较好
     *
     * @param arr
     */
    public static void shellSortPro(int[] arr) {
        int len = arr.length;
        int insertValue;
        int insertIndex;
        for (int gap = len / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < len; i++) {
                insertIndex = i;
                insertValue = arr[insertIndex];
                if (arr[insertIndex] < arr[insertIndex - gap]) {
                    while (insertIndex - gap >= 0 && insertValue < arr[insertIndex - gap]) {
                        arr[insertIndex] = arr[insertIndex - gap];
                        insertIndex -= gap;
                    }
                    arr[insertIndex] = insertValue;
                }
            }
        }
    }
}
