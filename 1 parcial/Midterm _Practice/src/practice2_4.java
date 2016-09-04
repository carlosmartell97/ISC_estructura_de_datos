import java.util.Arrays;

public class practice2_4 {
	private int[] Q={1,2,3,4,5,6,7,8,9,10};
	
	public void interleave(int[] queue){
		System.out.println(Arrays.toString(queue));
	}
	
	public static void main(String[] args) {
		practice2_4 o = new practice2_4();
		o.interleave(o.Q);
	}
}
