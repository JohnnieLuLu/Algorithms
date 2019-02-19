package BagsQueuesStacks;

import algorithms.StdIn;
import algorithms.StdOut;

public class E15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 4;
		Queue<String> queue = new Queue<>();
		while(!StdIn.isEmpty()){
			String item = StdIn.readString();
			queue.enqueue(item);
		}
		StdOut.println(queue.reciprocal(k));
	}

}
