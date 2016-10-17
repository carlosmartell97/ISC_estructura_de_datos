//	Ya funciona todo.
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
	
	public static void main(String[] args) {
		Queue q=new LinkedList<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.add(6);
		System.out.println(q);
		System.out.println("2: "+reverseFirstK(2, q));
	}
}
