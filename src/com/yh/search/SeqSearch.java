package com.yh.search;

/**
 * 线性查找
 *
 * @author : yh
 * @date : 2021/5/12 21:44
 */
public class SeqSearch {

    public static void main(String[] args) {
        int[] arr = {1, 9, 11, -1, 34, 89};
        int num = -1;
        int i = seqSearch(arr, num);
        System.out.println(num + "在数组中的位置为:" + i);
    }

    /**
     * 这里的实现为找到一个就返回下标
     *
     * @param arr 数组
     * @param num 查找的数
     * @return 下标
     */
    public static int seqSearch(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }
}
