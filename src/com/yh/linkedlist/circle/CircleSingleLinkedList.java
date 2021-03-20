package com.yh.linkedlist.circle;

/**
 * @author : yh
 * @date : 2021/3/20 20:58
 */
class CircleSingleLinkedList {

    /**
     * 创建一个first节点，当前没有编号
     */
    private Boy first = new Boy(-1);

    /**
     * 添加节点
     *
     * @param num 添加的节点个数
     */
    public void addBoy(int num) {
        if (num < 1) {
            throw new RuntimeException("num值应大于2");
        }
        Boy curBoy = null;
        //使用for循环创建环形链表
        for (int i = 1; i <= num; i++) {
            //创建节点
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            }
            curBoy.setNext(boy);
            boy.setNext(first);
            curBoy = boy;
        }
    }

    /**
     * 遍历环形链表
     */
    public void list() {
        if (null == first) {
            throw new RuntimeException("链表为空");
        }
        Boy curBoy = first;
        while (null != curBoy.getNext()) {
            System.out.println(curBoy.getNo());
            curBoy = curBoy.getNext();
            if (curBoy == first) {
                break;
            }
        }
    }

    /**
     * 根据用户输入，计算小孩出圈顺序
     *
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums     表示最初有几个小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            throw new RuntimeException("参数有误");
        }
        Boy helper = first;
        //获取链表最后一个节点
        while (helper.getNext() != first) {
            helper = helper.getNext();
        }
        //同时后移两个变量startNo次
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while (helper != first) {
            //数几下=同时后移两个变量countNum次
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //此时first就是要出圈的节点
            System.out.println("小孩出圈：" + first.getNo());
            //从链表中移除
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后一个小孩：" + first.getNo());
    }
}
