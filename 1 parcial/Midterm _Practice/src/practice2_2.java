public class practice2_2<T>{
	private ChainNode<T> firstNode;
	private ChainNode<T> lastNode;
	private int size;
	
	public void makeEmpty(){
		this.firstNode=null;
	}
	
	public void append(ChainNode node){
		this.lastNode.next=node;
	}
	
	//no estoy seguro de este
	public Iterator iterator(){
		return new Iterator();
	}
	
	private static class ChainNode<T>{
		ChainNode<T> next;
		T content;
	}
	
	private static class Iterator{
		public boolean hasNext(ChainNode node){
			return node.next!=null;
		}
		//public 
	}
}
