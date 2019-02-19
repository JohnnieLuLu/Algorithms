package BagsQueuesStacks;

import algorithms.StdIn;
import algorithms.StdOut;

public class E4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> s = new Stack<>();
		while(!StdIn.isEmpty()){
			String item = StdIn.readString();
			/*if(!item.equals("-"))
				s.push(item);
			else if(!s.isEmpty())
				StdOut.print(s.pop() + " ");*/
			if(item.equals("(")||item.equals("[")||item.equals("{"))
				s.push(item);
			else if(item.equals(")")){
				if(s.pop().equals("("))
					continue;
				else
					StdOut.println("not match");
			}
			else if(item.equals("]")){
				if(s.pop().equals("["))
					continue;
				else
					StdOut.println("not match");
			}
			else if(item.equals("}")){
				if(s.pop().equals("{"))
					continue;
				else
					StdOut.println("not match");
			}
				
				
		}
		//StdOut.println("(" + s.size() + "left on stack)");
	}

}
