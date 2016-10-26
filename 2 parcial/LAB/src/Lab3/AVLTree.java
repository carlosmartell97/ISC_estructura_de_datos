package Lab3;

public class AVLTree<K,V> {
	private AVLNode root;
	
	private class AVLNode{
		K key;
		V value;
		AVLNode right,
				left;
		int height;
	}
}


