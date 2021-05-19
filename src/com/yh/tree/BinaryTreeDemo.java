package com.yh.tree;

/**
 * @author : yh
 * @date : 2021/5/19 21:32
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {

    }
}

/**
 * 定义二叉树
 */
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (root != null) {
            this.root.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        if (root != null) {
            this.root.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if (root != null) {
            this.root.postOrder();
        }
    }
}


/**
 * 定义一个HeroNode结点
 */
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }


    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        //输出当前结点
        System.out.println(this);
        //递归向左前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        //递归向左中序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        //输出当前结点
        System.out.println(this);
        //递归向右中序遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        //递归向左后序遍历
        if (this.left != null) {
            this.left.postOrder();
        }
        //递归向右后序遍历
        if (this.right != null) {
            this.right.postOrder();
        }
        //输出当前结点
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
