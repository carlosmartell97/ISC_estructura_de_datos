import java.util.Arrays;

public class practice1_1{
	private int[] element={1,2,3,4};
	
	public void rightShift(int k){
		int[] newElement = new int[this.element.length+k];
		/*for(int i=0;i<k;i++){
			newElement[i]=0;
		}*/
		System.arraycopy(this.element, 0, newElement, k, this.element.length);
		this.element=newElement;
	}
	
	public static void main(String[] args) {
		practice1_1 o = new practice1_1();
		System.out.println(Arrays.toString(o.element));
		o.rightShift(2);
		System.out.println(Arrays.toString(o.element));
	}
}
