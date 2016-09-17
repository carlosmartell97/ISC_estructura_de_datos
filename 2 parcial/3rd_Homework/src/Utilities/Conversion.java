package Utilities;

public class Conversion {
	
	public static void Recursive(ArrayLinearList<Character> list){
		ArrayLinearList<Character> listReturned=new ArrayLinearList<Character>();
		ArrayLinearList<Character> operators=new ArrayLinearList<Character>();
		
		Recursive(list.size,list);
	}
	protected static void Recursive(int position,ArrayLinearList<Character> list){
		if(position<list.size-1){
			System.out.println("call");
			Recursive(position+1,list);
		}
	}
	
	public static void main(String[] args) {
		ArrayLinearList<Character> lista=new ArrayLinearList<Character>();
		Recursive(lista);
	}
}
