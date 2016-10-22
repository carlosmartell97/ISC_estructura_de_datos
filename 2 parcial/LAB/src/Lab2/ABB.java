package Lab2;

import java.util.NoSuchElementException;

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
	
	public void add(K key,V value){
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
			this.root=new ABBNode(key,value);
		}else{
			if(compare==0){
				x.value=x.value;
			}
			else if(temp.key<key){
				temp.right=new ABBNode(key,value);
			}else{
				temp.left=new ABBNode(key,value);
			}
		}
	}
	
	public String inOrder(){
		if(this.root!=null){
			inOrder(this.root);
		}
		else{
			return "";
		}
	}
	
	private void inOrder(ABB<K, V>.ABBNode node) {
		String output="";
		if(node.left!=null){
			output+=inOrder(node.left);
		}
	}
	
	public K min(){
		if(isEmpty()){
			throw new NoSuchElementException("your tree is empty...");
		}
		return min(this.root,this.root.key);
	}
	
	private K min(ABBNode root,K minSoFar){
		K smallest=minSoFar;
		if(root!=null){
			smallest=(root.key.compareTo(minSoFar)<0)?root.key:minSoFar;
			min(root.left,smallest);
			min(root.right,smallest);
		}
		return smallest;
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
