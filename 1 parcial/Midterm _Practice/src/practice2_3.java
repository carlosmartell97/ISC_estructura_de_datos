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
		System.out.println(i);System.out.println(j);
		return 1;
	}
	
	public static void main(String[] args) {
		practice2_3 o = new practice2_3();
		o.get(1, 2);
	}
}
