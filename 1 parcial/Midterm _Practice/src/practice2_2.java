//	me falta:
//		-confirmar que estén bien makeEmpty(), append() e iterator()
//		-hacer bien next() y hasNext() de la clase Iterator
public class practice2_2<T>{
	private ChainNode<T> firstNode;
	private ChainNode<T> lastNode;
	private int size;
	
	//	no sé si esté bien
	public void makeEmpty(){
		this.firstNode=null;
	}
	
	//	no sé si esté bien
	public void append(ChainNode node){
		this.lastNode.next=node;
	}
	
	//no estoy seguro de este método
	public Iterator iterator(){
		return new Iterator();
	}
	
	public void threeWaySplit(practice2_2 a,practice2_2 b,practice2_2 c,practice2_2 d){
		b.makeEmpty();
		c.makeEmpty();
		d.makeEmpty();
		Iterator iter=a.iterator();
		while(iter.hasNext()){	//	O(size of a)
			b.append(iter.next());
			if(!iter.hasNext()){
				break;
			}
			c.append(iter.next());
			if(!iter.hasNext()){
				break;
			}
			d.append(iter.next());
			if(!iter.hasNext()){
				break;
			}
		}
	}
	
	private static class ChainNode<T>{
		ChainNode<T> next;
		T content;
	}
	
	//no estoy seguro si así es como debo de hacer esta clase
	private static class Iterator{
		public boolean hasNext(){
			return false;
		}
		public ChainNode next(){
			return null;
		}
	}
}
