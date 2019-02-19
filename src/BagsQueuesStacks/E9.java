package BagsQueuesStacks;

import algorithms.StdIn;
import algorithms.StdOut;

public class E9 {
	  public static void main(String[] args) {

	        Stack<String> ops = new Stack<>();  // ����ջ
	        Stack<String> vals = new Stack<>(); // ��ֵջ,���ڲ���Ҫ����,��������ʹ��String,����double;

	        while (!StdIn.isEmpty()) {
	            String s = StdIn.readString();  // ��ȡ�ַ�����ÿ��һ�����Կո������

	            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
	                ops.push(s);
	            else if (s.equals(")")) {
	                // �˴������ߵ������ǡ������������������ǡ���������������
	                String expre = ")" + vals.pop() + ops.pop() + vals.pop() + "(";

	                // ע�⣬�������ʽ��Ϊһ�����壬Ҳ���ǵ����ַ���ѹ��ջ����
	                vals.push(expre);
	            } else
	                vals.push(s);
	        }

	        String result = vals.pop();
	        // output: result: )))6-5(*)4-3((*)2+1((
	        StdOut.println("result: " + result);

	        // ��������Ϊ˳��
	        String seq = "";
	        for (int i = result.length()-1; i >= 0; i--){
	            seq += result.charAt(i);
	        }

	        // output: seq: ((1+2)*((3-4)*(5-6)))
	        StdOut.println("seq: " + seq);

	    }
}
