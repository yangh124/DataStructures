package com.yh.sort;

import java.util.Arrays;

/**
 * 选择排序
 * <p>
 * 时间复杂度 O(n²)
 *
 * @author : yh
 * @date : 2021/4/12 20:58
 */
public class SelectSort {

    public static void main(String[] args) {
        /*
         * 演变过程
         */
        int[] array = {101, 34, 119, 1};
        int len = array.length;
        //第1轮排序
        //假设第一个数最小
        int minIndex1 = 0;
        int min1 = array[0];
        int temp1;
        for (int j = 1; j < len; j++) {
            if (array[j] < min1) {
                min1 = array[j];
                minIndex1 = j;
            }
        }
        temp1 = array[0];
        array[0] = min1;
        array[minIndex1] = temp1;
        System.out.println("第1趟排序后的数组");
        System.out.println(Arrays.toString(array));

        //第2轮排序
        int minIndex2 = 1;
        int min2 = array[1];
        int temp2;
        for (int j = 2; j < len; j++) {
            if (array[j] < min2) {
                min2 = array[j];
                minIndex2 = j;
            }
        }
        temp2 = array[1];
        array[1] = min2;
        array[minIndex2] = temp2;
        System.out.println("第2趟排序后的数组");
        System.out.println(Arrays.toString(array));

        //第3轮排序
        int minIndex3 = 2;
        int min3 = array[2];
        int temp3;
        for (int j = 3; j < len; j++) {
            if (array[j] < min3) {
                min3 = array[j];
                minIndex3 = j;
            }
        }
        temp3 = array[2];
        array[2] = min3;
        array[minIndex3] = temp3;
        System.out.println("第3趟排序后的数组");
        System.out.println(Arrays.toString(array));

        System.out.println("=================选择排序=================");
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        long start = System.currentTimeMillis();
        selectSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("共耗时：" + (end - start) / 1000 + "s");
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        int len = arr.length;
        int minIndex;
        int min;
        int temp;
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            min = arr[i];
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                temp = arr[i];
                arr[i] = min;
                arr[minIndex] = temp;
            }

        }
    }
}
