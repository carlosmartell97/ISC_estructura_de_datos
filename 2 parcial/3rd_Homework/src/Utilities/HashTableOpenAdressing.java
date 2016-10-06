package Utilities;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashTableOpenAdressing<K,V> {
	private int n,	// number of elements in table
				m;	// size of table
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
	
	public boolean contains(K key){
		return this.getValue(key)!=null;
	}
	
	public V getValue(K key){
		int pos=this.hash(key);
		for(Entry<K,V> n=this.table[pos];n!=null;n=this.table[++pos%this.m]){
			if(n.key.equals(key)){
				return n.value;
			}
		}
		return null;
	}
	
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
	
	public V remove(K key){
		int pos=this.hash(key);
		int availableSpot=-1;
		V toBeSaved=null;
		for(int i=pos;this.table[i]!=null;i=++i%this.m){
			if(this.table[i].key.equals(key)){
				toBeSaved=this.table[i].value;
				this.table[i]=null;
				availableSpot=i;
				this.n--;
			}
			else if(availableSpot!=-1 && this.hash(this.table[i].key)==pos){
				this.table[availableSpot]=this.table[i];
				this.table[i]=null;
				availableSpot=i;
			}
		}
		return toBeSaved;
	}
	
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
	
	private class keyIterator<K> implements Iterator<K>{
		int position;
		
		public keyIterator(){
			for(int i=0;i<HashTableOpenAdressing.this.m;i++){
				if(HashTableOpenAdressing.this.table[i]!=null){
					this.position=i;
					break;
				}
			}
		}
		
		@Override
		public boolean hasNext() {
			return this.position<HashTableOpenAdressing.this.m;
		}

		@Override
		public K next() {
			if(!this.hasNext()){
				throw new NoSuchElementException("this is the last position of the table");
			}
			return (K) HashTableOpenAdressing.this.table[position].key;
		}	
	}
	
	private class valueIterator<V> implements Iterator<V>{
		int position;
		
		public valueIterator(){
			for(int i=0;i<HashTableOpenAdressing.this.m;i++){
				if(HashTableOpenAdressing.this.table[i]!=null){
					this.position=i;
					break;
				}
			}
		}
		
		@Override
		public boolean hasNext() {
			return this.position<HashTableOpenAdressing.this.m;
		}

		@Override
		public V next() {
			if(!this.hasNext()){
				throw new NoSuchElementException("this is the last position of the table");
			}
			return (V) HashTableOpenAdressing.this.table[position].value;
		}	
	}
}
