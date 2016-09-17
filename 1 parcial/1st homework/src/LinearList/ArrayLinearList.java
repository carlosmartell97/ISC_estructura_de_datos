package LinearList;

public class ArrayLinearList<Item> implements LinearList<Item>{
	protected int size;
	protected Item[] element;
	protected int initialMaxSize=100;
	
	public ArrayLinearList(){
		this.size=0;
		this.initialMaxSize=100;
		this.element=(Item[]) new Object[this.initialMaxSize];
	}
	
	public ArrayLinearList(int newSize){
		this.size=0;
		this.initialMaxSize=newSize;
		this.element=(Item[]) new Object[newSize];
	}
	
	@Override
	public boolean isEmpty() {
		return this.size==0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public Item get(int index) {
		if(index<0 || index>=this.size){
			throw new IndexOutOfBoundsException("that index is out of bounds");
		}
		if(this.size==0){
			return null;
		}
		return this.element[index];
	}

	@Override
	public int indexOf(Item item) {
		for(int i=0; i<this.size; i++){
			if(element[i].equals(item)){
				return i;
			}
		}
		return -1;
	}

	@Override
	public Item remove(int index) {
		if(index<0 || index>=this.size){
			throw new IndexOutOfBoundsException("that index is out of bounds");
		}
		Item itemRemoved=element[index];
		for(int i=index; i<this.size-1; i++){
			element[i]=element[i+1];
		}
		this.size--;
		this.element[size-1]=null;
		return itemRemoved;
	}

	@Override
	public void add(int index, Item item) {
		if(this.size==initialMaxSize){
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

	@Override
	public String toString() {
		String s="";
		for(int i=0; i<this.size; i++){
			s+="["+this.element[i].toString()+"]";
		}
		return s;
	}
	
	public void resize(){
		this.initialMaxSize*=2;
		Item[] newArray=(Item[]) new Object[this.initialMaxSize];
		System.arraycopy(this.element, 0, newArray, 0, this.size);
		this.element=newArray;
	}
	
	public static void main(String[] args) {
		ArrayLinearList<Integer> o = new ArrayLinearList<Integer>();
		o.add(0, 5); 
		o.add(0, 4);
		System.out.println(o);
		System.out.println(o.get(0));
	}
}
