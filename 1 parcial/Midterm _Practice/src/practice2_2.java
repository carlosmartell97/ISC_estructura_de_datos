//todavía no lo termino, me falta hacer bien lo del Iterator
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
		int i=1;
		while(i==1){
			b.firstNode=temp;
			//no sé cómo usar el hasNext() de Iterator, pero así lo voy a usar...
			if(temp.hasNext()){
				c.firstNode=temp.next;
			}else{i=0;}
			if(temp.next.hasNext()){
				d.firstNode=temp.next.next;
			}else{i=0;}
			if(temp.next.next.hasNext()){
				temp=temp.next.next.next;
			}
			
		}
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
