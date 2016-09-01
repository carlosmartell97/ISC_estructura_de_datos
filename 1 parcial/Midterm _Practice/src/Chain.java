
public class Chain<Item>{
	private ChainNode<Item> firstNode;
	private int size;
	
	private static class ChainNode<Item>{
		Item element;
		ChainNode<Item> next;
		
		public ChainNode(){
			this.element=null;
			this.next=null;
		}
		public ChainNode(Item newItem){
			this.element=newItem;
		}
		public ChainNode(Item newItem,ChainNode nextNode){
			this.element=newItem;
			this.next=nextNode;
		}
	}
	
	public String toString(){
		String s="";
		ChainNode<Item> aux=firstNode;
		int i=0;
		while(i<this.size){
			s=s+"["+aux.element.toString()+"]";
			aux=aux.next;
			i++;
		}
		return s;
	}
}
