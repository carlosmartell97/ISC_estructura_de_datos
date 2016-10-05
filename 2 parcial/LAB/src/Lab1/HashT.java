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
	
	public HashT(){
		this(INITIAL_CAPACITY);
	}
	public HashT(int newCapacity){
		this.m=newCapacity;
		//tabla=new Node<K,V>[50];
	}
	
	public int hash(K key){
		return key.hashCode()& 0x7FFFFFF5%m; //	convierto el objeto K a su representación
											//	numérica. Después, hago un AND a nivel de bits
											//	que me quita el signo (valor absoluto)
	}
	
	public int size(){
		return this.m;
	}
	
	public boolean isEMpty(){
		return this.m==0;
	}
	
	public V get(K key){
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
		return get(key)!=null;
	}
	
	public void put(K key, V value){
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
	
	public Iterable<K> keys(){
		Queue<K> queue=new LinkedList<K>();
		for(int i=0;i<m;i++){
			for(Node<K,V> x=this.tabla[i];x!=null;x=x.next){
				queue.add((K)x.key);
			}
		}
		return queue;
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
	
	private class ValueIterator extends HashIterator<K,V>{
		Node<K,V> next;
		//	...
	}
	
	private abstract class HashIterator<E> implements Iterator<E>{
		Node<K,V> next;
		int index;
		
		public HashIterator(){
			if(n>0){
				
			}
		}
		
		@Override
		public boolean hasNext() {
			return this.next!=null;
		}

		/*@Override
		public E next() {
			// TODO Auto-generated method stub
			return null;
		}*/
		
		public Node<K,V> nextNode(){
			if(this.hasNext()){
				return this.next;
				//	...
			}
			throw new NoSuchElementException("there's no nextNode");
		}
	}
	
	public static void main(String[] args) {
		//	...
	}
}
