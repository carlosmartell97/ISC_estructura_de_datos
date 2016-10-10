//	me falta:
//		- checar si funciona el remove()
//		- "HashIterator: next -> referencia al siguiente a visitar"
//		- que nextNode() actualice el next
//		- el error que tengo en Iterable()

package Lab1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class HashT<K,V> {
	private int m;	// tamaño de la tabla
	private int n;	// cantidad de datos en la tabla
	private Node<K,V>[] tabla;
	private final static int INITIAL_CAPACITY=11;
	private final static double Charge=0.75;
	
	public HashT(){
		this(INITIAL_CAPACITY);
	}
	public HashT(int newCapacity){
		this.m=newCapacity;
		this.n=0;
		this.tabla=new Node[this.m];
	}
	
	public int hash(K key){
		return key.hashCode()& 0x7FFFFFF5%m; //	convierto el objeto K a su representación
											//	numérica. Después, hago un AND a nivel de bits
											//	que me quita el signo (valor absoluto)
	}
	
	public int size(){
		return this.m;
	}
	
	public boolean isEmpty(){
		return this.m==0;
	}
	
	public V getValue(K key){
		if(key==null){
			throw new NullPointerException("llaves nulas no se aceptan");
		}
		int pos=hash(key);
		for(Node<K,V> x=tabla[pos];x!=null;x=x.next){
			if(x.key.equals(key)){
				return x.value;
			}
		}
		return null;
	}
	
	public boolean contains(K key){
		return getValue(key)!=null;
	}
	
	public void add(K key, V value){
		if(key==null || value==null){
			throw new IllegalArgumentException("no se aceptan valores nulos");
		}
		int pos=hash(key);
		for(Node<K,V> x=this.tabla[pos];x!=null;x=x.next){
			if(key.equals(x.key)){
				x.value=value;
				return;
			}
		}
		this.tabla[pos]=new Node<K,V>(key,value,null);
		n++;
	}
	
	public V remove(K key){
		if(key==null){
			throw new IllegalArgumentException("lalves nulas no se aceptan");
		}
		int pos=hash(key);
		V returnedValue=this.tabla[pos].value;
		for(int i=pos;i<this.n;i++){
			this.tabla[i]=this.tabla[i+1];
		}
		this.tabla[n]=null;
		this.n--;
		
		return returnedValue;
	}
	
	public void clear(){
		this.tabla=new Node[this.m];
		this.n=0;
	}
	
	public void rehash(){
		this.n=0;
		this.m*=2;
		this.tabla=new Node[m];
		Iterator<Node<K,V>> iter=new NodeIterator();
	
		while(iter.hasNext()){
			Node<K,V> temp=iter.next();
			this.add(temp.key, temp.value);
		}
	}
	
	public Iterable<K> keys(){
		Queue<K> queue=new LinkedList<K>();
		for(int i=0;i<m;i++){
			for(Node<K,V> x=this.tabla[i];x!=null;x=x.next){
				queue.add((K)x.key);
			}
		}
		return queue;
	}
	
	public Iterator<V> getValueIterator(){
		return new ValueIterator();
	}
	
	public Iterator<K> getKeyIterator(){
		return new KeyIterator();
	}
	
	private static class Node<K,V>{
		K key;
		V value;
		Node<K,V> next;
		
		public Node(K key, V value, Node<K,V> next){
			this.key=key;
			this.value=value;
			this.next=next;
		}
	}
	
	private class ValueIterator extends HashIterator{
		V nextValue;
		
		public ValueIterator(){
			super();
		}
		
		public V next(){
			this.nextValue=(V) this.next();
			return this.nextValue;
		}
	}
	
	private class KeyIterator extends HashIterator{
		K nextKey;
		
		public KeyIterator(){
			super();
		}
		
		public K next(){
			this.nextKey=(K) this.next();
			return this.nextKey;
		}
	}
	
	private class NodeIterator extends HashIterator<Node<K,V>>{

		public NodeIterator(){
			super();
		}
		
		@Override
		public Node<K, V> next() {
			return this.nextNode();
		}
	}
	
	private abstract class HashIterator<E> implements Iterator<E>{
		Queue<Node<K,V>> queue;
		
		public HashIterator(){
			if(HashT.this.n>0){
				this.queue=this.iter();
			}
		}
		
		public Queue<Node<K,V>> iter(){
			Queue<Node<K,V>> queueReturned=new LinkedList<Node<K,V>>();
			for(Node<K,V> node : HashT.this.tabla){
				while(node!=null){
					queueReturned.add(node);
					node=node.next;
				}
			}
			return queueReturned;
		}
		
		@Override
		public boolean hasNext() {
			return this.queue.peek()!=null;
		}

		/*@Override
		public E next() {
			// TODO Auto-generated method stub
			return null;
		}*/
		
		public Node<K,V> nextNode(){
			if(this.hasNext()){
				return this.next;
			}
			throw new NoSuchElementException("there's no nextNode");
		}
	}
	
	public static void main(String[] args) {
		//	...
	}
}
