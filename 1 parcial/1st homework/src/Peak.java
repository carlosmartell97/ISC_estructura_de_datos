import java.util.Arrays;

public class Peak {
	public static int OneDRecursive(int[] array){
		int half=array.length/2;
		if(array.length>2){
			if(array[half]>array[half-1]&&array[half]>array[half+1]){
				return array[half];
			}
			else if(array[half]>array[half-1]&&array[half]<array[half+1]){
				int[] subArray=Arrays.copyOfRange(array, half, array.length);
				//System.out.println(Arrays.toString(subArray));
				return OneDRecursive(subArray);
			}
			else{
				int[] subArray=Arrays.copyOfRange(array, 0, half+1);
				//System.out.println(Arrays.toString(subArray));
				return OneDRecursive(subArray);
			}
		}
		else if(array.length==2){
			if(array[0]>array[1]){
				return array[0];
			}
			else{
				return array[1];
			}
		}
		else{
			return array[0];
		}
	}
	
	static int[] resultados;
	public static int TwoDRecursive(int[][] array){
		resultados = new int[array.length];
		return TwoD(array,array.length);
	}
	
	private static int TwoD(int[][] array,int len){
		if(len>0){
			/*for(int i=0;i<array.length;i++){
				for(int j=0;j<array[0].length;j++){
					System.out.print(array[i][j]);
				}System.out.println();
			}*/
			resultados[len-1]=OneDRecursive(array[len-1]);
			//System.out.println("---");
			TwoD(array,len-1);
		}
		//System.out.println(Arrays.toString(resultados));
		return OneDRecursive(resultados);
	}
	public static void main(String[] args){
		//int[] prueba = {7,9,5,1};
		//System.out.println(OneDRecursive(prueba));
		
		//int[][] prueba2D_2 = {{6,8,7,6},{7,9,8,3}};
		//System.out.println(TwoDRecursive(prueba2D_2));
		//int[][] prueba2D = {{1,3,2,1},{2,8,4,3},{1,3,5,1}};
		//System.out.println(TwoDRecursive(prueba2D));
	}
}
