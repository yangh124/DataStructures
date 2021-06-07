package com.yh.tree;

import com.yh.sort.ArrayUtil;

import java.util.Arrays;

/**
 * @author : yh
 * @date : 2021/6/6 12:24
 */
public class HeapSort {

    public static void main(String[] args) {
        //将数组升序排序
        int[] arr = ArrayUtil.getArray();
        long start = System.currentTimeMillis();
        heapSort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");

    }

    /**
     * 堆排序 O(nlogn)
     *
     * @param arr 数组
     */
    public static void heapSort(int[] arr) {
        int temp;
        System.out.println("==========堆排序==========");
//        //分布完成
//        adjustHeap(arr, 1, arr.length);
//        System.out.println("第一次" + Arrays.toString(arr));
//        adjustHeap(arr, 0, arr.length);
//        System.out.println("第二次" + Arrays.toString(arr));
        /**
         * 1. 将无序序列构建成一个堆，根据升序需求选择大顶堆或小顶堆
         */
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        /**
         * 2. 将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端
         * 3. 重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序
         */
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
        //System.out.println("数组=" + Arrays.toString(arr));
    }

    /**
     * 将树调整成大顶堆
     * <p>
     * 功能：完成将以 i 对应的非叶子结点的树调整成大顶堆
     * 举例：int arr[] = {4,6,8,5,9} => i=1 => adjustHeap  => 得到 {4,9,8,5,6}
     * 如果我们再次调用 adjustHeap 传入的是 i=0 => 得到{4,9,8,5,6}  => {9,6,8,5,4}
     *
     * @param arr    待调整的数组
     * @param i      表示非叶子结点在数组中的索引
     * @param length 表示对多少个元素调整，length是在逐渐的减少
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        //先取出当前元素的值，保存在临时变量中
        int temp = arr[i];
        //开始调整
        //说明
        //1. k=i*2+1 k是i结点的左子结点  k = k * 2 + 1 表示下一个左子结点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {//说明左子结点的值小于右子节点的值
                k++; // k 指向右子结点 此时的k就是右子结点
            }
            //此时k 就是两个子结点中较大的那个
            if (arr[k] > temp) { //如果子结点大于父结点
                arr[i] = arr[k]; //把较大的值赋给当前结点  较大的子结点变成父结点
                i = k; // i指向k，继续循环比较  相当于此时k变为父结点
            } else {
                break;
            }
        }
        //当for循环结束后，此时i所在的子树中,i的父结点值最大
        arr[i] = temp;
    }
}
