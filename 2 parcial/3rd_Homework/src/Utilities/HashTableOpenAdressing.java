package Utilities;

public class HashTableOpenAdressing<K,V> {
	private int n,
				m;
	private Entry<K,V>[] table;
	
	public HashTableOpenAdressing(int capacity){
		this.n=0;
		this.m=capacity;
		this.table=new Entry[m];
	}
	
	public boolean isEmpty(){
		return this.n==0;
	}
	
	public int size(){
		return this.n;
	}
	
	public boolean contains(K key){
		
	}
	
	public V add(K key,V value){
		
	}
	
	public remove(K key){
		
	}
	
	private static class Entry<K,V>{
		K key;
		V value;
		
		public Entry(K key,V value){
			this.key=key;
			this.value=value;
		}
	}
}
