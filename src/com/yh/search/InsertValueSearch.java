package com.yh.search;

/**
 * 插值查找
 *
 * @author : yh
 * @date : 2021/5/15 11:30
 */
public class InsertValueSearch {

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
    }

    /**
     * 插值查找
     *
     * @param arr   有序数组
     * @param left  左边下标
     * @param right 右边下标
     * @param num   查找的元素
     * @return 下标
     */
    public static int insertValueSearch(int[] arr, int left, int right, int num) {
        //注意  num < arr[0] || num > arr[arr.length - 1] 这两个条件，不止是优化作用；如果没有此条件，mid可能过大或过小，造成下标越界
        if (left > right || num < arr[0] || num > arr[arr.length - 1]) {
            return -1;
        }
        //插值索引公式
        int mid = left + (right - left) * (num - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        //向右递归
        if (num > midVal) {
            return insertValueSearch(arr, mid + 1, right, num);
            //向左递归
        } else if (num < midVal) {
            return insertValueSearch(arr, left, mid - 1, num);
        } else {
            return mid;
        }
    }
}
