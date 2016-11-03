package MyQueue;

public class MyScratchQueue<Item> implements Queue<Item>{
	private int size;
	private ChainNode<Item> rear,
							front;
	
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
	public Item front() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item rear() {
		// TODO Auto-generated method stub
		return null;
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
