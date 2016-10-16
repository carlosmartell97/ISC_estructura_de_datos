
public class practice1_2 {
	public class MinHeap{
		Comparable[] heap;
		int size;
		
		public MinHeap(int initialCapacity){
			if(initialCapacity<1){
				throw new IllegalArgumentException();
			}
			this.heap=new Comparable[initialCapacity+1];
			this.size=0;
		}
		
		public void put(Comparable element){
			//...
		}
	}
}
