package database;

public class AVLTree{
	private AVLNode root;
	protected int size;
	private final int ALLOWED_IMBALANCE = 1;
	
	private AVLNode leftRotate(AVLNode node) {
		if(node == null){
			return null;
		}
		//Save reference to the right child of the given node
		//and the left child of the right child.
		AVLNode right = node.right;
		AVLNode futureRight = right.left;
		//Make the right child the new root of the subtree.
		right.left = node;
		node.right = futureRight;
		
		//Change the height of the node.
		node.height = Math.max(height(node.left),height(node.right))+1;
		right.height = Math.max(height(right.left),height(right.right))+1;
		return right;
	}
	
	private AVLNode rightRotate(AVLNode node) {
		if(node == null){
			return null;
		}
		//Save reference to the left child of the given node
		//and the right child of the left child.
		AVLNode left = node.left;
		AVLNode futureLeft = left.right;
		//Make the left child the new root of the subtree.
		left.right = node;
		node.left = futureLeft;
		
		//Change the height of the node.
		node.height = Math.max(height(node.left),height(node.right))+1;
		left.height = Math.max(height(left.left),height(left.right))+1;
		return left;
	}
	
	private AVLNode rightLeftRotate(AVLNode t) {
		//Fix the right reference first, then do a simple left rotation.
		t.right = rightRotate(t.right);
		return leftRotate(t);
	}
	
	private AVLNode leftRightRotate(AVLNode t) {
		//Fix the left reference first, then do a simple right rotation.
		t.left = leftRotate(t.left);
		return rightRotate(t);
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
	
	/**
	 * insert new Element. Will do all necessary rotations for balancing height
	 * @param element
	 */
	public void insert(Integer element){
		this.root = insert(element,this.root);
	}
	private AVLNode insert(Integer element,AVLNode node){
		if(node == null)
			return new AVLNode(element,null,null);
		this.size++;
		int compareResult = element.compareTo(node.content);
		if(compareResult == 0)
			node.prices.add(0, element);
		if(compareResult < 0)
			node.left = insert(element,node.left);
		else if (compareResult > 0)
			node.right = insert(element,node.right);
		return balance(node);
	}
	
	public String preOrder(AVLNode node){
		if(node == null)
			return "";
		String output = node.toString();
		if(!node.prices.isEmpty()) System.out.print(node.prices+",");
		output += this.preOrder(node.left);
		output += this.preOrder(node.right);
		return output;
	}
	
	public String inOrder(AVLNode node){
		if(node == null)
			return "";
		String output = this.inOrder(node.left);
		output += node.toString();
		if(!node.prices.isEmpty()) System.out.print(node.prices+",");
		output += this.inOrder(node.right);
		return output;
	}
	
	private class AVLNode{
		Integer content;
		AVLNode right,
				left;
		int height;
		ChainLinearList<Integer> prices = new ChainLinearList<Integer>();
		
		private AVLNode(Integer content, AVLNode left, AVLNode right){
			this.content = content;
			prices.add(0, content);
			this.left = this.right = null; 
			this.height = 1;
		}
	}
	
	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		tree.insert(10);
		tree.insert(1);
		tree.insert(20);
		tree.insert(15);
		tree.insert(17);
		tree.insert(5);
		tree.insert(3);	
			tree.insert(3);
		System.out.print("pre: ");tree.preOrder(tree.root);System.out.println();
		System.out.print("in: ");tree.inOrder(tree.root);System.out.println();
	}
}