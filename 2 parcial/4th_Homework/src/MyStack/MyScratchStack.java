//	ya funciona todo.
package MyStack;

import java.util.EmptyStackException;

import MyStack.ChainLinearList.ChainNode;

public class MyScratchStack<Item> {
	protected ChainNode<Item> firstNode;
	protected int size;
	
	public MyScratchStack(){
		this.size=0;
		this.firstNode=null;
	}
	
	public boolean isEmpty() {
		return size==0;
	}

	public int size() {
		return this.size;
	}
	
	public Item peek(){
		if(isEmpty()) throw new EmptyStackException();
		return this.firstNode.element;
	}
	
	public void push(Item item){
		if(isEmpty()){
			this.firstNode=new ChainNode<Item>(item,null);
			this.size++;
			return;
		};
		ChainNode<Item> temp=this.firstNode;
		for(int i=0;i<this.size-1;i++){
			temp=temp.next;
		}
		ChainNode<Item> newNode=new ChainNode<Item>(item,null);
		temp.next=newNode;
		this.size++;
	}
	
	public Item pop(){
		if(isEmpty()) throw new EmptyStackException();
		ChainNode<Item> temp=this.firstNode;
		for(int i=0;i<this.size-1;i++){
			temp=temp.next;
		}
		Item toBeRemoved=temp.element;
		temp=null;
		this.size--;
		return toBeRemoved;
	}
	
	public String toString(){
		String s="";
		ChainNode<Item> temp=firstNode;
		int i=0;
		while(i<this.size){
			s=s+"["+temp.element.toString()+"]";
			temp=temp.next;
			i++;
		}
		return s;
	}
	
	static class ChainNode <Item>{
		protected Item element;
		protected ChainNode<Item> next;
		
		public ChainNode(Item element, ChainNode next){
			this.element=element;
			this.next=next;
		}
	}
	
	public static void main(String[] args) {
		MyScratchStack o =new MyScratchStack();
		System.out.println("add: "+o);
		o.push(5);
		System.out.println("add: "+o);
		System.out.println("peak: "+o.peek());
		o.push(4);
		System.out.println("add: "+o);
		System.out.println("peak: "+o.peek());
		o.push(3);
		System.out.println("add: "+o);
		System.out.println("peak: "+o.peek());
		o.push(2);
		System.out.println("add: "+o);
		System.out.println("peak: "+o.peek());
		o.pop();
		System.out.println("rem: "+o);
		System.out.println("peak: "+o.peek());
		o.pop();
		System.out.println("rem: "+o);
		System.out.println("peak: "+o.peek());
		o.pop();
		System.out.println("rem: "+o);
		System.out.println("peak: "+o.peek());
		o.pop();
		System.out.println("rem: "+o);
	}
}
