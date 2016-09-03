public class practice1_2<T extends Comparable>{
	private ChainNode<T> firstNode;
	private int size;
	
	public boolean isSorted(){
		for(int i=0;i<this.size;i++){
			ChainNode<T> temp = new ChainNode<T>();
			if((temp.element.compareTo(temp.next.element))>0){
				return false;
			}
			return true;
		}
	}
	
	private static class ChainNode<T>{
		T element;
		ChainNode<T> next;
	}
}
