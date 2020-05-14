package com.lyj.structure;

import java.util.Random;

/**
 * @author: liuyuanjing
 * @date:
 * @version: 2.0.0
 * @description: ���ζ���
 **/
public class CircleQueueDemo {
    public static void main(String[] args) throws Exception{
        CircleQueue cq=new CircleQueue(10);
        for(int i=0;i<6;i++){
            cq.addQueue(new Random().nextInt());
        }
        System.out.println("showQueue");
        cq.showQueue();
        System.out.println("popQueue");
        System.out.println(cq.popQueue());
        System.out.println(cq.popQueue());
        System.out.println(cq.popQueue());
        System.out.println("headQueue");
        System.out.println(cq.headQueue());
        cq.showQueue();
        for(int i=0;i<3;i++){
            cq.addQueue(new Random().nextInt());
        }
        System.out.println("modifyQueue");
        cq.showQueue();
        //System.out.println("headQueue");
        //System.out.println(cq.headQueue());
        System.out.println("last-modifyQueue");
        for(int i=0;i<5;i++){
            cq.addQueue(new Random().nextInt());
        }
        System.out.println("modifyQueue");
        cq.showQueue();
    }
}

class CircleQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleQueue(int maxSize) {
         this.maxSize =maxSize;
         arr=new int[maxSize];
    }

    //�����׺Ͷ�β���ʱ��2�������1�ǳ�ʼ���У�����Ϊ�գ�2�Ƕ�������װ������β�ص����׵�λ�ã��γɱջ����ж�Ϊ�ղ����Զ����Ƿ�������϶���
    public boolean isEmpty(){
        for(int i:arr){
            if(i!=0){
                return false;
            } ;
        }
        return  true;
    }
    //���ζ����ж϶�����
    public boolean isFull(){
        if(rear==front&&rear==0) {
            return false;
        }
        return (rear)%maxSize== front;
    }

    //��ȡ�������ж��ٸ���
    public int getNum(){
        return ( rear+ maxSize- front)%maxSize;
    }

    // ������ݵ�����
    public void addQueue(int n) {
        // �ж϶����Ƿ���
        if (isFull()) {
            System.out.println("�����������ܼ�������~");
            return;
        }

        //ֱ�ӽ����ݼ���
        arr[rear] = n;
        //�� rear ����, ������뿼��ȡģ
        rear = (rear+1) % maxSize;
    }
    public  int popQueue() throws Exception {
        //����δ��
        if(isEmpty()){
            throw new Exception("����Ϊ��");
        }
        int value =  arr[ front];
         arr[ front]=0;
         front = ( front+1)%maxSize;
        return value;
    }
    // ��ʾ���е���������
    public void showQueue() {
        // ����
        if (isEmpty()) {
            System.out.println("���пյģ�û������~~");
            return;
        }
        //�����ͷ��������������
        for (int i = 0; i <  maxSize; i++) {
            System.out.printf("arr[%d]=%d\n", i%maxSize,  arr[i%maxSize]);
        }
    }
    // ��ʾ���е�ͷ���ݣ� ע�ⲻ��ȡ������
    public int headQueue() {
        // �ж�
        if (isEmpty()) {
            throw new RuntimeException("���пյģ�û������~~");
        }
        return  arr[ front];
    }
}
