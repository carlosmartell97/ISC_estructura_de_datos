import java.util.Arrays;

public class practice1_1<T>{
	private T[] element;
	
	public void rightShift(int k){
		T[] newElement = (T[]) new Object[this.element.length+k];
		/*for(int i=0;i<k;i++){
			newElement[i]=0;
		}*/
		System.arraycopy(this.element, 0, newElement, k, this.element.length);
		this.element=newElement;
	}
}
