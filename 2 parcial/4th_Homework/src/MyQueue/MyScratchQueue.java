package MyQueue;

import java.util.EmptyStackException;

public class MyScratchQueue<Item> implements Queue<Item>{
	private int size;
	private ChainNode<Item> rear,
							front;
	
	@Override
	public boolean isEmpty() {
		return this.size==0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public Item front() {
		if(this.isEmpty()){
			return null;
		}
		return this.front.element;
	}

	@Override
	public Item rear() {
		if(this.isEmpty()){
			return null;
		}
		return this.rear.element;
	}

	@Override
	public void enqueue(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Item dequeue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Item item) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private class ChainNode <Item>{
		Item element;
		ChainNode<Item> next;
		
		public ChainNode(Item element){
			this.element=element;
		}
	}
}
