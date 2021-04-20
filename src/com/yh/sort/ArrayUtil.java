package com.yh.sort;

/**
 * 工具类
 * 生成8万个随机数 数组
 *
 * @author : yh
 * @date : 2021/4/20 19:57
 */
public class ArrayUtil {

    private static final int[] array = new int[80000];

    static {
        for (int i = 0; i < 80000; i++) {
            array[i] = (int) (Math.random() * 8000000);
        }
    }

    public static int[] getArray() {
        return array;
    }
}
