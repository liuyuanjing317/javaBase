package com.lyj.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author: liuyuanjing
 * @date:
 * @version: 2.0.0
 * @description: ����ջ������ѧ��ʽ
 **/
class RePolandCalculator {

    //������ʽ��ֵ
    public static void main(String[] args) throws Exception {
        RePolandCalculator rePolandCalculator=new RePolandCalculator();
        //1+((2+3)��4)-5
       /* String s="20 3 + 4 * 5 - 1 +";
        List<String> res=rePolandCalculator.getString(s);
        int cal = rePolandCalculator.cal(res);
        System.out.println("��������"+cal);*/

        String s2="1+((2+3)*4)/5";
        int cal2 =rePolandCalculator.turnToRePoLand(s2);
        System.out.printf("1��������"+cal2);

    }


    //ת��
    public List<String> getString(String s){
        String[] s1 = s.split(" ");
        List<String> res= Arrays.asList(s1);
        return res;

    }

    //����
    public int cal(List<String> list){
        Stack<String> stack=new Stack<String>();
        for(String s: list){
            if(s.matches("\\d+")){
                stack.push(s);
            }else{
                int pop = Integer.parseInt(stack.pop());
                int pop1 = Integer.parseInt(stack.pop());
                int res=0;
                if(s.equals("+")){
                    res=pop+pop1;
                }if(s.equals("-")){
                    res=pop1-pop;
                }if(s.equals("*")){
                    res=pop*pop1;
                }if(s.equals("/")){
                    res=pop1/pop;
                }
                stack.push(""+res);
            }
        }
        return Integer.parseInt(stack.pop());

    }


    //����׺���ʽתΪ��׺���ʽ 1 + ( ( 2 + 3 )�� 4) - 5
    public int  turnToRePoLand(String s) throws Exception {

        List<String> strings = toInfixExpression(s);
        List<String> strings1 = parseSuffixExpression(strings);
        for(String s3:strings1){
            System.out.printf(s3);
        }
        return Operation1.cal(strings1);

    }
    public List<String> toInfixExpression(String infixExpression) {
        List<String> ls = new ArrayList<String>();//�洢������ʽ
        int i = 0;
        String str;
        char c;
        do {
            //���c �� < 48 ���� > 57 ˵���Ƿ���, ����û���ж��� + , - , * , / �ȵ�
            if ((c = infixExpression.charAt(i)) < 48 || (c = infixExpression.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else { // ˵�������֣�Ҫ����ƴ�Ӵ���
                str = "";
                while (i < infixExpression.length() && (c = infixExpression.charAt(i)) >= 48
                        && (c = infixExpression.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                ls.add(str);
            }

        } while (i < infixExpression.length());
        return ls;
    }


    public List<String> parseSuffixExpression(List<String> infixExpression){
        Stack<String> s1=new Stack<String>();
        Stack<String> s2=new Stack<String>();
        List<String> lss = new ArrayList<String>();
        for(String s:infixExpression){
            //����
            if(s.matches("\\d+")){
                lss.add(s);
            }else if(s.equals("(")){
                s1.push(s);
            }else if(s.equals(")")){
                if(s1.size()>0){
                    while (!s1.peek().equals("(")) {
                        lss.add(s1.pop());
                    }
                    s1.pop();
                }

                //s1.pop();
            }else{//������
                if(s1.size()!= 0 && Operation1.getValue(s1.peek())>=Operation1.getValue(s)){
                    lss.add(s1.pop());
                }else{
                    s1.push(s);
                }
            }
        }
        while (s1.size() != 0){
            lss.add(s1.pop());
        }
        return lss;
    }
}


class ArrayStack3{
    public int maxSize;
    public int top=-1;
    public int[] stack;

    static final int LEVEL_01 = 1;
    /**
     * �˳� * /
     */
    static final int LEVEL_02 = 2;

    /**
     * ����
     */
    static final int LEVEL_HIGH = Integer.MAX_VALUE;


    public ArrayStack3(int maxSize) {
        this.maxSize = maxSize;
        stack=new int[maxSize];
    }

    public Boolean isEmpty(){
        return top == -1;
    }

    public Boolean isFull(){
        return top == maxSize -1;
    }
    //��ջ
    public void push(int value) throws Exception {
        if(isFull()){
            //System.out.println("ջ�����޷��ټ���");
            System.out.println("ջ�����޷��ټ���~~~");
            return;
            //throw new Exception("ջ�����޷��ټ���");
        }
        top++;
        stack[top]=value;
    }

    //��ջ
    public Integer pop() throws Exception {
        if(isEmpty()){
            System.out.println("ջ�����޷��ټ���");
            return null;
        }
        //top++;
        int value=stack[top];
        top--;
        return value;

    }

    public int peek(){
        return stack[top];
    }

    //��ջ
    public void list() throws Exception {
        if(isEmpty()){
            throw new Exception("ջ�գ��޷���ջ����");
        }

        for(int i=0;i<=top;i++){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
    public int getMaxSize() {
        return maxSize;
    }


    public Boolean isNumber(char c){
        return  Character.isDigit(c);
    }

    public Boolean isOperate(int oper){
        return oper == '+' || oper== '-' || oper == '*' || oper == '/'|| oper == '('|| oper == ')';
    }

    public int isPriority(int c){
        if( c == '+' || c== '-'){
            return 0;
        }if(c == '*' || c == '/' ){
            return 1;
        }if(c == '('|| c == ')'){
            return 2;
        }else{
            return -1;
        }
    }

    public int cal(int num1,int num2,int op){
        int res = 0; // res ���ڴ�ż���Ľ��
        switch (op){
            case '+': res= num1+num2;break;
            case '-':res=  num2-num1;break;
            case '*':res=  num1*num2;break;
            case '/':res=  num2/num1;break;
            default:break;
        }
        return res;
    }

    public int getTop() {
        return top;
    }

    public int[] getStack() {
        return stack;
    }
}

class Operation1 {
    private static int ADDITION=1;
    private static int SUBTRACTION=1;
    private static int MULTIPLICATION=2;
    private static int DIVISION=2;

    public static int getValue(String operation){
        int result;
        switch (operation){
            case "+":
                result=ADDITION;
                break;
            case "-":
                result=SUBTRACTION;
                break;
            case "*":
                result=MULTIPLICATION;
                break;
            case "/":
                result=DIVISION;
                break;
            default:
//                System.out.println("�����ڸ������");
                result=0;
        }
        return result;
    }

    public static int cal(List<String> operation){
        Stack<String> stack=new Stack<>();
        for(String s:operation){
            if (s.matches("\\d+")) {
                stack.push(s);
            }else{
                int num1=Integer.parseInt(stack.pop());
                int num2=Integer.parseInt(stack.pop());
                int res = 0; // res ���ڴ�ż���Ľ��
                if(s.equals("+")){
                    res= num1+num2;
                }else if(s.equals("-")){
                    res= num2-num2;
                }else if(s.equals("*")){
                    res= num1*num2;
                }else if(s.equals("/")){
                    res= num2/num1;
                }else {
                    throw new RuntimeException("���Ŵ���");
                }
                stack.push(""+res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}


