import java.util.NoSuchElementException;

public class Queue<T> {
	private T[] element;
	private int size,
				maxSize,
				front,
				rear;
	
	/**
	 * creates a Queue with its properties set to default values
	 */
	public Queue(){
		this.element=(T[]) new Object[this.maxSize];
		this.size=0;
		this.maxSize=10;
		this.front=0;
		this.front=0;
	}
	
	/**
	 * creates a Queue with its properties set to default values except for size of
	 * element, which will be the int parameter being sent
	 */
	public Queue(int size){
		this.element=(T[]) new Object[size];
		this.size=0;
		this.maxSize=10;
		this.front=0;
		this.rear=0;
	}
	
	/**
	 * 
	 * @return true if Queue is empty. Return false otherwise
	 */
	public boolean isEmpty(){
		return this.size==0;
	}

	/**
	 * if the Queue is empty, throws an exception
	 * @return the element at the front.
	 */
	public T front(){
		if(this.isEmpty()){
			throw new NoSuchElementException("the queue is empty.");
		}
		return this.element[this.front];
	}
	
	/**
	 * if Queue is empty, it throws an exception
	 * @return the element at the rear of the Queue
	 */
	public T rear(){
		if(this.isEmpty()){
			throw new NoSuchElementException("the queue is empty.");
		}
		return this.element[this.rear];
	}
	
	/**
	 * adds an object to the rear of the Queue. If max capacity is reached, resize()
	 * is called.
	 * @param newItem is the T object to be inserted
	 */
	public void enqueue(T newItem){
		if(this.size==this.element.length){
			this.resize();
		}
		this.element[this.rear]=newItem;
		this.rear=(this.rear+1)%this.element.length;
		this.size++;
	}
	
	/**
	 * removes an object from the front of the Queue. If max capacity is reached, resize()
	 * is called.
	 * @return the object that was removed
	 */
	public T dequeue(){
		if(this.size==0){
			throw new NoSuchElementException("Queue is empty.");
		}
		T toBeDequeued = this.element[this.front];
		this.front=(this.front+1)%this.element.length;
		this.size--;
		return toBeDequeued;
	}
	
	/**
	 * whenever max capacity is reached, this method doubles the size of this.element
	 */
	public void resize(){
		this.maxSize*=2;
		T[] newElement=(T[]) new Object[this.maxSize];
		System.arraycopy(this.element, 0, newElement, 0, this.element.length);
		this.front=0;
		this.rear=this.element.length;
		this.element=newElement;
	}
}
