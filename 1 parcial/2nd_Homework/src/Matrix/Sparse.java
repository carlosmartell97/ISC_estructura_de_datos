package Matrix;

class SparseMatrix<T>{
	private int columns,
				rows;
	private Node[][] container;
	
	public SparseMatrix(T[][] element){
		this.rows=element.length;
		this.columns=element[0].length;
		this.container=(Node[][]) new Object[this.rows][this.columns];
		
		for(int i=0;i<element.length;i++){
			for(int j=0;j<element[0].length;j++){
				container[i][j]=new Node<T>(element[i][j],i+1,j+1,null);
				if(i==element.length && j==element[0].length){
					container[i][j].next=null;
				}else{
					if(j==element[0].length){
						container[i][j].next=new Node<T>(element[i+1][0],i+1,j+1,null);
					}else{
						container[i][j].next=new Node<T>(element[i][j+1],i+1,j+1,null);	
					}
				}
			}
		}
	}
	
	public void add(int i,int j,T item){
		if(i<1 || i>this.rows || j<1 || j>this.columns){
			throw new IndexOutOfBoundsException("that index is out of bounds.");
		}
		if(i==this.container.length && j==this.container[0].length){
			container[i][j]=new Node<T>(item,i+1,j+1,null);
		}else{
			if(j==this.container[0].length){
				container[i][j].next=new Node<T>(item,i+1,j+1,container[i+1][0]);
			}else{
				container[i][j].next=new Node<T>(item,i+1,j+1,container[i][j+1]);	
			}
		}
	}
	
	public T get(int i,int j){
		if(i<1 || i>this.rows || j<1 || j>this.columns){
			throw new IndexOutOfBoundsException("that index is out of bounds.");
		}
		return (T) container[i][j].item;
	}
	
	public T remove(int i,int j){
		if(i<1 || i>this.rows || j<1 || j>this.columns){
			throw new IndexOutOfBoundsException("that index is out of bounds.");
		}
		T toBeRemoved=(T) container[i][j].item;
		if(i==this.container.length && j==this.container[0].length){
			container[i][j]=new Node<T>(null,i+1,j+1,null);
		}else{
			if(j==this.container[0].length){
				container[i][j].next=new Node<T>(null,i+1,j+1,container[i+1][0]);
			}else{
				container[i][j].next=new Node<T>(null,i+1,j+1,container[i][j+1]);	
			}
		}
		return toBeRemoved;
	}
	
	public String toString(){
		String output="[";
		for(int i=0;i<this.rows;i++){
			for(int j=0;j<this.columns;j++){
				if(j!=this.container[0].length){
					output+="[" + this.container[i][j].item + "],";
				}else{
					output+="[" + this.container[i][j].item + "]";
				}
			}
		}
		return output+"]";
	}
	
	protected static class Node<T>{
		protected T item;
		protected int i,
						j;
		protected Node<T> next;
		
		public Node(){
			this(null,0,0,null);
		}
		
		public Node(T item,int i,int j,Node<T> next){
			this.item=item;
			this.i=i;
			this.j=j;
			this.next=next;
		}
	}
	
	public static void main(String[] args) {
		Integer[][] element={
				{0,0,3,4,0,0,0,0,1,0},
				{0,2,0,0,0,0,3,0,0,0},
				{0,0,0,6,0,0,5,0,0,0},
				{8,0,0,0,0,4,1,0,0,0},
				{0,0,0,4,0,0,0,0,5,0},
				{0,4,0,0,0,0,8,0,0,0},
				{0,0,0,0,0,0,0,6,2,0},
				{0,0,7,2,0,0,9,0,0,1}
		};
		SparseMatrix<Integer> o=new SparseMatrix<Integer>(element);
		System.out.println(o);
	}
}
