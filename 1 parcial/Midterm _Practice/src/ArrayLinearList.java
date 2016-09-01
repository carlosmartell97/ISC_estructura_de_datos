
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
		//AQUÍ VOY
		if((this.size+shift)>this.maxSize){
			this.resize();
		}
	}
	
	public static void main(String[] args) {
		ArrayLinearList<Integer> lista=new ArrayLinearList<Integer>();
		lista.add(0, 5);
		lista.add(0, 3);
		lista.add(1, 4);
		System.out.println(lista);
	}
}
