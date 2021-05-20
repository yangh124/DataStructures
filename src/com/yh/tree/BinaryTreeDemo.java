package com.yh.tree;

/**
 * 二叉树
 *
 * @author : yh
 * @date : 2021/5/19 21:32
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);
        System.out.println("==========前序遍历==========");
        binaryTree.preOrder();
        System.out.println("==========中序遍历==========");
        binaryTree.infixOrder();
        System.out.println("==========后序遍历==========");
        binaryTree.postOrder();
        System.out.println("==========前序遍历查找==========");
        System.out.println(binaryTree.preSearch(5));
        System.out.println("==========中序遍历查找==========");
        System.out.println(binaryTree.infixSearch(5));
        System.out.println("==========后序遍历查找==========");
        System.out.println(binaryTree.postSearch(5));
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

    //前序查找
    public HeroNode preSearch(int no) {
        if (root != null) {
            return root.preSearch(no);
        }
        return null;
    }

    //中序查找
    public HeroNode infixSearch(int no) {
        if (root != null) {
            return root.infixSearch(no);
        }
        return null;
    }

    //后序查找
    public HeroNode postSearch(int no) {
        if (root != null) {
            return root.postSearch(no);
        }
        return null;
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

    /**
     * 前序查找
     *
     * @param no id
     * @return 返回查找的结点
     */
    public HeroNode preSearch(int no) {
        System.out.println("进入前序查找~");
        //比较当前结点
        if (this.no == no) {
            return this;
        }
        HeroNode res = null;
        //向左遍历
        if (this.left != null) {
            res = this.left.preSearch(no);
        }
        if (res != null) {
            return res;
        }
        //向右遍历
        if (this.right != null) {
            res = this.right.preSearch(no);
        }
        return res;
    }

    /**
     * 中序查找
     *
     * @param no
     * @return
     */
    public HeroNode infixSearch(int no) {
        HeroNode res = null;
        //向左遍历
        if (this.left != null) {
            res = this.left.infixSearch(no);
        }
        if (res != null) {
            return res;
        }
        System.out.println("进入中序查找~");
        //比较当前结点
        if (this.no == no) {
            return this;
        }
        //向右遍历
        if (this.right != null) {
            res = this.right.infixSearch(no);
        }
        return res;
    }

    /**
     * 后序查找
     *
     * @param no
     * @return
     */
    public HeroNode postSearch(int no) {
        HeroNode res = null;
        //向左遍历
        if (this.left != null) {
            res = this.left.postSearch(no);
        }
        if (res != null) {
            return res;
        }
        //向右遍历
        if (this.right != null) {
            res = this.right.postSearch(no);
        }
        if (res != null) {
            return res;
        }
        System.out.println("进入后序查找~");
        //比较当前结点
        if (this.no == no) {
            return this;
        }
        return null;
    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
