package com.yh.linkedlist.single;

import java.util.Stack;

/**
 * 单链表
 *
 * @author : yh
 * @date : 2021/3/15 20:29
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
        SingleLinkedList list = new SingleLinkedList();
        list.addByOrder(heroNode4);
        list.addByOrder(heroNode2);
        list.addByOrder(heroNode3);
        list.addByOrder(heroNode1);
        list.addByOrder(heroNode1);
        list.updateByNo(new HeroNode(1, "杨皓", "大帅哥"));
        list.deleteByNo(1);
        System.out.println("=======================打印链表=======================");
        list.list();
        int n = 1;
        System.out.println("=======================获取倒数第" + n + "个=======================");
        // int length = getLength(list.getHeadNode());
        HeroNode lastIndexNode = getLastIndexNode(list.getHeadNode(), n);
        System.out.println(lastIndexNode);
        System.out.println("=======================反转链表=======================");
        //reverseList(list.getHeadNode());
        //list.list();
        HeroNode heroNode = reversePro(list.getHeadNode().next);
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(heroNode);
        singleLinkedList.list();
        System.out.println("=======================反转打印输出=======================");
        reversePrint(singleLinkedList.getHeadNode());
    }

    /**
     * 获取链表的节点个数 （如果是带头节点的链表，需求是不统计头节点）
     *
     * @param head
     * @return
     */
    public static int getLength(HeroNode head) {
        if (null == head.next) {
            return 0;
        }
        int length = 0;
        HeroNode node = head.next;
        while (null != node) {
            length++;
            node = node.next;
        }
        return length;
    }

    /**
     * 查询倒数第n个节点
     *
     * @param head
     * @param n
     * @return
     */
    public static HeroNode getLastIndexNode(HeroNode head, int n) {
        int length = getLength(head);
        int i = 0;
        //第n个节点的下标
        int index = length - n;
        HeroNode cur = head.next;
        while (null != cur) {
            if (i == index) {
                return cur;
            }
            cur = cur.next;
            i++;
        }
        return null;
    }

    /**
     * 反转一个单链表
     *
     * @param head 头节点
     */
    public static void reverseList(HeroNode head) {
        if (null == head.next || null == head.next.next) {
            return;
        }
        HeroNode cur = head.next;
        HeroNode temp = null;
        HeroNode reverseHeadNode = new HeroNode(0, "", "");
        while (null != cur) {
            temp = cur.next;
            cur.next = reverseHeadNode.next;
            reverseHeadNode.next = cur;
            cur = temp;
        }
        head.next = reverseHeadNode.next;
    }

    /**
     * @param node 节点
     * @return
     */
    public static HeroNode reversePro(HeroNode node) {
        if (node == null || node.next == null) return node;
        HeroNode heroNode = reversePro(node.next);
        node.next.next = node;
        node.next = null;
        return heroNode;
    }

    /**
     * 反转打印链表
     * 不改变原链表结构
     *
     * @param head
     */
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = head.next;
        while (null != temp) {
            stack.add(temp);
            temp = temp.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

}


