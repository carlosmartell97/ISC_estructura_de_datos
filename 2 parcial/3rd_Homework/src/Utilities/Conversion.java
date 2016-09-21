package Utilities;

public class Conversion {
	protected static ArrayLinearList<Character> listReturned;
	protected static ArrayLinearList<Character> listOperators;
	protected static Stack<Character> stackOperands;
	protected static Stack<Character> stackOperators;
	protected static char item;
	
	public static ArrayLinearList<Character> Recursive(ArrayLinearList<Character> list){
		if(list.isEmpty()){
			return null;
		}
		listReturned=new ArrayLinearList<Character>();
		listOperators=new ArrayLinearList<Character>();
		Recursive(list.size-1,list);
		for(int i=0;i<listOperators.size;i++){
			listReturned.add(listReturned.size, listOperators.get(i));
		}
		return listReturned;
	}
	private static void Recursive(int position,ArrayLinearList<Character> list){
		if(position>=0){
			//System.out.println("CALL");
			if(position%2==0){
				listReturned.add(listReturned.size, list.element[position]);
			}else{
				listOperators.add(listOperators.size, list.element[position]);
			}
			Recursive(position-1,list);
		}
	}
	
	public static ArrayLinearList<Character> Iterative(ArrayLinearList<Character> list){
		if(list.isEmpty()){
			return null;
		}
		listReturned=new ArrayLinearList<Character>();
		stackOperands=new Stack<Character>();
		stackOperators=new Stack<Character>();
		for(int i=0;i<list.size;i++){
			if(i%2==0){
				stackOperands.push(list.element[i]);
			}
			else{
				stackOperators.push(list.element[i]);
			}
		}
		while(!stackOperands.isEmpty()){
			listReturned.add(listReturned.size, stackOperands.pop());
		}
		while(!stackOperators.isEmpty()){
			listReturned.add(listReturned.size, stackOperators.pop());
		}
		return listReturned;
	}
	
	public static void main(String[] args) {
		ArrayLinearList<Character> lista=new ArrayLinearList<Character>();
		lista.add(0, '5');
		lista.add(0, '-');
		lista.add(0, '3');
		lista.add(0, '+');
		lista.add(0, '1');
		System.out.println(lista);
		//Recursive(lista);
		Iterative(lista);
	}
}
