package Lab3;
//	pendiente todo lo de la práctica en PDF...
public class AVLTree<Item extends Comparable> {
	private AVLNode root;
	private final int ALLOWED_IMBALANCE = 1;
	
	public AVLNode rotateLeft(AVLNode root){
		//	al final, el nodo que regresa debería de ser el nuevo nodo en ese punto
		AVLNode right=root.right;
		root.right=right.left;
		right.left=root;
		return right;
	}
	
	/*public V get(K key){
		AVLNode temp=this.root;
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
	}*/
	
	public void insert(){
		
	}
	
	/*private AVLNode insert(K key,V value){
		if(key==null){
			return new AVLNode(K,null,null);
		}
	}*/
	
	private class AVLNode{
		Item content;
		AVLNode right,
				left;
		int height;
	}
}


