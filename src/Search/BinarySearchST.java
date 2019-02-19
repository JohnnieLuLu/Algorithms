package Search;

import algorithms.StdIn;
import algorithms.StdOut;
import BagsQueuesStacks.Queue;

public class BinarySearchST<Key extends Comparable<Key>, Value>{
	private Key[] keys;
	private Value[] vals;
	private int N;
	
	public BinarySearchST(int capacity) {
		keys = (Key[])new Comparable[capacity];
		vals = (Value[])new Object[capacity];
	}
	
	private void resize(int max){
		Key[] temp_key = (Key[]) new Comparable[max];
		Value[] temp_val = (Value[]) new Object[max];
		for(int i = 0; i < N; i++){
			temp_key[i] = keys[i];
			temp_val[i] = vals[i];
		}
		keys = temp_key;
		vals = temp_val;
	}
	
	public Value get(Key key){
		if(isEmpty())	return null;
		int i = rank(key);
		if(i < N && keys[i].compareTo(key) == 0)
			return vals[i];
		else
			return null;
	}
	
	public void put(Key key, Value val){
		if(N == keys.length)	resize(2*keys.length);
		int i = rank(key);
		if(i < N && keys[i].compareTo(key) == 0){
			vals[i] = val;
			return;
		}
		for(int j = N; j > i; j--){
			keys[j] = keys[j-1];
			vals[j] = vals[j-1];
		} 
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	
	public int rank(Key key){
		int lo = 0, hi = N - 1;
		while(lo <= hi){
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			if(cmp < 0)
				hi = mid - 1;
			else if(cmp > 0)
				lo = mid +1;
			else
				return mid;
		}
		return lo;
	}
	
	public void delete(Key key){
		if(isEmpty())	StdOut.println("Empty!!!");
		int i = rank(key);
		if(i < N && keys[i].compareTo(key) == 0){
			for(int j = i; j < N; j++){
				keys[j] = keys[j + 1];
				vals[j] = vals[j + 1];
			}
		}
		else
			StdOut.println("Not exist!!");
	}
	
	public int size(){
		return N;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public Key min(){
		return keys[0];
	}
	
	public Key max(){
		return keys[N - 1];
	}
	
	public Key select(int k){
		return keys[k];
	}
	
	public Key ceiling(Key key){
		int i = rank(key);
		return keys[i + 1];
	}
	
	public Key floor(Key key){
		int i = rank(key);
		return keys[i - 1];
	}
	
	public boolean contains(Key key){
		int i = rank(key);
		if(i < N && keys[i].compareTo(key) == 0)
			return true;
		else
			return false;
	}
	
	public Iterable<Key> keys(Key lo, Key hi){
		Queue<Key> q = new Queue<Key>();
		for(int i = rank(lo); i < rank(hi); i++)
			q.enqueue(keys[i]);
		if(contains(hi)){
			q.enqueue(keys[rank(hi)]);
		}
		return q;
	}
	
	public Iterable<Key> keys(){
		Queue<Key> q = new Queue<>();
		for(int i = 0; i < N; i++)
			q.enqueue(keys[i]);
		return q;
	}
	
	public static void main(String[] args) {
		BinarySearchST<String, Integer> bst = new BinarySearchST<>(20);
		for(int i = 0; !StdIn.isEmpty(); i++){
			String word = StdIn.readString();
			bst.put(word, i);
		}
		
		/*for(String s : bst.keys()){
			StdOut.println(s + "_" + bst.get(s));
		}*/
		
		StdOut.println(bst.size());
		bst.delete(bst.select(1));
		for(String s : bst.keys()){
			StdOut.println(s + "_" + bst.get(s));
		}
	}
}
