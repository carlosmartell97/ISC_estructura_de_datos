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
	
	private int height(AVLNode node){
		if(node == null)
			return 0;
		return node.height;
	}
	
	public AVLNode balance(AVLNode node){
		if(node == null)
			return node;

		else if (height(node.left)-height(node.right)>this.ALLOWED_IMBALANCE){
			//LeftLeft
			if(height(node.left.left)>=height(node.left.right))
				node = rightRotate(node);
			//LeftRight
			else
				node = leftRightRotate(node);
		}
		//When the right child's height is greater.
		else if (height(node.right)-height(node.left)>this.ALLOWED_IMBALANCE){
			//RightRight Case
			if(height(node.right.right)>=height(node.right.left))
				node = leftRotate(node);
			//RightLeft Case
			else
				node = rightLeftRotate(node);
		}
		node.height = Math.max(height(node.left),height(node.right))+1;
		return node;
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


