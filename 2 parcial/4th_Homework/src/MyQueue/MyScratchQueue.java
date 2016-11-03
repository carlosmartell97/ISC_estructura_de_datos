//	ya debería de funcionar todo.
package MyQueue;

import java.util.NoSuchElementException;

public class MyScratchQueue<Item> implements Queue<Item>{
	private int size;
	private ChainNode<Item> rear,
							front;
	
	public boolean isEmpty() {
		return this.size==0;
	}

	public int size() {
		return this.size;
	}

	public Item front() {
		if(this.isEmpty()) throw new NoSuchElementException("Queue is empty");
		return this.front.element;
	}

	public Item rear() {
		if(this.isEmpty()) throw new NoSuchElementException("Queue is empty");
		return this.rear.element;
	}

	public void enqueue(Item item) {
		if(this.isEmpty()){
			this.front=new ChainNode<Item>(item);
			this.rear=new ChainNode<Item>(item);
		}
		else{
			ChainNode<Item> newNode=new ChainNode<Item>(item);
			this.rear.next=newNode;
			this.rear=newNode;
		}
		this.size++;
	}

	public Item dequeue() {
		if(this.isEmpty()){
			return null;
		}
		ChainNode<Item> toBeReturned=this.front;
		if(this.front.equals(this.rear)){
			//size is 1
			this.front=null;
			this.rear=null;
		}
		else{
			this.front=this.front.next;
		}
		this.size--;
		return toBeReturned.element;
	}
	
	private class ChainNode <Item>{
		Item element;
		ChainNode<Item> next;
		
		public ChainNode(Item element){
			this.element=element;
		}
	}
}
