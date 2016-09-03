import java.util.Arrays;

public class practice1_3 {
	private int[][] element={
			{1,0,0,0,6},
			{2,11,0,0,7},
			{3,0,12,0,8},
			{4,0,0,13,9},
			{5,0,0,0,10}
	};
	private int[]compactMatrix={1,2,3,4,5,6,7,8,9,10,11,12,13};
	
	public void set(int i,int j,int newValue){
		if(i==0){
			compactMatrix[j]=newValue;
			System.out.println("change1");
		}
		else if(i==this.element.length-1){
			compactMatrix[j+this.element.length]=newValue;
			System.out.println("change2");
		}
		else{
			compactMatrix[j+(this.element.length*2)-1]=newValue;
			System.out.println("change3");
		}
	}
	public static void main(String[] args) {
		practice1_3 o = new practice1_3();
		o.set(1, 1, 66);
		System.out.println(Arrays.toString(o.compactMatrix));
	}
}
