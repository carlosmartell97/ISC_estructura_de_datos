package Utilities;

public class Conversion {
	protected static ArrayLinearList<Character> listReturned;
	protected static ArrayLinearList<Character> operators;
	protected static char item;
	
	public static ArrayLinearList<Character> Recursive(ArrayLinearList<Character> list){
		listReturned=new ArrayLinearList<Character>();
		operators=new ArrayLinearList<Character>();
		Recursive(0,list);
		for(int i=0;i<operators.size;i++){
			listReturned.add(listReturned.size, operators.get(i));
		}
		return listReturned;
	}
	protected static void Recursive(int position,ArrayLinearList<Character> list){
		if(position<list.size){
			System.out.println("CALL");
			if(position%2==0){
				listReturned.add(listReturned.size, list.element[position]);
			}else{
				operators.add(operators.size, list.element[position]);
			}
			Recursive(position+1,list);
		}
	}
	
	public static void main(String[] args) {
		ArrayLinearList<Character> lista=new ArrayLinearList<Character>();
		lista.add(0, '5');
		lista.add(0, '4');
		lista.add(0, '3');
		System.out.println(lista);
		//Recursive(lista);
	}
}
