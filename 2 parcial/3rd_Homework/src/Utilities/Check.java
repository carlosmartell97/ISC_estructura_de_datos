//		ya quedó, y funciona todo.
package Utilities;

import Utilities.ChainLinearList.ChainNode;

public class Check {
	private static Stack<Character> unos; 
	public static boolean Iterative(ChainLinearList<Character> chain){
		if(chain.isEmpty()){
			throw new IllegalArgumentException("chain is empty");
		}
		if(chain.size%2!=0){
			return false;
		}
		unos=new Stack<Character>();
		ChainNode<Character> temp=chain.firstNode;
		while(temp.next!=null){
			if(temp.element=='1'){
				unos.push(temp.element);
			}
			temp=temp.next;
		}
		return unos.size()==chain.size/2;
	}
	
	public static void main(String[] args) {
		/*ChainLinearList<Character> test=new ChainLinearList<Character>();
		test.add(0, '1');
		test.add(1, '0');
		test.add(2, '1');
		test.add(3, '0');
		test.add(4, '0');
		test.add(5, '1');
		
		System.out.println(Iterative(test));*/
	}
}
