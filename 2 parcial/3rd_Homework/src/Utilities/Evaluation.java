package Utilities;

public class Evaluation {
	public static ChainLinearList<Character> Recursive(ChainLinearList<Character> chain){
		Recursive(0,chain);
		return null;
	}
	
	private static void Recursive(int position,ChainLinearList<Character> chain){
		if(position<chain.size){
			System.out.println("CALL");
			Recursive(position+1,chain);
		}
	}
	
	public static void main(String[] args) {
		ChainLinearList<Character> chain=new ChainLinearList<Character>();
		chain.add(0, '3');
		chain.add(0, '2');
		chain.add(0, '1');
		chain.add(0, '-');
		chain.add(0, '+');
		System.out.println(chain);
		Recursive(chain);
	}
}
