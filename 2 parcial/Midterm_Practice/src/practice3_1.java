//	debería de funcionar...
public class practice3_1 {
	private static int maxDifferenceSoFar;
	
	public class BinaryTreeNode{
		Object element;
		BinaryTreeNode	right,
						left;
	}
	
	public class LinkedBinaryTree{
		BinaryTreeNode root;
		
		public int maxHeightDifference(){
			maxDifferenceSoFar=0;
			maxHeightDifference(root.right,1);
			return maxDifferenceSoFar;
		}
		
		private int maxHeightDifference(BinaryTreeNode root,int height){
			if(root!=null){
				int heightLeft=maxHeightDifference(root.left,++height);
				int heightRight=maxHeightDifference(root.right,++height);
				maxDifferenceSoFar=Math.max(maxDifferenceSoFar,Math.abs(heightLeft-heightRight));
			}
			return height;
		}
	}
}
