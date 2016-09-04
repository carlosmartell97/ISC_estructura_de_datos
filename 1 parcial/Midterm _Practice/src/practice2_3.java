public class practice2_3 {	
	private int[][] element={
			{1,2,3,4,5,6,7},
			{22,0,0,0,0,0,0},
			{23,0,0,0,0,0,0},
			{8,9,10,11,12,13,14},
			{0,0,0,0,0,0,24},
			{0,0,0,0,0,0,25},
			{15,16,17,18,19,20,21}
	};
	private int[] compactSmatrix={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
	private int size;
	
	public int get(int i,int j){
		if( (i<1 || i>this.element.length) || (j<1 || j>this.element.length) ){
			throw new IndexOutOfBoundsException("that index is out of bounds");
		}
		if(j==1){
			return this.compactSmatrix[i-1];
		}
		else if(j-1==this.element.length/2){
			return this.compactSmatrix[i-1+this.element.length];
		}
		else if(j==this.element.length){
			return this.compactSmatrix[i-1+(this.element.length)*2];
		}
		else{
			if(i==1){
				// este 2 que le estoy restando abajo creo que debería de depender
				// más bien de this.element.length, no creo que siempre
				// vaya a ser 2
				return this.compactSmatrix[i-1+(this.element.length*3)+j-2];
			}
			else{
				// este 9 que le estoy restando abajo creo que debería de depender
				// más bien de this.element.length, no creo que siempre
				// vaya a ser 9
				return this.compactSmatrix[i-1+(this.element.length*3)+j-9];
			}
		}
	}
	
	public static void main(String[] args) {
		practice2_3 o = new practice2_3();
		System.out.println(o.get(7, 6));
	}
}
