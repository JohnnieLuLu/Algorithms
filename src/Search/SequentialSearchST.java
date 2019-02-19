package Search;

import algorithms.StdIn;
import algorithms.StdOut;
import BagsQueuesStacks.List;

public class SequentialSearchST<Key,Value> {
	private Node first;
	private int N;
	
	private class Node{
		Key key;
		Value val;
		Node next;
	
	public Node(Key key, Value val, Node next){
		this.key = key;
		this.val = val;
		this.next = next;
		}
	}
	
	public Value get(Key key){
		for(Node x = first; x != null; x = x.next)
			if(key.equals(x.key))
				return x.val;		//命中
		return null;				//未命中
	}
	
	public void put(Key key, Value val){
		for(Node x = first; x != null; x = x.next)
			if(key.equals(x.key)){
				x.val = val;				//命中，更新
				return;
			}
		first = new Node(key, val, first);	//未命中，新建新结点
	}
	
	public int size(){
		for(Node x = first; x != null; x = x.next){
			N++;
		}
		return N;
	}
	
	public Iterable<Key> keys(){
		List l = new List<>();
		for(Node x = first; x != null; x = x.next){
			l.append(x.key);
		}
		return l;
	}
	
	public void delete(Key key){
		for(Node x = first; x != null; x = x.next){
			if(key.equals(x.key)){
				x.next = x.next.next;
			}
		}
	}
	
	public static void main(String[] args) {
		SequentialSearchST<String, Integer> sst = new SequentialSearchST<>();
		for(int i = 0; !StdIn.isEmpty(); i++){
			String word = StdIn.readString();
			sst.put(word, i);
		}
		
		for(String s : sst.keys()){
			StdOut.println(s + "_" + sst.get(s));
		}
		
		StdOut.println(sst.size());
	}
}
