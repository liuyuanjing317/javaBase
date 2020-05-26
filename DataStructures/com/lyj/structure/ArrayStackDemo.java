package com.lyj.structure;

/**
 * @author: liuyuanjing
 * @date:
 * @version: 2.0.0
 * @description: 栈
 **/
public class ArrayStackDemo {

    public static void main(String[] args) throws Exception {
        ArrayStack arrayStack=new ArrayStack(5);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(5);
        arrayStack.push(6);
        arrayStack.push(7);
        arrayStack.push(8);
        arrayStack.list();
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());




    }

}

class ArrayStack{
    public int maxSize;
    public int top=-1;
    public int[] stack;

    public ArrayStack(int maxSize) {
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

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int[] getStack() {
        return stack;
    }

    public void setStack(int[] stack) {
        this.stack = stack;
    }
}
