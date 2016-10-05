//	me falta:
//			- comparar la complejidad de Recursive() vs Iterative() y poner los resultados
//			en un "Readme1.txt"
package Utilities;

import java.util.Stack;

public class Conversion {
	protected static ArrayLinearList<Character> listReturned;
	protected static ArrayLinearList<Character> operators;
	protected static ArrayLinearList<Character> operands;
	protected static Stack<Character> stackFlip;
	protected static char item;
	
	public static ArrayLinearList<Character> Recursive(ArrayLinearList<Character> list){
		if(list.isEmpty()){
			return null;
		}
		listReturned=new ArrayLinearList<Character>();
		operators=new ArrayLinearList<Character>();
		operands=new ArrayLinearList<Character>();
		Recursive(0,list);
		
		listReturned.add(0, operands.remove(0));
		while(!operators.isEmpty()){
			listReturned.add(listReturned.size, operands.remove(0));
			listReturned.add(listReturned.size, operators.remove(0));
		}
		return listReturned;
	}
	private static void Recursive(int position,ArrayLinearList<Character> list){
		if(position<list.size/2){
			Recursive(position+1,list);
			operators.add(listReturned.size, list.get(position));
		}
		else{
			if(position<list.size){
				Recursive(position+1,list);
				operands.add(listReturned.size, list.get(position));
			}
		}
	}
	
	public static ArrayLinearList<Character> Iterative(ArrayLinearList<Character> list){
		if(list.isEmpty()){
			return null;
		}
		
		listReturned=new ArrayLinearList<Character>();
		stackFlip=new Stack<Character>();
		for(int i=0;i<list.size;i++){
			stackFlip.push(list.element[i]);
		}
		while(!stackFlip.isEmpty()){
			listReturned.add(listReturned.size, stackFlip.pop());
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
		//System.out.println(Iterative(lista));;
	}
}
