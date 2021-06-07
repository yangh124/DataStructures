package com.yh.tree;

/**
 * 顺序二叉树
 *
 * @author : yh
 * @date : 2021/5/31 21:30
 */
public class ArrBinaryTreeDemo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        System.out.println("===========前序遍历===========");
        arrBinaryTree.preOrder();
        System.out.println("===========中序遍历===========");
        arrBinaryTree.infixOrder();
        System.out.println("===========后序遍历===========");
        arrBinaryTree.postOrder();
    }

}

class ArrBinaryTree {
    private final int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        this.preOrder(0);
    }

    /**
     * 前序遍历
     *
     * @param index 数组下标
     */
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空！");
            return;
        }
        //输出当前元素
        System.out.println(arr[index]);
        //向左递归遍历 2*n + 1
        if ((index << 1) + 1 < arr.length) {
            preOrder((index << 1) + 1);
        }
        //向右递归遍历 2*n + 2
        if ((index << 1) + 2 < arr.length) {
            preOrder((index << 1) + 2);
        }
    }

    public void infixOrder() {
        this.infixOrder(0);
    }

    /**
     * 中序遍历
     *
     * @param index
     */
    public void infixOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空！");
            return;
        }
        //向左递归遍历 2*n + 1
        if ((index << 1) + 1 < arr.length) {
            infixOrder((index << 1) + 1);
        }
        //输出当前元素
        System.out.println(arr[index]);
        //向右递归遍历 2*n + 2
        if ((index << 1) + 2 < arr.length) {
            infixOrder((index << 1) + 2);
        }
    }

    public void postOrder() {
        this.postOrder(0);
    }

    /**
     * 后序遍历
     *
     * @param index
     */
    public void postOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空！");
            return;
        }
        //向左递归遍历 2*n + 1
        if ((index << 1) + 1 < arr.length) {
            postOrder((index << 1) + 1);
        }
        //向右递归遍历 2*n + 2
        if ((index << 1) + 2 < arr.length) {
            postOrder((index << 1) + 2);
        }
        //输出当前元素
        System.out.println(arr[index]);
    }
}
