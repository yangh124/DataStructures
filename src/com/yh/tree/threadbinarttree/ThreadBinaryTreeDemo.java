package com.yh.tree.threadbinarttree;

/**
 * 线索二叉树
 *
 * @author : yh
 * @date : 2021/6/1 21:09
 */
public class ThreadBinaryTreeDemo {

    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "tim");
        HeroNode node6 = new HeroNode(14, "lily");
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        //测试中序线索化二叉树
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();
        //原先node5的左右子结点为null 中序线索化之后 左子结点变为node2 右子结点变为root
        HeroNode left = node5.getLeft();
        System.out.println(left);
        HeroNode right = node5.getRight();
        System.out.println(right);
        /**
         * 线索化二叉树之后使用原来的中序遍历会导致栈溢出
         */
        System.out.println("=============使用线索化方式遍历=============");
        threadedBinaryTree.threadedList();
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

    public void threadedNodes() {
        threadedNodes(root);
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
        //每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;
        //3. 再线索化右子树
        threadedNodes(node.getRight());
    }

    //遍历线索化二叉树方法
    public void threadedList() {
        //定义一个变量，存放当前遍历的结点，从root开始
        HeroNode node = root;
        while (node != null) {
            //循环的找到leftType==1的结点，第一个找到的就是8结点
            //后面随着遍历的变化，因为当leftType==1时，说明该结点是按照线索化处理后的有效结点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            //打印当前结点
            System.out.println(node);
            //如果当前结点有后继结点，就输出
            while (node.getRightType() == 1) {
                //获取当前结点的后继结点
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
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
