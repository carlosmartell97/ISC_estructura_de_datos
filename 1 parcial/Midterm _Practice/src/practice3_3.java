//	ya, 100%. Necesito entender qué es lo que hace
public class practice3_3 {
	private MyChainNode headerNode=new MyChainNode();
	//this.headerNode.element=INFINITY;
	private int size; //	excludes the headerNode
	
	public void merge(practice3_3 a,practice3_3 b){
		MyChainNode currentA=a.headerNode.next,
					currentB=b.headerNode.next,
					lastThis=headerNode;
		while(currentA!=a.headerNode || currentB!=b.headerNode){
			//	merge from a
			if(currentA.element<=currentB.element){
				lastThis=lastThis.next=currentA;
				currentA=currentA.next;
			}
			//	merge from b
			else{
				lastThis=lastThis.next=currentB;
				currentB=currentB.next;
			}
		}
		//	now, close circular list and update size
		lastThis.next=headerNode;
		size=a.size+b.size;
		
		//	empty a and b
		a.headerNode.next=a.headerNode;
		b.headerNode.next=b.headerNode;
		a.size=b.size=0;
	}
	
	private static class MyChainNode{
		int element;
		MyChainNode next;
	}
}
