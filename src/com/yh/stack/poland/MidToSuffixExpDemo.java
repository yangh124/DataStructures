package com.yh.stack.poland;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中缀表达式转后缀表达式
 *
 * @author : yh
 * @date : 2021/3/23 20:35
 */
public class MidToSuffixExpDemo {

    public static void main(String[] args) {
        String exp = "1+((2+3)*4)-5";
        List<String> list = toInfixExpressionList(exp);
        //[1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
        System.out.println(list);
        //[1, 2, 3, +, 4, *, 5, -, +]
        System.out.println(toSuffixExpressionList(list));

    }

    /**
     * 中缀表达式转List
     *
     * @param s
     * @return
     */
    public static List<String> toInfixExpressionList(String s) {
        //定义一个List，存放中缀表达式对应的内容
        List<String> ls = new ArrayList<>();
        //这是一个指针，用来遍历
        int i = 0;
        //对多位数拼接
        StringBuilder str;
        char c;
        do {
            //如果c是一个非数字
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else {
                str = new StringBuilder();
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str.append(c);
                    i++;
                }
                ls.add(String.valueOf(str));
            }
        } while (i < s.length());
        return ls;
    }

    /**
     * list 转 后缀表达式
     * 思路：
     * 1. 初始化两个栈：运算符栈s1和存储中间结果结果的栈s2
     * 2. 从左至右扫描中缀表达式
     * 3. 遇到操作数时，将其压入s2
     * 4. 遇到运算符时，比较其与s1栈顶运算符优先级
     * 1). 如果s1为空，或栈顶运算符为"("，则直接将此运算符入栈
     * 2). 否则，若优先级比栈顶运算符高，也将运算符压入s1
     * 3). 否则，将s1栈顶的运算符弹出并压入到s2中，再次转到(4-1)与s1中新的栈顶运算符相比较（相当于调换俩运算符位置）
     * 5. 遇到括号时：
     * 1). 如果是左括号"("，则直接压入s1
     * 2). 如果是右括号")"，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
     * 6. 重复步骤2-5，直到表达式的最右边
     * 7. 将s1中剩余的运算符依次弹出并压入s2
     * 8. 依次弹出s2中的元素并输出，结果的逆序即为中缀表达式的后缀表达式
     *
     * @param list
     * @return
     */
    public static List<String> toSuffixExpressionList(List<String> list) {
        //运算符栈
        Stack<String> s1 = new Stack<>();
        //中间结果栈
        //Stack<String> s2 = new Stack<>();
        List<String> s2 = new ArrayList<>();
        for (String s : list) {
            if (s.matches("\\d+")) {
                s2.add(s);
            } else if ("(".equals(s)) {
                s1.push(s);
            } else if (")".equals(s)) {
                while (!"(".equals(s1.peek())) {
                    s2.add(s1.pop());
                }
                //直到遇到左括号为止，此时将这一对括号丢弃（消除小括号）
                s1.pop();
            } else {
                while (!s1.isEmpty() && "(".equals(s1.peek()) && priority(s) <= priority(s1.peek())) {
                    s2.add(s1.pop());
                }
                s1.push(s);
            }
        }
        while (!s1.isEmpty()) {
            s2.add(s1.pop());
        }
        return s2;
    }


    /**
     * 返回运算符的优先级
     * 数字越大，优先级越高
     */
    public static int priority(String oper) {
        if ("*".equals(oper) || "/".equals(oper)) {
            return 1;
        } else if ("+".equals(oper) || "-".equals(oper)) {
            return 0;
        } else {
            return -1;
        }
    }
}
