package com.yh.hashtable;

import java.util.Scanner;

/**
 * @author : yh
 * @date : 2021/5/17 20:42
 */
public class HashTableDemo {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);
        String key;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add：添加");
            System.out.println("list：遍历");
            System.out.println("find：查找");
            System.out.println("del：删除");
            System.out.println("exit：退出");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("请输入id");
                    int id = scanner.nextInt();
                    System.out.println("请输入姓名");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("请输入id");
                    id = scanner.nextInt();
                    emp = hashTable.get(id);
                    System.out.println(emp);
                    break;
                case "del":
                    System.out.println("请输入id");
                    id = scanner.nextInt();
                    hashTable.remove(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

}

class HashTable {
    private EmpLinkedList[] table;
    private int size;

    public HashTable(int size) {
        this.size = size;
        this.table = new EmpLinkedList[size];
        //初始化数组中的链表
        for (int i = 0; i < size; i++) {
            table[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp) {
        int index = hash(emp.id);
        table[index].add(emp);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            table[i].list(i);
        }
    }

    public Emp get(int id) {
        int index = hash(id);
        return table[index].get(id);
    }

    public void remove(int id) {
        int index = hash(id);
        table[index].remove(id);
    }

    public int hash(int id) {
        return id % size;
    }
}

class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class EmpLinkedList {

    private Emp head;

    /**
     * 添加员工
     */
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (curEmp.next != null) {
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    public void list(int index) {
        if (head == null) {
            System.out.println(index + "：当前链表为空!");
            return;
        }
        Emp curEmp = head;
        System.out.print(curEmp);
        while (curEmp.next != null) {
            curEmp = curEmp.next;
            System.out.print("    ======>    " + curEmp);
        }
        System.out.println();
    }

    public Emp get(int id) {
        if (head == null) {
            return null;
        }
        if (head.id == id) {
            return head;
        }
        Emp curEmp = head;
        while (curEmp.next != null) {
            curEmp = curEmp.next;
            if (curEmp.id == id) {
                return curEmp;
            }
        }
        return null;
    }

    public void remove(int id) {
        if (head == null) {
            return;
        }
        if (head.id == id) {
            head = null;
            return;
        }
        Emp curEmp = head;
        while (curEmp.next != null) {
            if (curEmp.next.id == id) {
                curEmp.next = curEmp.next.next;
            }
            curEmp = curEmp.next;
        }
    }
}
