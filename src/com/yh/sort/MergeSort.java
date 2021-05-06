package com.yh.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author : yh
 * @date : 2021/5/6 21:06
 */
public class MergeSort {

    public static void main(String[] args) {
//        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
//        int[] tempArr = new int[arr.length];
//        mergeSort(arr, 0, arr.length - 1, tempArr);
//        System.out.println(Arrays.toString(arr));
        long start = System.currentTimeMillis();
        int[] array = ArrayUtil.getArray();
        int[] tempArray = new int[array.length];
        mergeSort(array, 0, array.length - 1, tempArray);
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");
    }

    /**
     * 归并排序
     *
     * @param arr     原数组
     * @param left    开始索引
     * @param right   结束索引
     * @param tempArr 中转数组
     */
    //分+合方法
    public static void mergeSort(int[] arr, int left, int right, int[] tempArr) {
        if (left < right) {
            int mid = (left + right) >>> 1;
            mergeSort(arr, left, mid, tempArr);
            mergeSort(arr, mid + 1, right, tempArr);
            merge(arr, left, mid, right, tempArr);
        }
    }

    //合并的方法

    /**
     * @param arr     原数组
     * @param left    开始索引
     * @param mid     中间索引
     * @param right   结束索引
     * @param tempArr 中转数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] tempArr) {
       // System.out.println("======================");
        //初始化i，左边有序序列的初始索引
        int i = left;
        //初始化j，右边有序序列的初始索引
        int j = mid + 1;
        //指向temp数组的当前索引
        int t = 0;
        /*
            1.先把左右两边（有序）的数据按照规则填充到temp数组
              直到左右两边的有序序列，有一边处理完毕为止
        */
        while (i <= mid && j <= right) {
            //如果左边有序序列的当前元素<=右边有序序列的当前元素
            if (arr[i] <= arr[j]) {
                tempArr[t] = arr[i];
                i++;
            } else {
                tempArr[t] = arr[j];
                j++;
            }
            t++;
        }
        /*
            2.把有剩余数据的一边的数据依次全部填充到temp
         */
        //左边的有序序列还有剩余
        while (i <= mid) {
            tempArr[t] = arr[i];
            t++;
            i++;
        }
        //右边的有序序列有剩余
        while (j <= right) {
            tempArr[t] = arr[j];
            t++;
            j++;
        }
        /*
            3.将temp数组的元素拷贝到arr
         */
        t = 0;
        int temp = left;
       // System.out.println("temp=" + temp + ";right=" + right);
        while (temp <= right) {
            arr[temp] = tempArr[t];
            t++;
            temp++;
        }
    }
}
