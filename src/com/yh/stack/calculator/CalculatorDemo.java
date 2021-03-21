package com.yh.stack.calculator;

/**
 * 栈实现简单计算器
 *
 * @author : yh
 * @date : 2021/3/21 21:38
 */
public class CalculatorDemo {


    public static void main(String[] args) {
        String exp = "30+20*666-2";
        //数栈
        CalArrayStack numStack = new CalArrayStack(10);
        //操作符栈
        CalArrayStack operStack = new CalArrayStack(10);
        //用于扫描
        int index = 0;
        //取出计算的俩数
        int num1;
        int num2;
        //取出的操作符
        int oper;
        //计算的结果
        int res;
        //每次截取的单个字符
        char ch;
        //处理多位数
        StringBuilder keepNum = new StringBuilder();
        do {
            ch = exp.substring(index, index + 1).charAt(0);
            if (operStack.isOper(ch)) {
                //如果栈中已有操作符
                if (!operStack.isEmpty()) {
                    //如果当前操作符优先级<=栈顶的操作符
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        //取出计算结果
                        res = numStack.cal(num1, num2, oper);
                        //结果入栈
                        numStack.push(res);
                    }
                }
                //符号入栈
                operStack.push(ch);
            } else {
                //此ch为asc码 只能计算10以内的计算
                // numStack.push(ch - 48);

                //处理多位数
                keepNum.append(ch);
                if (index == exp.length() - 1) {
                    numStack.push(Integer.parseInt(String.valueOf(keepNum)));
                } else {
                    if (operStack.isOper(exp.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(String.valueOf(keepNum)));
                        keepNum.delete(0, keepNum.length());
                    }
                }
            }
            //index>=表达式长度 退出
        } while (++index < exp.length());
        //如果符号栈为空 计算结束
        while (!operStack.isEmpty()) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            //取出计算结果
            res = numStack.cal(num1, num2, oper);
            //结果入栈
            numStack.push(res);
        }
        System.out.println(exp + "=" + numStack.pop());
    }
}
