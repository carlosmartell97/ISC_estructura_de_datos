package LinearList;

import java.util.Iterator;

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
			this.resize();
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
	
	public String toString(){
		String output="[";
		for(int i=0;i<this.size;i++){
			output+="["+this.element[i].toString()+"]";
			if(i!=this.size-1){
				output+=",";
			}
		}
		return output+"]";
	}
	
	private void resize(){
		this.initialMaxSize*=2;
		Item[] newArray=(Item[]) new Object[initialMaxSize];
		System.arraycopy(this.element, 0, newArray, 0, this.size);
		this.element=newArray;
	}
	
	protected class IteratorArray implements Iterator<Item>{
		private int nextIndex;
		private boolean nextCalled;
		
		protected IteratorArray(){
			this.nextIndex=0;
			this.nextCalled=false;
		}
		
		public boolean hasNext() {
			return this.nextIndex!=ArrayLinearList.this.size-1;
		}

		public Item next() {
			this.nextIndex++;
			this.nextCalled=true;
			return ArrayLinearList.this.element[nextIndex-1];
		}
		public void remove(){
			if(this.nextCalled){
				this.nextIndex--;
				ArrayLinearList.this.remove(nextIndex);
			}else{
				throw new IllegalStateException();
			}
			this.nextCalled=false;
		}
	}
	
	public static void main(String[] args) {
		ArrayLinearList<Integer> o=new ArrayLinearList();
		ArrayLinearList.IteratorArray itr = o.new IteratorArray();
		try{
			System.out.println(o.size);
			o.add(0, 3);o.add(0, 2);
			System.out.println(o.size);
			System.out.println(o);
			
			System.out.println(itr.hasNext());
			System.out.println(itr.next());
			System.out.println(itr.hasNext());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
