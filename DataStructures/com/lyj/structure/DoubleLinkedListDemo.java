package com.lyj.structure;




public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		// 测试
		System.out.println("双向链表的测试");
		// 先创建节点
		HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
		HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
		HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
		HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
		// 创建一个双向链表
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		doubleLinkedList.add(hero1);
		doubleLinkedList.add(hero2);
		doubleLinkedList.add(hero3);
		doubleLinkedList.add(hero4);

		doubleLinkedList.list();

		// 修改
		HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
		doubleLinkedList.update(newHeroNode);
		System.out.println("修改后的链表情况");
		doubleLinkedList.list();

		// 删除
		doubleLinkedList.del(3);
		System.out.println("删除后的链表情况~~");
		doubleLinkedList.list();



	}

}

class DoubleLinkedList{
	private HeroNode2 head=new HeroNode2(0,"","");
	public void list(HeroNode2 node){}
	public void update(HeroNode2 node){
		HeroNode2 tmp=head.next;
		// 找到
		Boolean flag = false;
		while(true){
			if(tmp.no == node.no){
				// 找到
				flag = true;
				break;
			}
			if(tmp.next == null){
				break;
			}
			tmp=tmp.next;
		}
		if (flag) {
			tmp.name = node.name;
			tmp.nickName = node.nickName;
		} else { // 没有找到
			System.out.printf("没有找到 编号 %d 的节点，不能修改\n", node.no);
		}
	}
	public void add(HeroNode2 node){
		HeroNode2 tmp=head;
		while(true){
			if(tmp.next == null){
				break;
			}
			tmp=tmp.next;
		}
		tmp.next=node;

		node.pre=tmp;
	}
	public void list(){
		// 判断链表是否为空
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		// 因为头节点，不能动，因此我们需要一个辅助变量来遍历
		HeroNode2 temp = head.next;
		while (true) {
			// 判断是否到链表最后
			if (temp == null) {
				break;
			}
			// 输出节点的信息
			System.out.println(temp);
			// 将temp后移， 一定小心
			temp = temp.next;
		}
	}

	public void del(int no){
		HeroNode2 temp = head.next;
		HeroNode2 node = null;
		Boolean flag = false;
		while (true){
			if(temp == null){
				break;
			}
			//找到
			if(temp.no == no ){
				// 找到的待删除节点的前一个节点temp
				flag = true;
				break;
			}
			temp=temp.next;
		}
		if(flag){
			temp.pre.next=temp.next;
			if(temp.next != null){
				temp.next.pre=temp.pre;
			}
		}
	}
}
class HeroNode2{
	public int no;
	public String name;
	public String nickName;
	public HeroNode2 next;
	public HeroNode2 pre;

	public HeroNode2(int no, String name, String nickName) {
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickName + "]";
	}

}
