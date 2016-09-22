//	me falta:
//		- deshacerme del CastException en Iterative()
//		- comparar la complejidad de Recursive() vs Iterative() y poner los resultados
//			en un "Readme1.txt"
package Utilities;

import java.util.Stack;

public class Conversion {
	protected static ArrayLinearList<Character> listReturned;
	protected static Stack<Character> stackFlip;
	protected static char item;
	
	public static ArrayLinearList<Character> Recursive(ArrayLinearList<Character> list){
		if(list.isEmpty()){
			return null;
		}
		listReturned=new ArrayLinearList<Character>();
		Recursive(0,list);
		return listReturned;
	}
	private static void Recursive(int position,ArrayLinearList<Character> list){
		if(position<list.size){
			Recursive(position+1,list);
			listReturned.add(listReturned.size, list.get(position));
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
		lista.add(0, '3');
		lista.add(0, '2');
		lista.add(0, '1');
		lista.add(0, '-');
		lista.add(0, '+');
		System.out.println(lista);
		
		//System.out.println(Recursive(lista));;
		System.out.println(Iterative(lista));;
	}
}
