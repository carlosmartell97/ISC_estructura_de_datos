package Lab2;

public class ABB<K extends Comparable<K>,V> {
	private ABBNode root;
	
	public ABB(){
		//...
	}
	
	public boolean isEmpty(){
		return size()==0;
	}
	
	public int size(){
		return size(root);
	}
	
	private int size(ABBNode root){
		if(root==null) return 0;
		return root.size;
	}
	
	public boolean contains(K key){
		if(key==null){
			throw new NullPointerException("no nulls accepted");
		}
		return get(key)!=null;
	}
	
	private class ABBNode{
		K key;
		V value;
		ABBNode left,
				right;
		int size;
		
		public ABBNode(K key,V value){
			this.key=key;
			this.value=value;
		}
		
		public String toString(){
			return "["+key+"-"+value+"]";
		}
	}
}
