package Utilities;

public class HashTableOpenAdressing<K,V> {
	private int n,
				m;
	private Entry<K,V>[] table;
	
	private static class Entry<K,V>{
		K key;
		V value;
		
		public Entry(K key,V value){
			this.key=key;
			this.value=value;
		}
	}
}
