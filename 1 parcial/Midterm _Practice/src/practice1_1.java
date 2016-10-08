//lo probé con Integers y funciona
import java.util.Arrays;

public class practice1_1<T>{
	private T[] element;
	
	public void rightShift(int k){
		T[] newElement = (T[]) new Object[this.element.length+k]; // O(1)
		/*for(int i=0;i<k;i++){ // O(k)
			newElement[i]=null; // O(k-1)
		}*/
		System.arraycopy(this.element, 0, newElement, k, this.element.length); // O(1)
		this.element=newElement; // O(1)
	}
	public static void main(String[] args) {
		practice1_1 o = new practice1_1();
		o.element=new Object[5];
		o.element[0]="1.0";
		o.element[1]="dos";
		o.element[2]="03";
		o.element[3]=4.3;
		o.element[4]=05;
		System.out.println(Arrays.toString(o.element));
		o.rightShift(2);
		System.out.println(Arrays.toString(o.element));
	}
}
