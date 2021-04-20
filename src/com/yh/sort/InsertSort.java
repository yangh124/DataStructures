package com.yh.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author : yh
 * @date : 2021/4/20 19:24
 */
public class InsertSort {

    public static void main(String[] args) {

        /*
            演变过程
         */
        int[] array = {101, 34, 119, 1};

        //第1轮 {101, 34, 119, 1}  =>  {34, 101, 119, 1}
        //待插入的数
        int insertValue = array[1];
        int insertIndex = 0;
        /*
            说明：
                1. insertIndex >= 0 保证在给insertValue找插入位置时，不出现下标<0
                2. insertValue < array[insertIndex] 待插入的数，还没有找到插入位置
                3. 将array[insertIndex] 后移
         */
        while (insertIndex >= 0 && insertValue < array[insertIndex]) {
            array[insertIndex + 1] = array[insertIndex];
            insertIndex--;
        }
        //当循环结束，说明插入的位置找到了，insertIndex + 1
        array[insertIndex + 1] = insertValue;
        System.out.println("第1轮插入后");
        System.out.println(Arrays.toString(array));
        //第2轮
        insertValue = array[2];
        insertIndex = 1;
        while (insertIndex >= 0 && insertValue < array[insertIndex]) {
            array[insertIndex + 1] = array[insertIndex];
            insertIndex--;
        }
        //当循环结束，说明插入的位置找到了，insertIndex + 1
        array[insertIndex + 1] = insertValue;
        System.out.println("第2轮插入后");
        System.out.println(Arrays.toString(array));
        //第3轮
        insertValue = array[3];
        insertIndex = 2;
        while (insertIndex >= 0 && insertValue < array[insertIndex]) {
            array[insertIndex + 1] = array[insertIndex];
            insertIndex--;
        }
        //当循环结束，说明插入的位置找到了，insertIndex + 1
        array[insertIndex + 1] = insertValue;
        System.out.println("第3轮插入后");
        System.out.println(Arrays.toString(array));
        System.out.println("===============插入排序===============");
        int[] arr = ArrayUtil.getArray();
        long start = System.currentTimeMillis();
        insertSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("共耗时：" + (end - start) + "ms");
    }

    public static void insertSort(int[] arr) {
        int len = arr.length;
        int insertValue;
        int insertIndex;
        for (int i = 1; i < len; i++) {
            insertValue = arr[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                //就是一个移位操作
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                //当循环结束，说明插入的位置找到了，insertIndex + 1
                arr[insertIndex + 1] = insertValue;
            }
        }
    }

}
