
public class practice1_2 {
	public class MinHeap{
		Comparable[] heap;
		int size;
		
		public MaxHeap(int initialCapacity){
			if(initialCapacity<1){
				throw new IllegalArgumentException();
			}
			this.heap=new Comparable[initialCapacity+1];
			this.size=0;
		}
		
		public void put(Comparable element){
			//	if heap is full, resize
			if(size==heap.length-1){
				Comparable[] newHeap=new Comparable[this.heap.length*2];
				for(int i=0;i<this.heap.length-1;i++){
					newHeap[i]=this.heap[i];
				}
				this.heap=newHeap;
			}
			
			
		}
	}
}
