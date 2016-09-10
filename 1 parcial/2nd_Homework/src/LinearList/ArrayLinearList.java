package LinearList;

public class ArrayLinearList<Item> implements LinearList<Item>{
	protected int size;
	protected Item[] element;
	protected int initialMaxSize;
	
	public ArrayLinearList(){
		this.size=0;
		this.initialMaxSize=100;
		this.element=(Item[]) new Object[this.initialMaxSize];
	}
	
	public ArrayLinearList(int newSize){
		this.size=0;
		this.initialMaxSize=newSize;
		this.element=(Item[]) new Object[this.initialMaxSize];
	}

	public boolean isEmpty() {
		return this.size==0;
	}

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

	public int indexOf(Item item) {
		for(int i=0;i<this.size;i++){
			if(this.element[i].equals(item)){
				return i;
			}
		}
		return -1;
	}
	
	public Item remove(int index) {
		if(index<0 || index>=this.size){
			throw new IndexOutOfBoundsException("that index is out of bounds");
		}
		Item itemRemoved=element[index];
		for(int i=0;i<this.size;i++){
			element[i]=element[i+1];
		}
		this.size--;
		this.element[size-1]=null;
		return itemRemoved;
	}

	@Override
	public void add(int index, Item item) {
		if(this.size==initialMaxSize){
			//this.resize();
		}
		if(index<0 || index>this.size){
			throw new IndexOutOfBoundsException("that index is out of bounds");
		}
		if(index==this.size){
			this.element[index]=item;
		}else{
			for(int i=this.size;i>index;i--){
				element[i]=element[i-1];
			}
			this.element[index]=item;
		}
		this.size++;
	}
	
	public class IteratorArray{
		
	}
}
