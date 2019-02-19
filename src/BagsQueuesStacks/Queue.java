package BagsQueuesStacks;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item>{
	private Node first;
	private Node last;
	private int N;
	private class Node{
		Item item;
		Node next;
	}
	public boolean isEmpty(){
		return first == null;
	}
	public int size(){
		return N;
	}
	public void enqueue(Item item){
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty())
			first = last;
		else
			oldlast.next = last;
		N++;
	}
	public Item dequeue(){
		Item item = first.item;
		first = first.next;
		if(isEmpty())
			last = null;
		N--;
		return item;
	}
	/*
	 *Exercise 1.3.15
	 */
	public Item reciprocal(int k){
		Node n = first;
		for(int i = 0 ; i < N-k; i++){
			n = n.next;
		}
		return n.item;
	}
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
