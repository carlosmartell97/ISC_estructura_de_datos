public class practice2_1 {
	public class BinaryTreeNode{
		Object element;
		BinaryTreeNode	left,
						right;
	}
	public class LinkedBinaryTree{
		BinaryTreeNode root;
		private Object toBeReturned;
		
		public Object elementAtLevel(int level){
			toBeReturned=null;
			find(this.root,level,1);
			return toBeReturned;
		}
		
		private void find(BinaryTreeNode root,int level,int currentLevel){
			if(root!=null){
				if(currentLevel==level){
					toBeReturned=root.element;
					return;
				}
				//	go to the left-most node
				find(root.left,level,++currentLevel);
				//	go to the right-most node
				find(root.right,level,++currentLevel);
			}
		}
	}
}
