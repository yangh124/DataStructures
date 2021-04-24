package com.yh.sort;

import java.util.Arrays;

/**
 * 快速排序
 * O(N*logN)
 *
 * @author : yh
 * @date : 2021/4/24 13:22
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {-9, 78, 0, 23, -567, 70};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        int[] arr = ArrayUtil.getArray();
        long start = System.currentTimeMillis();
        //quickSort(arr, 0, arr.length - 1);
        Arrays.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int m = (left + right) / 2;
        int mNum = arr[m];
        int temp = 0;
        //让比 mNum值 小的放到左边
        //比   mNum值 大的放到右边
        while (l < r) {
            //当arr[l]>=mNum 退出
            while (arr[l] < mNum) {
                l++;
            }
            //当arr[r]<=mNum 退出
            while (arr[r] > mNum) {
                r--;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == mNum) {
                r--;
            }
            if (arr[r] == mNum) {
                l++;
            }
        }
        //防止栈溢出
        if (l == r) {
            l++;
            r--;
        }
        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(arr, right, l);
        }

    }
}
