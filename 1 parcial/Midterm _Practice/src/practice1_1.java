
public class practice1_1<Item> extends ArrayLinearList<Item>{
	private ArrayLinearList element;
	private int size;
	
	public practice1_1(){
		this.element=new ArrayLinearList<Item>();
	}
	
	public void rightShift(int shift){
		/*Item[] array = Arrays.copyOf(this.element, maxSize);
		System.out.println(array.toString());*/
		
		if(this.size==0){
			throw new IndexOutOfBoundsException("there are no elements");
		}
		if((this.size+shift)>this.maxSize){
			this.resize();System.out.println("resize");
		}
		int s=this.size;
		for(int i=s;i<s+shift;i++){
			if(i-size<=shift){
				this.add(i, this.element[i-shift]);
			}
			//System.out.println("for");
		}
		System.out.println("done");
		
		/*for(int i=this.size+shift;i>0;i--){
			if(i>this.size){
				System.out.println("add");
				this.add(i-shift,this.element[i-shift-1]);
			}
			else{
				this.element[i]=this.element[i-1];
			}
		}*/
		
		/*for(int i=0;i<shift;i++){
			this.add(0, (Item)0);System.out.println("add");
		}*/
	}
	
	public static void main(String[] args) {
		practice1_1<Integer> lista= new practice1_1<Integer>();
		lista.add(0, 5);
		System.out.println(lista);
	}
}
