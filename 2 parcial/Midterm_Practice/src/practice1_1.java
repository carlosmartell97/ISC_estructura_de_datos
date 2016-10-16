
public class practice1_1 {
	
	public class BinaryTreeNode{
		Object element;
		BinaryTreeNode right,
						left;
	}
	
	public class LinkedBinaryTree{
		BinaryTreeNode root;
		
		public void swapChildren(){
			swapChildren(root);
		}
		
		private void swapChildren(BinaryTreeNode node){
			if(node!=null){
				swapChildren(node.left);
				swapChildren(node.right);
				
				BinaryTreeNode temp=node;
				node.right=temp.left;
				node.left=temp.right;
			}
		}
	}
}
