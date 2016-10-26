package Lab3;

public class AVLTree<K,V> {
	private AVLNode root;
	
	public AVLNode rotateLeft(AVLNode root){
		AVLNode right=root.right;
		root.right=right.left;
		right.left=root;
		return right;
	}
	
	private class AVLNode{
		K key;
		V value;
		AVLNode right,
				left;
		int height;
	}
}


