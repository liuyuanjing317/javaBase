package com.lyj.structure;

/**
 * @author: liuyuanjing
 * @date:
 * @version: 2.0.0
 * @description: 利用栈计算数学算式
 **/
public class Calculator {

    //计算表达式的值
    public static void main(String[] args) throws Exception {
        String str="70+3*6-5";
        ArrayStack2 numStack=new ArrayStack2(10);
        ArrayStack2 opStack=new ArrayStack2(10);
        int index =0;//下标
        int num1;
        int num2;
        int op;
        char ch=' ';
        String keepNum = ""; //用于拼接 多位数
        int res = 0;
        while(true){
            ch=str.substring(index,index+1).charAt(0);
            //判断是否是操作符
            if(opStack.isOperate(ch)){ // 是操作符的情况；当栈为空时直接入栈；2当栈部位空时先与栈顶的操作符比较优先级，
                // 优先级高的情况下，要讲操作符弹出，与对应的数据进行操作，将操作后的数据入数字栈
                if(!opStack.isEmpty()){
                    if(opStack.isPriority(ch)<=opStack.isPriority(opStack.peek())){
                        num1=numStack.pop();
                        num2=numStack.pop();
                        op=opStack.pop();
                        res=opStack.cal(num1,num2,op);
                        numStack.push(res);
                        opStack.push(ch);
                    }else{
                        opStack.push(ch);
                    }

                }else{
                    opStack.push(ch);
                }

            }else{ //为数字的情况下 1.判断是否是连续多位数

                keepNum+=ch;

                //判断是否是最后一位
                if(index == str.length()- 1){
                    numStack.push(Integer.parseInt(keepNum));
                    keepNum="";
                }else{
                    //判断数字是否已经结束
                    if(numStack.isOperate(str.substring(index+1,index+2).charAt(0))){
                        //如果后一位是运算符，则入栈 keepNum = "1" 或者 "123"
                        numStack.push(Integer.parseInt(keepNum));
                        //重要的!!!!!!, keepNum清空
                        keepNum = "";
                    }
                }

            }
            index++;
            if(index>=str.length()){
                break;
            }
        }

        while (true){
           if(opStack.isEmpty()){
               break;
           }
           num1=numStack.pop();
           num2=numStack.pop();
           op=opStack.pop();
           res=numStack.cal(num1,num2,op);
           numStack.push(res);
        }

        //将数栈的最后数，pop出，就是结果
        int res2 = numStack.pop();
        System.out.printf("表达式 %s = %d ", str, res2);
    }


    //public void calculatorNormal(){}

}



class ArrayStack2{
    public int maxSize;
    public int top=-1;
    public int[] stack;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack=new int[maxSize];
    }

    public Boolean isEmpty(){
        return top == -1;
    }

    public Boolean isFull(){
        return top == maxSize -1;
    }
    //入栈
    public void push(int value) throws Exception {
        if(isFull()){
            //System.out.println("栈满，无法再加入");
            System.out.println("栈满，无法再加入~~~");
            return;
            //throw new Exception("栈满，无法再加入");
        }
        top++;
        stack[top]=value;
    }

    //出栈
    public Integer pop() throws Exception {
        if(isEmpty()){
            System.out.println("栈满，无法再加入");
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

    //出栈
    public void list() throws Exception {
        if(isEmpty()){
            throw new Exception("栈空，无法出栈数据");
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
        int res = 0; // res 用于存放计算的结果
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




