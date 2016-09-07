package linearList;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DLinkedList<Item> implements linearList<Item>{
	private DNode<Item> firstNode,
						lastNode;
	private int size;
	
	public DLinkedList(){
		this.firstNode=null;
		this.lastNode=null;
		this.size=0;
	}
	
	public ListIterator<Item> getIterator(){
		return new ListIterate();
	}
	
	public ListIterator<Item> getIterator(int index){
		if(index<0 || index>size){
			throw new IndexOutOfBoundsException("that index is out of bounds");
		}
		return new ListIterate(index);
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
		if(index<0 || index>this.size-1){
			throw new IndexOutOfBoundsException("that index is out of bounds");
		}
		DNode<Item> temp=getNode(index);
		return temp.content;
	}
	
	public void addFirst(Item value){
		DNode<Item> temp = this.firstNode;
		DNode<Item> newNode = new DNode<Item>(null,value,this.firstNode);
		this.firstNode=newNode;
		if(this.size==0){
			this.lastNode = newNode;
		}
		else{
			temp.previous=newNode;
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
		this.lastNode=newNode;
		this.size++;
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
	
	public ListIterate iterator(){
		return new ListIterate();
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public int size() {
		return this.size;
	}
	
	public int indexOf(Item item) {
		DNode<Item> temp = this.firstNode;
		for(int i=0;i<this.size;i++){
			if(temp.content.equals(item)){
				return i;
			}
			temp=temp.next;
		}
		return -1;
	}
	
	public Item remove(int index) {
		if(index<0 || index>this.size-1){
			throw new IndexOutOfBoundsException("That index is out of bounds.");
		}
		DNode<Item> prev = this.firstNode;
		DNode<Item> toRemove;
		if(index==0){
			toRemove=this.firstNode;
			this.firstNode=this.firstNode.next;
			this.size--;
			return toRemove.content;
		}
		DNode<Item> next;
		prev=getNode(index-1);
		toRemove=prev.next;
		next=toRemove.next;
		prev.next=next;
		if(index==size-1){
			this.lastNode=prev;
		}
		else{
			next.previous=prev;
		}
		this.size--;
		return toRemove.content;
	}
	
	public void add(int index, Item item) {
		if(index<0 || index<this.size){
			throw new IndexOutOfBoundsException("that index is out of bounds");
		}
		if(index==0){
			this.addFirst(item);
		}
		else if(index==size){
			this.addLast(item);
		}
		else{
			DNode<Item> prev=this.firstNode;
			prev=this.getNode(index-1);
			DNode<Item> next = prev.next;
			DNode<Item> toAdd = new DNode<Item>(prev,item,next);
			prev.next=toAdd;
			next.previous=toAdd;
			this.size++;
		}
	}
	
	private static class DNode<Item>{
		protected Item content;
		protected DNode<Item> next,
								previous;
		
		public DNode(){
			this(null,null,null);
		}
		
		public DNode(DNode<Item> previous,Item content,DNode<Item> next){
			this.previous=previous;
			this.content=content;
			this.next=next;
		}
	}
	
	private class ListIterate implements ListIterator<Item>{
		DNode<Item> next;
		DNode<Item> ultimoVisitado=null;
		int nextIndex;
		
		public ListIterate(){
			this.next=DLinkedList.this.firstNode;
			this.nextIndex=0;
		}
		public ListIterate(int index){
			if(index==size){
				this.next=null;
			}
			else{
				this.next=DLinkedList.this.getNode(index);
			}
			this.nextIndex=index;
		}

		public boolean hasNext() {
			return this.nextIndex<DLinkedList.this.size;
		}

		public boolean hasPrevious() {
			return this.nextIndex>0;
		}

		public Item next() {
			if(!this.hasNext()){
				throw new NoSuchElementException("There are no elements");
			}
			ultimoVisitado=this.next;
			nextIndex++;
			this.next=this.next.next;
			return ultimoVisitado.content;
		}

		public int nextIndex() {
			if(!this.hasNext()){
				return DLinkedList.this.size;
			}
			return this.nextIndex;
		}

		public Item previous() {
			if(!this.hasPrevious()){
				throw new NoSuchElementException("There are no elements");
			}
			if(this.next==null){
				this.next=this.ultimoVisitado;
			}else{
				this.next=this.next.previous;
			}
			this.ultimoVisitado=this.next;
			this.nextIndex--;
			return ultimoVisitado.content;
		}

		public int previousIndex() {
			if(!this.hasPrevious()){
				return -1;
			}
			return this.nextIndex-1;
		}

		public void remove() {
			// TODO Auto-generated method stub
		}

		public void set(Item arg0) {
			// TODO Auto-generated method stub
		}
		
		public void add(Item arg0) {
			// TODO Auto-generated method stub
		}
	}
	public static void main(String[] args) {
		DLinkedList<Integer> dl = new DLinkedList<Integer>();
		dl.addFirst(4);
		dl.addFirst(3);
		dl.addFirst(5);
		System.out.println(dl);
		
		ListIterator<Integer> iterator = dl.getIterator(2);
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		/*
		System.out.println();
		while(iterator.hasPrevious()){
			System.out.println(iterator.previous());
		}*/
	}
}
