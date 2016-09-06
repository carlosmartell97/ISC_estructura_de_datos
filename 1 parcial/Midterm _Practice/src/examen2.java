import java.awt.List;
import java.util.*;

public class examen2{
	ArrayList<Integer> queue = new ArrayList<Integer>();

	public void mirrorHalves(Queue<Integer> queue){
		/*this.queue.add(10);
		this.queue.add(2);
		this.queue.add(15);
		System.out.println(queue.size());*/
		Queue<Integer> queueCopia=new LinkedList<Integer>(queue);
		Queue<Integer> result=new LinkedList<Integer>();
		Queue<Integer> queueMitad=new LinkedList<Integer>();
		Stack<Integer> s = new Stack<Integer>();getClass();
		
		for(int i=0;i<queue.size()/2;i++){
			queueMitad.add(queueCopia.remove());
			s.push(queue.remove());
		}
		for(int i=0;i<queueMitad.size();i++){
			result.add(queueMitad.remove());
		}
		for(int i=0;i<s.size();i++){
			result.add(s.pop());
		}
		s.clear();
		queueMitad.clear();
		
		for(int i=0;i<queue.size();i++){
			queueMitad.add(queueCopia.remove());
			s.push(queue.remove());
		}
		for(int i=0;i<queueMitad.size();i++){
			result.add(queueMitad.remove());
		}
		for(int i=0;i<s.size();i++){
			result.add(s.pop());
		}
		queue=result;
	}
	public examen2(){
		
	}
	public static void main(String[] args) {
		examen2 o = new examen2();
		//o.mirrorHalves(queue);
		System.out.println(2%2);
	}
}
