package BagsQueuesStacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

import algorithms.StdIn;

public class List<Item> implements Iterable<Item>{

	private Node first;
	private Node last;
	private int N;
	private class Node{
		Item item;
		Node next;
	}
	
	public List(){
		first = null;
		last = null;
	}
	
    public List(Item[] a){
        for (Item t : a)
            append(t);
    }

    public List(Iterable<Item> coll){
        for (Item t : coll)
            append(t);
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return N;     
    }
    
    public Item first(){
        if (isEmpty()) throw new RuntimeException("List is empty");
        return first.item;
    }
    
    public Item last(){
        if (isEmpty()) throw new RuntimeException("List is empty");
        return last.item;
    }
    
    public Item removeFirst(){
        if (isEmpty()) throw new RuntimeException("List is empty");
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }
    
    public void prepend(Item item){
        Node x = new Node();
        x.item = item;
        if (isEmpty()) { first = x;      last = x;  }
        else           { x.next = first; first = x; }
        N++;
    }

    public void append(Item item){
        Node x = new Node();
        x.item = item;
        if (isEmpty()) { first = x;     last = x; }
        else           { last.next = x; last = x; }
        N++;
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    } 
 
    public Iterator<Item> iterator(){
        return new ListIterator();  
    }

    private class ListIterator implements Iterator<Item>{
        private Node current = first;

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next()
        {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
    /*****************
     * Exercise 1.3.19
     * ***************/
	public Item removeLast(){
		if(isEmpty())
			throw new RuntimeException("List is empty");
		Item item = last.item;
		Node prev = null,curr = first;
		while(curr.next != null){
			prev = curr;
			curr = curr.next;
		}
		prev.next = null;
		last = prev;
		N--;
		return item;
	}
    /*****************
     * Exercise 1.3.20
     * ***************/
	public Item delete(int k){
		if(isEmpty())
			throw new RuntimeException("List is empty");
		int i = 1;
		Node prev = null, curr = first;
		if(size() >= k){
			while(i < k){
				prev = curr;
				curr = curr.next;
				i++;
			}
			if(curr.next == null){
				prev.next = null;
				last = prev;
			}else{
				prev.next = curr.next;
				curr.next = null;
			}
			
		}else{
			throw new RuntimeException("k > N");
		}
		N--;
		return curr.item;
	}
    /*****************
     * Exercise 1.3.21
     * ***************/
	public boolean find(Item key){
		Node curr = first;
		while(curr.next != null && !curr.item.equals(key)){
			curr = curr.next;
		}
		return curr != null;
	}
    /*****************
     * Exercise 1.3.21
     * ***************/
	public static void main(String[] args) {
		List<String> l = new List<>();
		int i = 7;
		while(!StdIn.isEmpty()){
			String item = StdIn.readString();
			l.append(item);
		}
		System.out.println(l.delete(i) + "," + l.size());
	}
	
}
