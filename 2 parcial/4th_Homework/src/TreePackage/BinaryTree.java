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
		return 0;
	}

	public int Size(BinaryNode ATree) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int Height(BinaryNode ATree) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int Size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
