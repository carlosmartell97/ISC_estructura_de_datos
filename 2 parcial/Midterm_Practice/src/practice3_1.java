//
public class practice3_1 {
	public class BinaryTreeNode{
		Object element;
		BinaryTreeNode	right,
						left;
	}
	
	public class LinkedBinaryTree{
		BinaryTreeNode root;
		
		public int maxHeightDifference(){
			return maxHeightDifference(root);
		}
		
		private int maxHeightDifference(BinaryTreeNode root){
			if(root==null){
				return 0;
			}
			//	Math.max(a,b);
			//	Math.abs(a);
		}
	}
}
