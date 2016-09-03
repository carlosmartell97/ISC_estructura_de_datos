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
	
	//no estoy seguro de este método
	public Iterator iterator(){
		return new Iterator();
	}
	
	public void threeWaySplit(practice2_2 a,practice2_2 b,practice2_2 c,practice2_2 d){
		ChainNode<T> temp=a.firstNode;
		
		b.firstNode=a.firstNode;
		c.firstNode=a.firstNode.next;
		d.firstNode=a.firstNode.next.next;
		
		b.firstNode.next=a.firstNode.next.next.next;
	}
	
	private static class ChainNode<T>{
		ChainNode<T> next;
		T content;
	}
	
	//no estoy seguro si así es como debo de hacer esta clase
	private static class Iterator{
		/*public boolean hasNext(){
			
		}*/
		/*public ChainNode next(){
			
		}*/
	}
}
