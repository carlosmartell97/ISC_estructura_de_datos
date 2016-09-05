//no lo probé, pero estoy casi seguro que funciona
public class practice1_2<T extends Comparable>{
	private ChainNode<T> firstNode;
	private int size;
	
	public boolean isSorted(){
		ChainNode<T> temp = firstNode;
		for(int i=0;i<this.size;i++){	// O(n)
			if((temp.element.compareTo(temp.next.element))>0){	// O(n-1)
				return false;
			}
			temp=temp.next;	// O(1)
		}
		return true;
	}
	
	private static class ChainNode<T>{
		T element;
		ChainNode<T> next;
	}
}
