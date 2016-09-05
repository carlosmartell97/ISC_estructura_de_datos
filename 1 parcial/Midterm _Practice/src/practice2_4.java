// funciona con Integers.
// me falta:
//		-entender la implementación en un Queue
import java.util.Queue;
import java.util.Stack;

public class practice2_4 {
	private int[] Q={1,2,3,4,5,6,7,8};
	
	/*public void interleave(int[] queue){
		int[] newQ=new int[this.Q.length];
		for(int i=0,contador=0; i<this.Q.length; i=i+2,contador++){
			newQ[i]=Q[contador];
			newQ[i+1]=Q[contador+this.Q.length/2];
		}
		this.Q=newQ;
	}*/
	
	public static void interleave(Queue<Integer> queue){
		if(queue.size()%2!=0){
			throw new IllegalArgumentException("queue must have even size");
		}
		Stack<Integer> stack = new Stack<Integer>();
		int halfSize = queue.size()/2;
		for(int i=0;i<halfSize;i++){
			stack.push(queue.remove());
		}
		while(!stack.isEmpty()){
			queue.add(stack.pop());
		}
		for(int i=0;i<halfSize;i++){
			stack.push(queue.remove());
		}
		while(!stack.isEmpty()){
			queue.add(stack.pop());
			queue.add(queue.remove());
		}
	}
	
	public static void main(String[] args) {
		/*practice2_4 o = new practice2_4();
		System.out.println(Arrays.toString(o.Q));
		o.interleave(o.Q);
		System.out.println(Arrays.toString(o.Q));*/
	}
}
