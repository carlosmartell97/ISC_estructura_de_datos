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
	
	public int height(){
		return height(this.root);
	}
	
	private int height(ABBNode root){
		if(root==null){
			return -1;
		}
		return 1+Math.max(height(root.left), height(root.right));
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
		ABBNode temp=null;
		int compare = 0;
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
			else if(temp.key.compareTo(key)<0){
				temp.right=new ABBNode(key,value);
			}else{
				temp.left=new ABBNode(key,value);
			}
		}
	}
	
	public String inOrder(){
		if(this.root!=null){
			return this.inOrder(this.root);
		}
		return "";
	}
	
	private String inOrder(ABBNode root) {
		if(root==null){
			return "";
		}
		String toBeReturned=this.inOrder(root.left);
		toBeReturned+="["+root.key.toString()+","+root.value.toString()+"]";
		toBeReturned+=this.inOrder(root.right);
		return toBeReturned;
	}
	
	public String postOrder(){
		if(this.root!=null){
			return this.postOrder(this.root);
		}
		return "";
	}
	
	private String postOrder(ABBNode root){
		if(root==null){
			return "";
		}
		String toBeReturned=this.inOrder(root.left);
		toBeReturned+=this.inOrder(root.right);
		toBeReturned+="["+root.key.toString()+","+root.value.toString()+"]";
		return toBeReturned;
	}
	
	public int leaves(){
		if(this.root==null){
			return 0;
		}
		return this.root.leaves();
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
	
	public void delete(K key){
		if(key==null){
			throw new NullPointerException("the table is empty!");
		}
		root=delete(root, key);
	}
	
	private ABBNode delete(ABBNode x, K key){
		if(x==null){
			return null;
		}
		int compare=key.compareTo(root.key);
		if(compare<0){
			x.left=delete(root.left,key);
		}
		else if(compare>0){
			x.right=delete(root.right,key);
		}
		else{
			if(root.right==null){
				return root.left;
			}
			if(root.left==null){
				return root.right;
			}
			ABBNode temp=root;
			//root=min(temp.right);
			//root.right=removeMin(temp.right);
			//temp.temp=temp.left;
		}
		root.size=size(x.left)+size(root.right)+1;
		return root;
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
		
		public int leaves(){
			if(this.left==null && this.right==null){
				return 1;
			}
			return (this.left==null?0:this.left.leaves()) + (this.right==null?0:this.right.leaves());
		}
	}
}
