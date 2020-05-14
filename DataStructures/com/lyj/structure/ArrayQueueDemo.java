package com.lyj.structure;


import java.util.Random;

/**
 * @author: liuyuanjing
 * @date:
 * @version: 2.0.0
 * @description:
 **/
public class ArrayQueueDemo {

    public static void main(String[] args) throws Exception {
        int max=5;
        ArrayQueue aq=new ArrayQueue(max);
        for(int i=0;i<5;i++){
            aq.addQueue(new Random().nextInt());
        }
        System.out.println("showQueue");
        aq.showQueue();
        System.out.println("popQueue");
        System.out.println(aq.popQueue());
        System.out.println(aq.popQueue());
        System.out.println(aq.popQueue());
        System.out.println("headQueue");
        System.out.println(aq.headQueue());
        aq.showQueue();

    }
}
class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr=new int[maxSize];
        this.front=-1;//ָ��ͷ��
        this.rear=-1;//ָ��β��
    }
    public  boolean isFull(){
        return this.rear==this.maxSize-1;
    }
    public  boolean isEmpty(){
        return this.rear==this.front;
    }
    public  void addQueue(int n){
        //����δ��
        if(isFull()){
            System.out.printf("��������");
            return;
        }
        rear++;//��β����
        arr[rear]=n;
    }
    public  int popQueue() throws Exception {
        //����δ��
        if(isEmpty()){
            throw new Exception("����Ϊ��");
        }
        front++;//��β����
        return arr[front];
    }

    public  void printQueue() {
        for(int i : arr){
            System.out.println("�������ݣ�");
            System.out.print(i);
        }
    }
    // ��ʾ���е���������
    public void showQueue() {
        // ����
        if (isEmpty()) {
            System.out.println("���пյģ�û������~~");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }
    // ��ʾ���е�ͷ���ݣ� ע�ⲻ��ȡ������
    public int headQueue() {
        // �ж�
        if (isEmpty()) {
            throw new RuntimeException("���пյģ�û������~~");
        }
        return arr[front + 1];
    }

}
