package com.yh.linkedlist.single;

/**
 * 定义一个SingleLinkedList
 */
class SingleLinkedList {

    /**
     * 定义一个头节点，头节点不存放数据
     */
    private final HeroNode headNode = new HeroNode(0, "", "");

    /**
     * 添加节点到单向链表
     * 思路，不考虑编号顺序时
     * 1. 找到当前链表的最后节点
     * 2. 将最后这个节点的next 指向 新的节点
     */
    public void add(HeroNode node) {
        //因为head节点不能动，因此我们需要一个辅助变量 temp
        HeroNode temp = headNode;
        //遍历链表，找到最后
        while (temp.next != null) {
            temp = temp.next;
        }
        //当退出循环时，temp就是最后一个节点
        temp.next = node;
    }

    /**
     * 有序添加节点
     * 根据编号排序
     */
    public void addByOrder(HeroNode node) {
        //因为是单链表，所以我们要找的temp是位于添加位置的前一节点，否则不能插入
        HeroNode temp = headNode;
        //标志添加的编号是否存在，默认为false
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            //位置找到了
            if (temp.next.no > node.no) {
                break;
            } else if (temp.next.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("该排名已存在：" + node);
        } else {
            node.next = temp.next;
            temp.next = node;
        }
    }

    /**
     * 根据no修改
     */
    public void updateByNo(HeroNode node) {
        if (headNode.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = headNode;
        boolean flag = false;
        while (true) {
            if (null == temp) {
                break;//已经遍历完链表了
            }
            if (temp.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.nickName = node.nickName;
            temp.name = node.name;
        } else {
            System.out.println("没要找到编号：" + node.no);
        }
    }

    /**
     * 根据no删除
     */
    public void deleteByNo(int no) {
        HeroNode temp = headNode;
        boolean flag = false;
        while (true) {
            //到链表最后
            if (null == temp.next) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (!flag) {
            System.out.println("没有找到");
        } else {
            temp.next = temp.next.next;
        }
    }

    //显示链表【遍历】
    public void list() {
        if (headNode.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = headNode.next;
        while (null != temp) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public HeroNode getHeadNode() {
        return headNode;
    }
}
