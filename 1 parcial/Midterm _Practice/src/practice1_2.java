//	ya lo probé y funciona
public class practice1_2<T extends Comparable>{
	private ChainNode<T> firstNode;
	private int size;
	
	public boolean isSorted(){
		ChainNode<T> temp = firstNode;
		while(temp.next!=null){	// O(n)
			if((temp.element.compareTo(temp.next.element))>0){	// O(n-1)
				return false;
			}
			temp=temp.next;	// O(1)
		}
		return true;
	}
	
	public void add(int index, T item) {
		ChainNode<T> newNode=new ChainNode<T> (item);
		if(index<0 || index>this.size){
			throw new IndexOutOfBoundsException("that index is out of bounds, dude...");
		}
		else if(index==0){
			newNode.next=this.firstNode;
			this.firstNode=newNode;
			this.size++;
		}
		else{
			ChainNode<T> anterior= this.firstNode;
			ChainNode<T> siguiente;
			for(int i=0; i<index-1; i++){
				anterior=anterior.next;
			}
			siguiente=anterior.next;
			newNode.next=siguiente;
			anterior.next=newNode;
			this.size++;
		}
	}
	
	private static class ChainNode<T>{
		T element;
		ChainNode<T> next;
		
		public ChainNode(T element){
			this.element=element;
		}
	}
	
	public static void main(String[] args) {
		practice1_2 o = new practice1_2();
		o.add(0, 8);
		o.add(0, 7);
		o.add(0, 5);
		System.out.println(o.isSorted());
	}
}
