import java.util.Arrays;

public class practice1_1{
	private int[] element={1,2,3,4};
	
	public void rightShift(int k){
		int[] newElement = new int[this.element.length+k];
		for(int i=0;i<k;i++){
			this.element[i]=0;
		}
		System.arraycopy(this.element, k, newElement, k, newElement.length);
	}
	
	public static void main(String[] args) {
		practice1_1 o = new practice1_1();
		System.out.println(Arrays.toString(o.element));
		int[] d = {3,2,1};
		System.out.println(d.toString());
	}
}
