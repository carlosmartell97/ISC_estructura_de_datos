//	ya funciona y ya quedó todo.
package Utilities;

import java.util.Stack;

public class Conversion {
	protected static ArrayLinearList<Character> listReturned;
	protected static ArrayLinearList<Character> operatorsList;
	protected static ArrayLinearList<Character> operandsList;
	protected static Stack<Character> operatorsStack;
	protected static Stack<Character> operandsStack;
	protected static char item;
	
	public static ArrayLinearList<Character> Recursive(ArrayLinearList<Character> list){
		if(list.isEmpty()){
			return null;
		}
		listReturned=new ArrayLinearList<Character>();
		operatorsList=new ArrayLinearList<Character>();
		operandsList=new ArrayLinearList<Character>();
		Recursive(0,list);
		
		listReturned.add(0, operandsList.remove(0));
		while(!operatorsList.isEmpty()){
			listReturned.add(listReturned.size, operandsList.remove(0));
			listReturned.add(listReturned.size, operatorsList.remove(0));
		}
		return listReturned;
	}
	private static void Recursive(int position,ArrayLinearList<Character> list){
		if(position<list.size/2){
			Recursive(position+1,list);
			operatorsList.add(listReturned.size, list.get(position));
		}
		else{
			if(position<list.size){
				Recursive(position+1,list);
				operandsList.add(listReturned.size, list.get(position));
			}
		}
	}
	
	public static ArrayLinearList<Character> Iterative(ArrayLinearList<Character> list){
		if(list.isEmpty()){
			return null;
		}
		listReturned=new ArrayLinearList<Character>();
		operatorsStack=new Stack<Character>();
		operandsStack=new Stack<Character>();
		for(int i=list.size-1;i>=0;i--){
			if(i>=list.size/2){
				operandsStack.push(list.get(i));
			}else{
				operatorsStack.push(list.get(i));
			}
		}
		listReturned.add(0, operandsStack.pop());
		while(!operatorsStack.isEmpty()){
			listReturned.add(listReturned.size,operandsStack.pop());
			listReturned.add(listReturned.size, operatorsStack.pop());
		}
		return listReturned;
	}
	
	public static void main(String[] args) {
		ArrayLinearList<Character> lista=new ArrayLinearList<Character>();
		lista.add(0, 'D');
		lista.add(0, 'Z');
		lista.add(0, 'Y');
		lista.add(0, 'X');
		lista.add(0, '+');
		lista.add(0, '-');
		lista.add(0, '+');
		System.out.println(lista);
		
		System.out.println("res: "+Recursive(lista));;
		System.out.println("res: "+Iterative(lista));;
	}
}
