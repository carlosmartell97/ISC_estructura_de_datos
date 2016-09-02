package linearList;

import java.util.ListIterator;

public class DLinkedList<Item> implements linearList<Item>{
	private DNode<Item> firstNode;
	private DNode<Item> lastNode;
	private int size;
	
	public DLinkedList(){
		this.firstNode=null;
		this.lastNode=null;
		this.size=0;
	}
	
	public DNode<Item> getNode(int index){
		DNode<Item> temp = this.firstNode;
		for(int i=0;i<=index;i++){
			temp=temp.next;
		}
		return temp;
	}
	
	@Override
	public Item get(int index){
		if(index<0 || index>this.size){
			throw new IndexOutOfBoundsException("that index is out of bounds");
		}
		return this.getNode(index).content;
	}
	
	public void addFirst(Item value){
		DNode<Item> newNode = new DNode<Item>(null,value,this.firstNode);
		if(this.size!=0){
			this.firstNode.previous=newNode;
		}
		else{
			this.lastNode=newNode;
		}
		this.size++;
	}
	
	public void addLast(Item value){
		DNode<Item> newNode = new DNode<Item>(this.lastNode,value,null);
		if(this.size==0){
			this.firstNode=newNode;
		}
		else{
			this.lastNode.next=newNode;
		}
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder("[");
		DNode<Item> node = this.firstNode;
		while(node!=this.lastNode){
			sb.append("[");
			sb.append(node.content);
			sb.append("]");
			node=node.next;
		}
		sb.append("]");
		return sb.toString();
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int indexOf(Item item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Item remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, Item item) {
		// TODO Auto-generated method stub
		
	}
	
	private static class DNode<Item>{
		Item content;
		DNode<Item> next;
		DNode<Item> previous;
		
		public DNode(DNode previous,Item content,DNode next){
			this.previous=previous;
			this.content=content;
			this.next=next;
		}
	}
	
	private class ListIterate implements ListIterator<Item>{
		DNode<Item> next;
		DNode<Item> previous;
		int nextIndex;
		int previousIndex;
		
		public ListIterate(){
			this.next=firstNode;
			this.nextIndex=0;
		}
		public ListIterate(int index){
			if(index==size){
				this.next=null;
			}
			else{
				this.next=getNode(index);
			}
			this.nextIndex=index;
		}
		
		@Override
		public void add(Item arg0) {
			// TODO Auto-generated method stub
		}
		@Override
		public boolean hasNext() {
			return this.next.next!=null;
		}
		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public int nextIndex() {
			return this.nextIndex;
		}
		@Override
		public Item previous() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public void remove() {
			// TODO Auto-generated method stub
		}
		@Override
		public void set(Item arg0) {
			// TODO Auto-generated method stub
			
		}
	}
}
