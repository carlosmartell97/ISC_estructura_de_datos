import java.util.NoSuchElementException;

public class Stack<T> {
	private Node<T> firstNode;
	private int size;
	
	/**
	 * default constructor method. Sets every property to default values.
	 */
	public Stack(){
		this.firstNode=null;
		this.size=0;
	}
	
	/**
	 * constructor for new Stack with a predefined firstNode.
	 * @param firstNode is what will be set as this.firstNode
	 */
	public Stack(Node<T> firstNode){
		this.firstNode=firstNode;
		this.size=0;
	}
	
	/**
	 * checks if stack is empty
	 * @return true if stack is empty. Returns false otherwise.
	 */
	public boolean isEmpty(){
		return this.size==0;
	}
	
	/**
	 * adds a new item to the Stack. Increases size by 1
	 * @param newItem: item to be added.
	 */
	public void push(T newItem){
		Node<T> toBePushed= new Node<T>(newItem,this.firstNode);
		this.firstNode=toBePushed;
		this.size++;
	}
	
	/**
	 * removes firstNode from the stack.
	 * @return the content of the Node that was removed.
	 */
	public T pop(){
		if(this.isEmpty()){
			throw new NoSuchElementException("stack is empty.");
		}
		Node<T> toBePoped=this.firstNode;
		this.firstNode=this.firstNode.next;
		this.size--;
		return toBePoped.content;
	}
	
	public T peek(){
		if(this.isEmpty()){
			throw new NoSuchElementException("stack is empty.");
		}
		return this.firstNode.content;
	}
	
	/**
	 *	this inner class will be used so we have inner objects that hold a T value each,
	 *	as well as a "next" Node so we know which one follows.
	 * @param <T>
	 */
	private static class Node<T>{
		protected T content;
		protected Node<T> next;
		
		/**
		 * default constructor method. Sets every property to default values.
		 */
		public Node(){
			this.content=null;
			this.next=null;
		}
		
		/**
		 * constructor method. Sets every property to the parameters being sent.
		 * @param content: to be defined as this.content
		 * @param next: to be defined as this.next
		 */
		public Node(T content,Node<T> next){
			this.content=content;
			this.next=next;
		}
	}
}
