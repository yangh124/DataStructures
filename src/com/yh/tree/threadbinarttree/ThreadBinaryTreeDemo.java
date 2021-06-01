package com.yh.tree.threadbinarttree;

/**
 * 线索二叉树
 *
 * @author : yh
 * @date : 2021/6/1 21:09
 */
public class ThreadBinaryTreeDemo {

    public static void main(String[] args) {

    }

}


/**
 * 实现线索化二叉树
 */
class ThreadedBinaryTree {
    private HeroNode root;

    /**
     * 为了实现线索化，需要创建要给指向当前结点的前驱结点的指针
     * 在递归进行线索化时，pre总是保留前一个结点
     */
    private HeroNode pre;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**
     * 线索化方法
     *
     * @param node 当前需要线索化的结点
     */
    public void threadedNodes(HeroNode node) {
        if (null == node) {
            return;
        }
        //1. 先线索化左子树
        threadedNodes(node.getLeft());
        //2. 线索化当前结点
        if (null == node.getLeft()) {
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针的类型 => 指向前驱结点
            node.setLeftType(1);
        }
        //处理后继结点
        if (null != pre && null == pre.getRight()) {
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的右指针类型
            pre.setRightType(1);
        }
        pre = node;
        //3. 再线索化右子树
        threadedNodes(node.getRight());
    }

    public void delNode(int no) {
        if (root == null) {
            System.out.println("空树，不能删除~");
            return;
        }
        if (this.root.getNo() == no) {
            root = null;
            return;
        }
        this.root.delNode(no);
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

    /**
     * 说明：
     * 1. leftType==0 表示指向左子树，leftType==1 表示指向前驱结点
     * 2. rightType==0 表示指向右子树，rightType==1 表示指向后继结点
     */
    private int leftType;
    private int rightType;

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

    public int getLeftType() {
        return leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.delNode(no);
        }
        if (this.right != null) {
            this.right.delNode(no);
        }
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

}
