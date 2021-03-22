package com.yh.stack.poland;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式
 * 实现计算器
 *
 * @author : yh
 * @date : 2021/3/22 20:20
 */
public class PolandNotationDemo {

    public static void main(String[] args) {
        //(3+4)x5-6 -> 3 4 + 5 * 6 -
        //为了方便，此处将 表达式的数字和符号用空格隔开
        String suffixExp = "3 4 + 5 * 6 -";
        //4*5-8+60+8/2  =>  4 5 * 8 - 60 + 8 2 / +
        String exp = "4 5 * 8 - 60 + 8 2 / +";
        /**
         * 思路
         * 1. 先将"3 4 + 5 x 6 -"  =>放入ArrayList
         * 2. 计算结果
         */
        String[] array = suffixExp.split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(array));
        int res = calculate(list);
        System.out.println(res);

        System.out.println(calculate(new ArrayList<>(Arrays.asList(exp.split(" ")))));
    }

    /**
     * 1.从左至右扫描，将3和4压入栈
     * 2.遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得7，再将7入栈
     * 3.将5入栈
     * 4.接下来是x运算符，因此弹出5和7，计算出7x5=35，将35入栈
     * 5.将6入栈
     * 6.最后是-运算符，计算出35-6的值，即29，由此得出最终结果
     *
     * @param list
     * @return
     */
    public static int calculate(List<String> list) {
        //创建栈  只需要一个栈
        Stack<String> stack = new Stack<>();
        for (String s : list) {
            //匹配多位数
            if (s.matches("\\d+")) {
                stack.push(s);
            } else {
                //pop出两个数，并运算，再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res;
                switch (s) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num1 / num2;
                        break;
                    default:
                        throw new RuntimeException("运算符错误");
                }
                stack.push(String.valueOf(res));
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

