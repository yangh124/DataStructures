package com.yh.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        int[] array = {1, 8, 10, 89, 1000, 1000, 1234};
        List<Integer> res = binarySearchPro(array, 0, array.length - 1, 0);
        System.out.println(res);
    }

    /**
     * 二分查找
     * 返回查找到的第一个元素
     *
     * @param arr   排好序的数组
     * @param left  左下标
     * @param right 右下标
     * @param num   查找的元素
     * @return 下标
     */
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


    /**
     * {1,8,10,89,1000,1000,1234}，当有序数组中有重复值时，查找出多个元素
     * <p>
     * 二分查找 pro
     * 返回查找到的所有元素下标
     *
     * @param arr   排好序的数组
     * @param left  左下标
     * @param right 右下标
     * @param num   查找的元素
     * @return 下标list
     */
    public static List<Integer> binarySearchPro(int[] arr, int left, int right, int num) {
        //当 left > right 说明递归了整个数组都没找到
        if (left > right) {
            return Collections.emptyList();
        }
        int mid = (left + right) / 2;
        if (num < arr[mid]) {//向左
            return binarySearchPro(arr, left, mid - 1, num);
        } else if (num > arr[mid]) {//向右
            return binarySearchPro(arr, mid + 1, right, num);
        } else {
            List<Integer> indexList = new ArrayList<>();
            //此时 mid下标为所找元素
            int temp = mid - 1;
            //向左查找num，temp < 0 => 向左查找结束退出，arr[temp] != num => 查找到不等于num的元素退出（因为数组是排好序的）
            while (temp >= 0 && arr[temp] == num) {
                indexList.add(temp);
                temp--;
            }
            //将mid加入结果集
            indexList.add(mid);
            //向右查找
            temp = mid + 1;
            while (temp <= arr.length - 1 && arr[temp] == num) {
                indexList.add(temp);
                temp++;
            }
            return indexList;
        }
    }
}
