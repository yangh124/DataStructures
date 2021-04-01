package com.yh.recursion;

/**
 * 迷宫
 *
 * @author : yh
 * @date : 2021/4/1 20:37
 */
public class MiGong {

    public static void main(String[] args) {
        //先创建一个二维数组，模拟迷宫
        //地图
        int[][] map = new int[8][7];
        //使用1表示墙
        //上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右置为1
        for (int i = 1; i < 7; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
//        setWay(map, 1, 1);
//        System.out.println("===========================================");
//        for (int[] ints : map) {
//            for (int anInt : ints) {
//                System.out.print(anInt + " ");
//            }
//            System.out.println();
//        }
        System.out.println("===========================================");
        setWay2(map, 1, 1);
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归回溯来给小球找路
     * 说明
     * 1. map表示地图
     * 2. x,y表示从地图的哪个位置开始出发(1,1)
     * 3. 如果小球能到map[6][5]位置，则说明通路找到
     * 4. 约定：当map[x][y]为0表示该点没有走过 当为1表示墙，2表示通路可以走，3表示该点已经走过（走不通）
     * 5. 在走迷宫时，需要确定一个策略（方法）：下->右->上->左，如果该点走不通，再回溯
     *
     * @param map 地图
     * @param x   坐标
     * @param y   坐标
     * @return 如果找到通路，就返回true，否则返回false
     */
    public static boolean setWay(int[][] map, int x, int y) {
        if (map[6][5] == 2) {
            return true;
        } else {
            //如果当前这个点还没有走过
            if (map[x][y] == 0) {
                //尝试走
                map[x][y] = 2;
                //向下走
                if (setWay(map, x + 1, y)) {
                    return true;
                    //向右走
                } else if (setWay(map, x, y + 1)) {
                    return true;
                    //向上走
                } else if (setWay(map, x - 1, y)) {
                    return true;
                    //向左走
                } else if (setWay(map, x, y - 1)) {
                    return true;
                } else {
                    //说明该点是死胡同
                    map[x][y] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    //修改策略  上->右->下->左
    public static boolean setWay2(int[][] map, int x, int y) {
        if (map[6][5] == 2) {
            return true;
        } else {
            //如果当前这个点还没有走过
            if (map[x][y] == 0) {
                //尝试走
                map[x][y] = 2;
                //向上走
                if (setWay2(map, x - 1, y)) {
                    return true;
                    //向右走
                } else if (setWay2(map, x, y + 1)) {
                    return true;
                    //向下走
                } else if (setWay2(map, x + 1, y)) {
                    return true;
                    //向左走
                } else if (setWay2(map, x, y - 1)) {
                    return true;
                } else {
                    //说明该点是死胡同
                    map[x][y] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
