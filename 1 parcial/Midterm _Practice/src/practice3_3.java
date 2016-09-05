public class practice3_3 {
	private MyChainNode headerNode=new MyChainNode();
	//this.headerNode.element=INFINITY;
	private int size; //	excludes the headerNode
	
	public void merge(practice3_3 a,practice3_3 b){
		MyChainNode currentA=a.headerNode.next,
					currentB=b.headerNode.next,
					lastThis=headerNode;
	}
	
	private static class MyChainNode{
		int element;
		MyChainNode next;
	}
}
