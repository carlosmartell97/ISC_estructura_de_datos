//	debería ya de funcionar. Podría hacer testing cuando tenga tiempo...
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class practice3_2 {
	public static Queue reverseFirstK(int k,Queue queue){
		if(queue.isEmpty()){
			throw new IllegalArgumentException("queue is empty!");
		}
		Stack flip=new Stack();
		Queue toBeReturned=new LinkedList();
		
		for(int i=0;i<k;i++){
			flip.push(queue.remove());
		}
		
		while(!flip.isEmpty()){
			toBeReturned.add(flip.pop());
		}
		while(!queue.isEmpty()){
			toBeReturned.add(queue.remove());
		}
		
		return toBeReturned;
	}
}
