package exercise_4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class MyHashTable<K,V> implements Dictionary<K,V>{
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
	
	public boolean isEmpty(){
		return this.size==0;
	}
	
	public int size(){
		return this.size;
	}
	
	public void clear(){
		for(int i=0;i<this.size;i++){
			this.table[i]=null;
		}
		this.size=0;
	}
	
	public V getValue(K key){
		int pos=this.hash(key);
		for(Node<K,V> x=this.table[pos]; x!=null; x=x.next){
			if(x.key.equals(key)){
				return x.value;
			}
		}
		return null;
	}
	
	public boolean contains(K key){
		return this.getValue(key)!=null;
	}
	
	public V add(K key, V item) {
		if(this.size >= this.m-1 || (this.size+0.0)/(this.m) >= DEFAULT_CHARGE)
			this.rehash();
		int pos = this.hash(key);
		for(Node<K,V> x=this.table[pos]; x!=null; x=x.next){
			if(x.key.equals(key)){
				V willReturn = x.value;
				x.value = item;
				return willReturn;
			}
		}
		Node<K,V> added = new Node<K,V>(key,item,this.table[pos]);
		this.table[pos] = added;
		this.size++;
		return null;
	}

	public V remove(K key) {
		int pos = this.hash(key);
		Node<K,V> first = this.table[pos];
		if(first.key.equals(key)){
			V willReturn = first.value;
			this.table[pos] = first.next;
			this.size--;
			return willReturn;
		}
		for(Node<K,V> x=first; x.next!=null; x=x.next){
			if(x.next.key.equals(key)){
				V willReturn = x.next.value;
				x.next = x.next.next;
				this.size--;
				return willReturn;
			}
		}
		return null;
	}
	
	public Iterator<K> getKeyIterator() {
		return new KeyIterator();
	}

	public Iterator<V> getValueIterator() {
		return new ValueIterator();
	}
	
	private void rehash(){
		Iterator<Node<K,V>> nodes=new NodeIterator();
		this.m*=2;
		this.table=new Node[m];
		this.size=0;
		
		while(nodes.hasNext()){
			Node<K,V> temp=nodes.next();
			this.add(temp.key,temp.value);
		}
	}
	
	/**
	 * //	convierto el objeto K a su representación
			numérica. Después, hago un AND a nivel de bits
			que me quita el signo (valor absoluto)
	 * @param key
	 * @return absolute value of hash code
	 */
	public int hash(K key){
		return key.hashCode()& 0x7FFFFFF5%m;
	}
	
	private static class Node<K,V>{
		K key;
		V value;
		Node<K,V> next;
		
		public Node(K key,V value,Node<K,V> next){
			this.key=key;
			this.value=value;
			this.next=next;
		}
	}
	
	private abstract class HashIterator<E> implements Iterator<E>{
		Queue<Node<K,V>> queue;

		public HashIterator(){
			if(MyHashTable.this.size > 0)
				this.queue = this.nodes();
		}
		public boolean hasNext() {
			return queue.peek() != null;
		}

		public Node<K,V> nextNode(){
			if(!this.hasNext())
				throw new NoSuchElementException();
			return this.queue.poll();
		}

		private Queue<Node<K,V>> nodes(){
			Queue<Node<K,V>> queue = new LinkedList<Node<K,V>>();
			
			for(Node<K,V> node:MyHashTable.this.table){
				while(node != null){
					queue.add(node);
					node = node.next;
				}
			}
			return queue;
		}
	}
	
	private class NodeIterator extends HashIterator<Node<K,V>>{

		public NodeIterator(){
			super();
		}
		public Node<K, V> next() {
			return this.nextNode();
		}
		
	}

	private class KeyIterator extends HashIterator<K>{

		public KeyIterator(){
			super();
		}
		public K next() {
			return (K) this.nextNode().key;
		}
	}

	private class ValueIterator extends HashIterator<V>{

		public ValueIterator(){
			super();
		}
		public V next() {
			return (V) this.nextNode().value;
		}
	}
}