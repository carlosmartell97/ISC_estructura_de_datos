//no lo probé, pero estoy casi seguro que funciona
public class practice1_2<T extends Comparable>{
	private ChainNode<T> firstNode;
	private int size;
	
	public boolean isSorted(){
		ChainNode<T> temp = firstNode;
		for(int i=0;i<this.size;i++){
			if((temp.element.compareTo(temp.next.element))>0){
				return false;
			}
			temp=temp.next;
		}
		return true;
	}
	
	private static class ChainNode<T>{
		T element;
		ChainNode<T> next;
	}
}
