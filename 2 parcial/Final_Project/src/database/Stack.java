package database;

public interface Stack<Item> {
	public boolean isEmpty();
	public int size();
	public void add(int index,Item item);
	public Item remove(int index);
	public Item get(int index);
	public int indexOf(Item item);
	public String toString();
}
