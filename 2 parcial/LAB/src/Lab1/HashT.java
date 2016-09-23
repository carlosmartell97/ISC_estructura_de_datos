package Lab1;

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
}
