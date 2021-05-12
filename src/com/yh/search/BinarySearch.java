package com.yh.search;

/**
 * 二分查找
 * *数组必须有序*
 *
 * @author : yh
 * @date : 2021/5/12 22:12
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 8, 89, 1000, 1234};
        int i = binarySearch(arr, 0, arr.length - 1, 88);
        System.out.println(i);

    }

    public static int binarySearch(int[] arr, int left, int right, int num) {
        //当 left > right 说明递归了整个数组都没找到
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (num < arr[mid]) {//向左
            return binarySearch(arr, left, mid - 1, num);
        } else if (num > arr[mid]) {//向右
            return binarySearch(arr, mid + 1, right, num);
        } else {
            return mid;
        }
    }
}
