package TreePackage;

public class BinaryTree implements BTree{
	private BinaryNode root;
	
	public boolean IsEmpty() {
		return this.root==null;
	}

	public BinaryNode gRoot() {
		return this.root;
	}

	public int Count() {
		return this.Count(this.root);
	}
	
	private int Count(BinaryNode root){
		if(root==null) return 0;
		if(root.gRight()==null && root.gLeft()==null) return 1;
		
		int total=Count((BinaryNode) root.gRight());
		total+=Count((BinaryNode) root.gLeft());
		
		return total;
	}

	public int Size(BinaryNode ATree) {
		if(ATree==null) return 0;
		
		int right=Size((BinaryNode) ATree.gRight());
		int left=Size((BinaryNode) ATree.gLeft());
		
		return left+right+1;
	}

	public int Height(BinaryNode ATree) {
		if(ATree==null){
			return 0;
		}
		return 1 + Math.max(Height((BinaryNode) ATree.gLeft()),Height((BinaryNode) ATree.gRight()));
	}

	public int Size() {
		return this.Size(this.root);
	}

}
