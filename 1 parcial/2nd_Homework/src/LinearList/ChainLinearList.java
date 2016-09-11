package LinearList;

public class ChainLinearList<Item>{
	protected ChainNode<Item> firstNode;
	protected int size;
	
	public ChainLinearList(){
		this.firstNode=null;
		this.size=0;
	}
	
	public boolean isEmpty(){
		return this.size==0;
	}
	
	public int size(){
		return this.size;
	}
	
	public Item get(int index){
		if(index<0 || index>=this.size){
			throw new IndexOutOfBoundsException("that index is out of bounds.");
		}
		ChainNode<Item> temp= firstNode;
		for(int i=0;i<this.size;i++){
			temp=temp.next;
		}
		return temp.content;
	}
	
	public int indexOf(Item item){
		ChainNode<Item> temp=this.firstNode;
		for(int i=0;i<this.size;i++){
			if(temp.content.equals(item)){
				return i;
			}
			temp=temp.next;
		}
		return -1;
	}
	
	public Item remove(int index){
		if(index<0 || index>=this.size){
			throw new IndexOutOfBoundsException("that index is out of bounds.");
		}
		Item value=null;
		ChainNode<Item> temp=this.firstNode;
		if(index==0){
			value=temp.content;
			this.firstNode=this.firstNode.next;
			this.size--;
			return value;
		}else{
			for(int i=0;i<index-1;i++){
				temp=temp.next;
			}
			value=temp.next.content;
			temp.next=temp.next.next;
			this.size--;
			return value;
		}
	}
	
	public void add(int index,Item item){
		if(index<0 || index>this.size){
			throw new IndexOutOfBoundsException("that index is out of bounds.");
		}
		ChainNode<Item> newNode;
		if(index==0){
			newNode=new ChainNode<Item>(item,this.firstNode);
			this.firstNode=newNode;
		}else{
			ChainNode next,
						prev;
			prev=this.firstNode;
			for(int i=0;i<index;i++){
				prev=prev.next;
			}
			next=prev.next;
			newNode=new ChainNode<Item>(item,next);
			prev.next=newNode;
		}
		this.size++;
	}
	
	public String toString(){
		String output="{";
		ChainNode<Item> temp=this.firstNode;
		for(int i=0;i<this.size;i++){
			output+=temp.content.toString();
			if(i!=this.size-1){
				output+=",";
			}
			temp=temp.next;
		}
		return output+"}";
	}
	
	protected static class ChainNode<Item>{
		protected Item content;
		protected ChainNode<Item> next;
		
		public ChainNode(){
			this.content=null;
			this.next=null;
		}
		
		public ChainNode(Item content){
			this.content=content;
			this.next=null;
		}
		
		public ChainNode(Item content,ChainNode<Item> next){
			this.content=content;
			this.next=next;
		}
	}
	
	public static void main(String[] args) {
		ChainLinearList<Integer> o=new ChainLinearList();
		try{
			o.add(0, 6); o.add(0, 5); o.add(0, 4);
			System.out.println(o);
			o.remove(1);
			System.out.println(o);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
