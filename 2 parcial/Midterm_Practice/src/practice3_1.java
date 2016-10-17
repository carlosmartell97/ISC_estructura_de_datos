//	debería de funcionar
public class practice3_1 {
	private static int heightSoFar;
	
	public class BinaryTreeNode{
		Object element;
		BinaryTreeNode	right,
						left;
	}
	
	public class LinkedBinaryTree{
		BinaryTreeNode root;
		
		public int maxHeightDifference(){
			heightSoFar=0;
			maxHeightDifference(root.right,0);
			int heightRight=heightSoFar;
			
			heightSoFar=0;
			maxHeightDifference(root.left,0);
			int heightLeft=heightSoFar;
			
			return Math.abs(heightRight-heightLeft);
		}
		
		private void maxHeightDifference(BinaryTreeNode root,int height){
			if(root!=null){
				maxHeightDifference(root.left,++height);
				maxHeightDifference(root.right,++height);
				heightSoFar=Math.max(heightSoFar, height);
			}
		}
	}
}
