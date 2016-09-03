//ya funciona con Integers.
import java.util.Arrays;

public class practice2_1<T>{
	private T[] element;
	
	public void compress(){
		T[] newElement=(T[]) new Object[(1+this.element.length)/2];
		for(int i=0,x=0;i<this.element.length;i=i+2,x=x+1){
			newElement[x]=this.element[i];
		}
		this.element=newElement;
	}
	
	public static void main(String[] args) {
		/*practice2_1 o = new practice2_1();
		o.compress();
		System.out.println(Arrays.toString(o.element));*/
	}
}
