//funciona.
import java.util.Arrays;

public class practice2_1<T>{
	private T[] element;
	
	public void compress(){
		T[] newElement=(T[]) new Object[(1+this.element.length)/2];	//	O(1)
		for(int i=0,x=0;i<this.element.length;i=i+2,x++){	//	O(n)
			newElement[x]=this.element[i];	//	O(n-1)
		}
		this.element=newElement;	//	O(1)
	}
	
	public static void main(String[] args) {
		practice2_1 o = new practice2_1();
		o.element=new Object[6];
		o.element[0]=1;
		o.element[1]="dos";
		o.element[2]=3.0;
		o.element[3]=4;
		o.element[4]="hola";
		o.element[5]="ultimo";
		o.compress();
		System.out.println(Arrays.toString(o.element));
	}
}
