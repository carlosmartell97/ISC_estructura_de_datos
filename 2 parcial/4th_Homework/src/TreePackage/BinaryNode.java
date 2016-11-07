package TreePackage;

public class BinaryNode implements BTNode{
	private int key;
	private BinaryNode 	left,
						right;
	
	public int getKey() {
		return this.key;
	}

	public BTNode gLeft() {
		return this.left;
	}

	public BTNode gRight() {
		return this.right;
	}

	public void sKey(int AValue) {
		this.key=AValue;
	}

	public void sLeft(BTNode AValue) {
		this.left=(BinaryNode) AValue;
	}

	public void sRight(BTNode AValue) {
		this.right=(BinaryNode) AValue;
	}

}
