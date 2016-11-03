package MyQueue;

public interface Queue<Item> {
	public boolean isEmpty();
	public int size();
	public Item front();
	public Item rear();
	public void enqueue(Item item);
	public Item dequeue();
	public String toString();
}
