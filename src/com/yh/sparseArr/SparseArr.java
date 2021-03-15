package com.yh.sparseArr;

import java.io.*;

/**
 * 稀疏数组
 *
 * @author : yh
 * @date : 2021/3/13 13:42
 */
public class SparseArr {

    public static void main(String[] args) {
        //创建原始的二维数组 11 * 11
        // 1表示黑子  2表示蓝子
        //原始二维数组
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[1][0] = 1;
        chessArr1[2][3] = 2;
        chessArr1[5][6] = 2;
        System.out.println("================================================");
        for (int[] rows : chessArr1) {
            for (int num : rows) {
                System.out.printf("%d\t", num);
            }
            System.out.println();
        }
        System.out.println("================================================");

        //将原始二维数组-->稀疏数组
        //1. 先遍历原始二维数组，得到非0的数据个数
        int rows = chessArr1.length;
        int cols = chessArr1[0].length;
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("sum：" + sum);

        //创建稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = rows;
        sparseArr[0][1] = cols;
        sparseArr[0][2] = sum;

        //遍历原始二维数组，将非0数据存入稀疏数组
        int count = 0;//记录非0数据个数
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int num = chessArr1[i][j];
                if (num != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = num;
                }
            }
        }

        //打印稀疏数组
        System.out.println("================================================");
        for (int[] ints : sparseArr) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
        System.out.println("================================================");

        //将稀疏数组-->二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        for (int[] ints : chessArr2) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
        System.out.println("================================================");

        writ(sparseArr);
    }


    //写入磁盘
    public static void writ(int[][] sparseArr) {
        System.out.println("写入磁盘的数据中~~~~~~");
        File file = new File("/Users/yh/Downloads/sparseArr.txt");
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file));
            if (!file.exists()) {
                boolean newFile = file.createNewFile();
                System.out.println("创建文件:" + newFile);
            }
            StringBuilder allBuilder = new StringBuilder();
            for (int[] rows : sparseArr) {
                StringBuilder rowBuilder = new StringBuilder();
                for (int item : rows) {
                    rowBuilder.append(item).append("\t");
                }
                allBuilder.append(rowBuilder).append("\n");
            }
            bw.write(String.valueOf(allBuilder));
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //读取磁盘
    public static int[][] read() {
        System.out.println("读取磁盘的数据中~~~~~~");
        File file = new File("/Users/yh/Downloads/sparseArr.txt");
        if (!file.exists()) {
            System.out.println("文件不存在");
            return null;
        }
        int[][] sparseArr = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String row = br.readLine();
            String[] s = row.split("\t");
            sparseArr = new int[Integer.parseInt(s[0])][Integer.parseInt(s[1])];
            while ((row = br.readLine()) != null) {
                String[] s2 = row.split("\t");
                sparseArr[Integer.parseInt(s2[0])][Integer.parseInt(s2[1])] = Integer.parseInt(s2[2]);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sparseArr;
    }

}
