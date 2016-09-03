public class practice1_1{
	private int[] element;
	
	public practice1_1(){
		this.element=new int[4];
		this.element[0]=1;
		this.element[1]=2;
		this.element[2]=3;
		this.element[3]=4;
	}
	
	public void rightShift(int k){
		int[] newElement = new int[this.element.length+k];
		for(int i=0;i<k;i++){
			this.element[i]=0;
		}
		System.arraycopy(this.element, k, newElement, k, newElement.length);
	}
	
	public static void main(String[] args) {
		practice1_1 o = new practice1_1();
		System.out.println(o.element.toString());
	}
}
