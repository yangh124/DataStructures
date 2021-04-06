package com.yh.recursion;

/**
 * 八皇后
 *
 * @author : yh
 * @date : 2021/4/6 20:44
 */
public class EightQueens {

    private static final int max = 8;

    private static final int[] array = new int[max];

    private static int count = 0;

    private static int validateCount = 0;

    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        eightQueens.place(0);
        System.out.println("一共解法数:" + count);
        System.out.println("一共判断次数:" + validateCount);
    }


    /**
     * 放置皇后
     * *注意：place方法在每一次递归时，都会有 for (int i = 0; i < max; i++)，因此会有回溯
     *
     * @param n 第n个皇后
     */
    private void place(int n) {
        //8个皇后全部放置完成
        if (n == max) {
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //把当前这个皇后（第n个）,放到该行的第i列
            array[n] = i;
            //判断是否冲突，如果不冲突
            if (validate(n)) {
                //继续放下一个皇后
                place(n + 1);
            }
            //如果冲突，继续执行  array[n] = i 即将当前皇后向后移一列
        }
    }

    /**
     * 判断两个皇后是否冲突
     *
     * @param n 表示放置第n个皇后
     * @return
     */
    private boolean validate(int n) {
        validateCount++;
        for (int i = 0; i < n; i++) {
            //在同一列或者同一斜线（Math.abs 求绝对值）
            if (array[i] == array[n] || Math.abs(i - n) == Math.abs(array[i] - array[n])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印数组
     */
    private void print() {
        count++;
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
