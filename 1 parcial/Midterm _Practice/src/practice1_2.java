public class practice1_2<T>{
	private ChainNode<T> firstNode;
	private int size;
	
	private static class ChainNode<T>{
		T element;
		ChainNode<T> next;
	}
}
