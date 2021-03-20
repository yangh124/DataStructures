package com.yh.linkedlist.dou;


/**
 * @author : yh
 * @date : 2021/3/20 18:20
 */
class DoubleLinkedList {

    /**
     * 定义一个头节点，头节点不存放数据
     */
    private final HeroNode2 headNode = new HeroNode2(0, "", "");

    public HeroNode2 getHeadNode() {
        return headNode;
    }

    /**
     * 显示链表【遍历】
     */
    public void list() {
        if (headNode.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = headNode.next;
        while (null != temp) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void add(HeroNode2 node) {
        //因为head节点不能动，因此我们需要一个辅助变量 temp
        HeroNode2 temp = headNode;
        //遍历链表，找到最后
        while (temp.next != null) {
            temp = temp.next;
        }
        //当退出循环时，temp就是最后一个节点
        //形成一个双向链表
        temp.next = node;
        node.pre = temp;
    }

    /**
     * 根据no修改
     */
    public void updateByNo(HeroNode2 node) {
        if (headNode.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = headNode;
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
        HeroNode2 temp = headNode.next;
        boolean flag = false;
        while (true) {
            //到链表最后的next
            if (null == temp) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (!flag) {
            System.out.println("没有找到");
        } else {
            temp.pre.next = temp.next;
            if (null != temp.next) {//判断是否为最后一个节点
                temp.next.pre = temp.pre;
            }
        }
    }

    /**
     * 有序添加节点
     * 根据编号排序
     */
    public void addByOrder(HeroNode2 node) {
        //因为是单链表，所以我们要找的temp是位于添加位置的前一节点，否则不能插入
        HeroNode2 temp = headNode;
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
            node.pre = temp;
            temp.next = node;
            if (null != node.next) {
                node.next.pre = node;
            }
        }
    }
}
