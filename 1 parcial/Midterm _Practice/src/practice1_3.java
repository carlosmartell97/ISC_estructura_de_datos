//funciona con Integers.
import java.util.Arrays;

public class practice1_3<T>{
	private int[][] sampleCompactElement={
			{1,0,0,0,6},
			{2,11,0,0,7},
			{3,0,12,0,8},
			{4,0,0,13,9},
			{5,0,0,0,10}
	};
	private int[]sampleCompactMatrix={1,2,3,4,5,6,7,8,9,10,11,12,13};
	
	private T[][] element;
	private T[] compactMatrix;
	
	//los índices comienzan en 1, no en 0
	public void set(int i,int j,T newValue){
		if( (i<1 || j>this.element.length) || (j<1 || j>this.element.length) ){
			throw new IndexOutOfBoundsException("that index is out of bounds");
		}
		if(i==1){
			compactMatrix[j-1]=newValue;
			//System.out.println("change1");
		}
		else if(i==this.element.length){
			compactMatrix[j-1+this.element.length]=newValue;
			//System.out.println("change2");
		}
		else{
			compactMatrix[j-1+(this.element.length*2)-1]=newValue;
			//System.out.println("change3");
		}
	}
	public static void main(String[] args) {
		/*practice1_3 o = new practice1_3();
		o.set(5, 2, 66);
		System.out.println(Arrays.toString(o.compactMatrix));*/
	}
}
