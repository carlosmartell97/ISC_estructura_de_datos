public class practice1_1<T>{
	private T[] element;
	
	public void rightShift(int k){
		T[] newElement = (T[]) new Object[this.element.length+k];
		for(int i=0;i<k;i++){
			this.element[i]=0;
		}
		System.arraycopy(this.element, k, newElement, k, newElement.length);
	}
}
