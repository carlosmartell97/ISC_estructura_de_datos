
public class ArrayLinearList <Item>{
	protected Item[] element;
	protected int size;
	protected int maxSize=100;
	
	public ArrayLinearList(){
		this.size=0;
		this.element=(Item[]) new Object[this.maxSize];
	}
	
	public ArrayLinearList(int newSize){
		this.size=0;
		this.element=(Item[]) new Object[newSize];
		this.maxSize=newSize;
	}
	
	public void add(int index, Item item) {
		if(this.size==this.maxSize){
			this.resize();
		}
		if(index<0 || index>this.size){
			throw new IndexOutOfBoundsException("that index is out of bounds");
		}
		if(index==this.size){
			this.element[index]=item;
		}
		else{
			for(int i=this.size; i>index; i--){
				element[i]=element[i-1];
			}
			this.element[index]=item;
		}
		this.size++;
	}
	
	public void resize(){
		this.maxSize*=2;
		Item[] newArray=(Item[]) new Object[this.maxSize];
		System.arraycopy(this.element, 0, newArray, 0, this.size);
		this.element=newArray;
	}
	
	public String toString() {
		String s="";
		for(int i=0; i<this.size; i++){
			s+="["+this.element[i].toString()+"]";
		}
		return s;
	}
	
	public void rightShift(int shift){
		if(this.size==0){
			throw new IndexOutOfBoundsException("there are no elements");
		}
		if((this.size+shift)>this.maxSize){
			this.resize();System.out.println("resize");
		}
		int s=this.size;
		for(int i=s;i<s+shift;i++){
			this.add(i, this.element[i-shift]);
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
		ArrayLinearList<Integer> lista=new ArrayLinearList<Integer>();
		lista.add(0, 5);
		lista.add(0, 3);
		lista.add(1, 4);
		System.out.println(lista);
		
		//lista.add(3, 8);
		//System.out.println(lista);
		
		lista.rightShift(2);
		System.out.println(lista);
			//lista.rightShift(1);
			//System.out.println(lista);
		//lista.add(3,0);System.out.println(lista);
	}
}
