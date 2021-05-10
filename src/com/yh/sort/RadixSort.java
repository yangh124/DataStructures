package com.yh.sort;

import java.util.Arrays;
import java.util.Date;

/**
 * 基数排序
 *
 * @author : yh
 * @date : 2021/5/10 21:20
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};

        /**
         * 算法思路
         */
//        //定义一个二维数组作为"桶"，以空间换时间
//        int[][] bucket = new int[10][arr.length];
//        //定义一个数组，记录每个桶中数的数量 bucketElementCounts[0]=2  =>  第一个桶中有两个数
//        int[] bucketElementCounts = new int[10];
//        //第一轮
//        for (int i : arr) {
//            //取模得到桶的下标
//            int index = i % 10;
//            //这个桶中的元素数量
//            int count = bucketElementCounts[index];
//            //放入元素
//            bucket[index][count] = i;
//            //桶中的元素数量++
//            bucketElementCounts[index]++;
//        }
//        //将排好序的元素放回原数组
//        int arrIndex = 0;
//        for (int k = 0; k < bucketElementCounts.length; k++) {
//            if (bucketElementCounts[k] != 0) {
//                for (int l = 0; l < bucketElementCounts[k]; l++) {
//                    arr[arrIndex++] = bucket[k][l];
//                }
//            }
//            bucketElementCounts[k] = 0;
//        }
//        System.out.println("第一轮排序后：" + Arrays.toString(arr));
//
//        //第二轮
//        for (int i : arr) {
//            //取模得到桶的下标
//            int index = i / 10 % 10; //748 => 4
//            //这个桶中的元素数量
//            int count = bucketElementCounts[index];
//            //放入元素
//            bucket[index][count] = i;
//            //桶中的元素数量++
//            bucketElementCounts[index]++;
//        }
//        //将排好序的元素放回原数组
//        arrIndex = 0;
//        for (int k = 0; k < bucketElementCounts.length; k++) {
//            if (bucketElementCounts[k] != 0) {
//                for (int l = 0; l < bucketElementCounts[k]; l++) {
//                    arr[arrIndex++] = bucket[k][l];
//                }
//            }
//            bucketElementCounts[k] = 0;
//        }
//        System.out.println("第二轮排序后：" + Arrays.toString(arr));
//
//        //第三轮
//        for (int i : arr) {
//            //取模得到桶的下标
//            int index = i / 100 % 10; //748 => 4
//            //这个桶中的元素数量
//            int count = bucketElementCounts[index];
//            //放入元素
//            bucket[index][count] = i;
//            //桶中的元素数量++
//            bucketElementCounts[index]++;
//        }
//        //将排好序的元素放回原数组
//        arrIndex = 0;
//        for (int k = 0; k < bucketElementCounts.length; k++) {
//            if (bucketElementCounts[k] != 0) {
//                for (int l = 0; l < bucketElementCounts[k]; l++) {
//                    arr[arrIndex++] = bucket[k][l];
//                }
//            }
//            bucketElementCounts[k] = 0;
//        }
//        System.out.println("第三轮排序后：" + Arrays.toString(arr));

        int[] array=ArrayUtil.getArray();
        System.out.println(new Date());
        radixSort(array);
        System.out.println(new Date());
    }

    public static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        //最大数的位数
        int length = String.valueOf(max).length();
        //定义一个二维数组作为"桶"，以空间换时间
        int[][] bucket = new int[10][arr.length];
        //定义一个数组，记录每个桶中数的数量 bucketElementCounts[0]=2  =>  第一个桶中有两个数
        int[] bucketElementCounts = new int[10];
        for (int j = 0, n = 10; j < length; j++, n *= 10) {
            for (int i : arr) {
                //取模得到桶的下标
                int index = (i / n) % 10;
                //这个桶中的元素数量
                int count = bucketElementCounts[index];
                //放入元素
                bucket[index][count] = i;
                //桶中的元素数量++
                bucketElementCounts[index]++;
            }
            //将排好序的元素放回原数组
            int arrIndex = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if (bucketElementCounts[k] != 0) {
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[arrIndex++] = bucket[k][l];
                    }
                }
                bucketElementCounts[k] = 0;
            }
        }
    }
}
