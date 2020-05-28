package com.lyj.structure;

/**
 * @author: liuyuanjing
 * @date:
 * @version: 2.0.0
 * @description: ����ջ������ѧ��ʽ
 **/
public class Calculator {

    //������ʽ��ֵ
    public static void main(String[] args) throws Exception {
        String str="70+3*6-5";
        ArrayStack2 numStack=new ArrayStack2(10);
        ArrayStack2 opStack=new ArrayStack2(10);
        int index =0;//�±�
        int num1;
        int num2;
        int op;
        char ch=' ';
        String keepNum = ""; //����ƴ�� ��λ��
        int res = 0;
        while(true){
            ch=str.substring(index,index+1).charAt(0);
            //�ж��Ƿ��ǲ�����
            if(opStack.isOperate(ch)){ // �ǲ��������������ջΪ��ʱֱ����ջ��2��ջ��λ��ʱ����ջ���Ĳ������Ƚ����ȼ���
                // ���ȼ��ߵ�����£�Ҫ�����������������Ӧ�����ݽ��в������������������������ջ
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

            }else{ //Ϊ���ֵ������ 1.�ж��Ƿ���������λ��

                keepNum+=ch;

                //�ж��Ƿ������һλ
                if(index == str.length()- 1){
                    numStack.push(Integer.parseInt(keepNum));
                    keepNum="";
                }else{
                    //�ж������Ƿ��Ѿ�����
                    if(numStack.isOperate(str.substring(index+1,index+2).charAt(0))){
                        //�����һλ�������������ջ keepNum = "1" ���� "123"
                        numStack.push(Integer.parseInt(keepNum));
                        //��Ҫ��!!!!!!, keepNum���
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

        //����ջ���������pop�������ǽ��
        int res2 = numStack.pop();
        System.out.printf("���ʽ %s = %d ", str, res2);
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




