package exercise_4;

import java.util.Iterator;

public interface Dictionary<K,V> {
	public V add(K k, V item);
	public V remove(K k);
	public V getValue(K k);
	public boolean contains(K k);
	public Iterator<K> getKeyIterator();
	public Iterator<V> getValueIterator();
	public boolean isEmpty();
	public int size();
	public void clear();
}
