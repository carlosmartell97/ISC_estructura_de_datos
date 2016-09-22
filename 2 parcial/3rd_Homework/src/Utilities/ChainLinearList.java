package Utilities;

public class ChainLinearList<Item> implements LinearList<Item>{
	
	protected ChainNode<Item> firstNode;
	protected int size;
	
	public ChainLinearList(){
		this.size=0;
		this.firstNode=new ChainNode<Item>();
	}
	
	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public Item get(int index) {
		if(index<0 || index>=this.size){
			throw new IndexOutOfBoundsException("That index is out of bounds, dude...");
		}
		ChainNode<Item> temp = firstNode;
		for(int i=0; i<index; i++){
			temp=temp.next;
		}
		return temp.element;
	}

	@Override
	public int indexOf(Item item) {
		ChainNode<Item> temp = this.firstNode;
		for(int i=0; i<this.size; i++){
			if(item.equals(temp.element)){
				return i;
			}
			temp=temp.next;
		}
		return -1;
	}

	@Override
	public Item remove(int index) {
		Item item;
		if(index<0 || index>this.size){
			throw new IndexOutOfBoundsException("that index is out of bounds, dude...");
		}
		else if(index==0){
			//this.firstNode.next=firstNode.next.next;
			item = this.firstNode.element;
			this.firstNode=this.firstNode.next;
			size--;
		}
		else{
			ChainNode<Item> anterior = this.firstNode;
			for(int i=0; i<index-1; i++){
				anterior=anterior.next;
			}
			item=anterior.next.element;
			anterior.next=anterior.next.next;
			size--;
		}
		return item;
	}

	@Override
	public void add(int index, Item item) {
		ChainNode<Item> newNode=new ChainNode<Item> (item);
		if(index<0 || index>this.size){
			throw new IndexOutOfBoundsException("that index is out of bounds, dude...");
		}
		else if(index==0){
			newNode.next=this.firstNode;
			this.firstNode=newNode;
			this.size++;
		}
		else{
			ChainNode<Item> anterior= this.firstNode;
			ChainNode<Item> siguiente;
			for(int i=0; i<index-1; i++){
				anterior=anterior.next;
			}
			siguiente=anterior.next;
			newNode.next=siguiente;
			anterior.next=newNode;
			this.size++;
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
	
	private static class ChainNode <Item>{
		Item element;
		ChainNode<Item> next;
		
		public ChainNode(){
			this.element=null;
			this.next=null;
		}
		public ChainNode(Item element){
			this.element=element;
		}
		public ChainNode(Item element, ChainNode next){
			this.element=element;
			this.next=next;
		}
	}
}
