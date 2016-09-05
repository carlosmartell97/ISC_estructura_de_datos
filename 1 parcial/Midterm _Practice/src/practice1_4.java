//	solo me falta el reverse(), que es para invertir los contenidos
public class practice1_4<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	public void reverse(){
		T temp;
	}
	
	public void myQueueReverse(){
		tail=head;
		Node<T> current = head;
		head=null;
		while(current!=null){
			Node<T> next=current.next;
			current.next=head;
			head=current;
			current=next;
		}
	}
	
	private static class Node<T>{
		Node<T> next;
		T content;
	}
}
