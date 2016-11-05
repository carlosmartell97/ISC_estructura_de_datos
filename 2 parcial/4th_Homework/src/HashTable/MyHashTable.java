package HashTable;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

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