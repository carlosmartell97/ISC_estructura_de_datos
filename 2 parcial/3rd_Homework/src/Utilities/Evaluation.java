//	ya funciona el Recursive() e Iterative(). me falta:
//				-	todo lo que sigue en Homework3...
package Utilities;

import java.util.Stack;

public class Evaluation {
	private static int result;
	private static ChainLinearList<Character> chainOperators;
	private static ChainLinearList<Character> chainOperands;
	private static Stack<Character> stackOperators;
	private static Stack<Character> stackOperands;
	
	public static int Recursive(ChainLinearList<Character> chain){
		result=0;
		chainOperators=new ChainLinearList<Character>();
		chainOperands=new ChainLinearList<Character>();
		
		Recursive(0,chain);
		result=Character.getNumericValue(chainOperands.remove(0));
		//result=1;
		
		System.out.println("Operators:");
		for(int i=0;i<chainOperators.size;i++){
			System.out.println(chainOperators.get(i));
		}
		System.out.println("Operands:");
		for(int i=0;i<chainOperands.size;i++){
			System.out.println(chainOperands.get(i));
		}
		
		//System.out.println("res:"+result);
		while(!chainOperators.isEmpty()){
			//System.out.println("NOT EMPTY");
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
			//System.out.println("CALL");
			
			//System.out.print(position+" ");
			//System.out.println(chain2.get(position));
			
			if(position<chain2.size/2){
				chainOperators.add(chainOperators.size, chain2.get(position));
				//System.out.println("add oprtr"+chain2.get(position));
			}else{
				chainOperands.add(chainOperands.size, chain2.get(position));
				//System.out.println("add OPERAND"+chain2.get(position));
			}
			Recursive(position+1,chain2);
		}
	}
	
	public static int Iterative(ChainLinearList<Character> chain){
		result=0;
		stackOperands=new Stack<Character>();
		stackOperators=new Stack<Character>();
		for(int i=chain.size-1;i>=0;i--){
			//System.out.println("i:"+i);
			if(i>=chain.size/2){
				stackOperands.push(chain.get(i));
			}else{
				stackOperators.push(chain.get(i));
			}
		}
		
		System.out.println("Operators: "+stackOperators);
		System.out.println("Operands: "+stackOperands);
		result=Character.getNumericValue((char) stackOperands.pop());
		while(!stackOperators.isEmpty()){
			if(stackOperators.pop()=='+'){
				result+=Character.getNumericValue(stackOperands.pop());
			}else{
				result-=Character.getNumericValue(stackOperands.pop());
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		ChainLinearList<Character> chain=new ChainLinearList<Character>();
		chain.add(0, '1');
		chain.add(0, '2');
		chain.add(0, '3');
		chain.add(0, '-');
		chain.add(0, '+');
		System.out.println(chain);
		
		System.out.println("result:"+Iterative(chain));;
	}
}
