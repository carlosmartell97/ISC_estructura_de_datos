package HashTable;

public class MyHashTable<K,V> {
	private int m,
				size;
	private Node<K,V>[] table;
	private static final int MAX_CAPACITY=101;
	private static final double DEFAULT_CHARGE=0.75;
	
	public MyHashTable(){
		this(MAX_CAPACITY);
	}
	
	public MyHashTable(int m){
		this.m=m;
		this.size=0;
		this.table=new Node[m];
	}
	
	/**
	 * //	convierto el objeto K a su representación
			numérica. Después, hago un AND a nivel de bits
			que me quita el signo (valor absoluto)
	 * @param key
	 * @return hash code
	 */
	public int hash(K key){
		return key.hashCode()& 0x7FFFFFF5%m;
	}
	
	private static class Node<K,V>{
		
	}
}