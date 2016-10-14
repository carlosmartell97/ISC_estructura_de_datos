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
	
	public V get(K key){
		ABBNode temp=this.root;
		while(temp!=null){
			int compare=key.compareTo(temp.key);
			if(compare>0){
				temp=temp.right;
			}
			else if(compare<0){
				temp=temp.right;
			}
			else{
				return temp.value;
			}
		}
		return null;
	}
	
	public void put(K key,V value){
		ABBNode x=this.root;
		ABBNode temp;
		int compare;
		while(x!=null){
			temp=x;
			compare=key.compareTo(x.key);
			if(compare==0){
				break;
			}
			else if(compare>0){
				x=x.right;
			}
			else if(compare<0){
				x=x.right;
			}
		}
		if(x==null){
			this.root=new ABB(key,value);
		}
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
