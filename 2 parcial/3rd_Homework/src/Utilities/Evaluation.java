package Utilities;

public class Evaluation {
	private static int result;
	private static ChainLinearList<Character> chainOperators;
	private static ChainLinearList<Character> chainOperands;
	
	public static int Recursive(ChainLinearList<Character> chain){
		result=0;
		chainOperators=new ChainLinearList<Character>();
		chainOperands=new ChainLinearList<Character>();
		
		Recursive(0,chain);
		result=Character.getNumericValue(chainOperands.remove(0));
		while(!chainOperators.isEmpty()){
			System.out.println("NOT EMPTY");
			if(chainOperators.remove(0)=='+'){
				result+=Character.getNumericValue(chainOperands.remove(0));
			}else{
				result-=Character.getNumericValue(chainOperands.remove(0));
			}
		}
		return result;
	}
	
	private static void Recursive(int position,ChainLinearList<Character> chain2){
		if(position<chain2.size){
			System.out.println("CALL");
			if(position<chain2.size/2){
				chainOperators.add(chainOperators.size, chain2.get(position));
			}else{
				chainOperands.add(chainOperands.size, chain2.get(position));
			}
			Recursive(position+1,chain2);
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
		
		System.out.println(Recursive(chain));;
	}
}
