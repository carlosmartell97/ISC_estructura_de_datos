package Utilities;

public class Conversion {
	protected static ArrayLinearList<Character> listReturned=new ArrayLinearList<Character>();
	protected static ArrayLinearList<Character> operators=new ArrayLinearList<Character>();
	protected static char item;
	
	public static void Recursive(ArrayLinearList<Character> list){
		Recursive(0,list);
	}
	protected static void Recursive(int position,ArrayLinearList<Character> list){
		if(position<list.size){
			System.out.println("CALL");
			//item=new Character((Character)list.element[position]);
			//item=Object.toString().charAt(item);
			
			if(Character.isAlphabetic(list.remove(0))){
				System.out.println("true");
			}
			Recursive(position+1,list);
		}
	}
	
	public static void main(String[] args) {
		ArrayLinearList<Character> lista=new ArrayLinearList<Character>();
		lista.add(0, '5');
		lista.add(0, '4');
		lista.add(0, '3');
		Recursive(lista);
		System.out.println(lista);
	}
}
