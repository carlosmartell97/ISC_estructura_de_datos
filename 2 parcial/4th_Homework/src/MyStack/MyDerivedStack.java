package MyStack;

import java.util.EmptyStackException;

public class MyDerivedStack<Item> extends ChainLinearList<Item>{
	public MyDerivedStack(){
		super();
	}
	
	public Item peek(){
		if(this.isEmpty()) throw new EmptyStackException();
		return this.get(0);
	}
	
	public void push(Item newItem){
		this.add(this.size, newItem);
	}
	
	public Item pop(){
		if(this.isEmpty()) throw new EmptyStackException();
		return this.remove(this.size);
	}
}
