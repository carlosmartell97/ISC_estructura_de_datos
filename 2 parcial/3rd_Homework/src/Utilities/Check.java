//		me falta:
//				-	todo éste, el problema 3 (Chain), y el 4 (Hash Tables)
package Utilities;

public class Check {
	private Stack<Character> unos; 
	public boolean Iterative(ChainLinearList<Character> list){
		if(list.size%2!=0){
			return false;
		}
		unos=new Stack<Character>();
		for(int i=0;i<list.size;i++){
			if(list.get(i)=='1'){
				unos.push(list.get(i));
			}
		}
		return unos.size()==list.size/2;
	}
}
