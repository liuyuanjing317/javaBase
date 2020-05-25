package com.lyj.structure;




public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		// ����
		System.out.println("˫������Ĳ���");
		// �ȴ����ڵ�
		HeroNode2 hero1 = new HeroNode2(1, "�ν�", "��ʱ��");
		HeroNode2 hero2 = new HeroNode2(2, "¬����", "������");
		HeroNode2 hero3 = new HeroNode2(3, "����", "�Ƕ���");
		HeroNode2 hero4 = new HeroNode2(4, "�ֳ�", "����ͷ");
		// ����һ��˫������
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		doubleLinkedList.add(hero1);
		doubleLinkedList.add(hero2);
		doubleLinkedList.add(hero3);
		doubleLinkedList.add(hero4);

		doubleLinkedList.list();

		// �޸�
		HeroNode2 newHeroNode = new HeroNode2(4, "����ʤ", "������");
		doubleLinkedList.update(newHeroNode);
		System.out.println("�޸ĺ���������");
		doubleLinkedList.list();

		// ɾ��
		doubleLinkedList.del(3);
		System.out.println("ɾ������������~~");
		doubleLinkedList.list();



	}

}

class DoubleLinkedList{
	private HeroNode2 head=new HeroNode2(0,"","");
	public void list(HeroNode2 node){}
	public void update(HeroNode2 node){
		HeroNode2 tmp=head.next;
		// �ҵ�
		Boolean flag = false;
		while(true){
			if(tmp.no == node.no){
				// �ҵ�
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
		} else { // û���ҵ�
			System.out.printf("û���ҵ� ��� %d �Ľڵ㣬�����޸�\n", node.no);
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
		// �ж������Ƿ�Ϊ��
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		// ��Ϊͷ�ڵ㣬���ܶ������������Ҫһ����������������
		HeroNode2 temp = head.next;
		while (true) {
			// �ж��Ƿ��������
			if (temp == null) {
				break;
			}
			// ����ڵ����Ϣ
			System.out.println(temp);
			// ��temp���ƣ� һ��С��
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
			//�ҵ�
			if(temp.no == no ){
				// �ҵ��Ĵ�ɾ���ڵ��ǰһ���ڵ�temp
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
