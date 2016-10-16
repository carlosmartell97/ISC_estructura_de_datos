public class practice2_1 {
	public class BinaryTreeNode{
		Object element;
		BinaryTreeNode	left,
						right;
	}
	public class LinkedBinaryTree{
		BinaryTreeNode root;
		
		public Object elementAtLevel(int level){
			find(this.root,level,1);
		}
		
		private void find(BinaryTreeNode root,int level,int currentLevel){
			if(root!=null){
				
				find(root.left,level,++currentLevel);
				find(root.left,level,++currentLevel);
			}
		}
	}
}
