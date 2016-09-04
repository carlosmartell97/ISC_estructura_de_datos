// funciona con Integers. pero solo si el "n" de Q es par
// me falta:
//		-hacer que funcione con "n" de Q impares
//		-implementarlo en un Queue, como pude el problema
import java.util.Arrays;

public class practice2_4 {
	private int[] Q={1,2,3,4,5,6,7,8};
	
	public void interleave(int[] queue){
		int[] newQ=new int[this.Q.length];
		for(int i=0,contador=0; i<this.Q.length; i=i+2,contador++){
			newQ[i]=Q[contador];
			newQ[i+1]=Q[contador+this.Q.length/2];
		}
		this.Q=newQ;
	}
	
	public static void main(String[] args) {
		practice2_4 o = new practice2_4();
		System.out.println(Arrays.toString(o.Q));
		o.interleave(o.Q);
		System.out.println(Arrays.toString(o.Q));
	}
}
