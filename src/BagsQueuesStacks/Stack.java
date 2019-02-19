package BagsQueuesStacks;

import java.util.Iterator;

/*��ѹ��ջ(����ʵ��)*/
public class Stack<Item> implements Iterable<Item>{
	private Node first;		//ջ��(�����ӵ�Ԫ��)
	private int N;			//Ԫ������
	private class Node{
		//�����˽���Ƕ����
		Item item;
		Node next;
	}
	public boolean isEmpty(){
		return first == null;		// or N == 0
	}
	public int size(){
		return N;
	}
	public void push(Item item){
		//��ջ�����Ԫ��
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	public Item pop(){
		//��ջ��ɾ��Ԫ��
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	public Item peek(){
		Item item = first.item;
		return item;	
	}
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item>{
		private Node current = first;
		public boolean hasNext(){
			return current != null;
		}
		public void remove(){}
		public Item next(){
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
}
