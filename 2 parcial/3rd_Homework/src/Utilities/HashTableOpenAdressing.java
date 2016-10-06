package Utilities;

public class HashTableOpenAdressing<K,V> {
	private int n,
				m;
	private Entry<K,V>[] table;
	
	public HashTableOpenAdressing(){
		this(101);
	}
	
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
	
	public void resize(){
		this.m*=2;
		Entry<K,V>[] biggerTable=new Entry[m];
		for(int i=0;i<this.size();i++){
			biggerTable[hash(this.table[i].key)]=this.table[i];
		}
		this.table=biggerTable;
	}
	
	/*public boolean contains(K key){
		
	}*/
	
	public V add(K key,V value){
		if(this.n>=this.m-1 || this.n/this.m >= 0.75){
			this.resize();
		}
		int pos=this.hash(key);
		for(int i=pos,contador=0; contador<this.m; i=++i%this.m,contador++){
			if(this.table[i]==null){
				this.table[i]=new Entry<K,V>(key,value);
				this.n++;
				break;
			}
			else if(this.table[i].equals(key)){
				V toBeSaved=this.table[i].value;
				this.table[i].value=value;
				return toBeSaved;
			}
		}
		return null;
	}
	
	/*public remove(K key){
		
	}*/
	
	public int hash(K key){
		return (key.hashCode()&0x7FFFFFFF)%m;
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
