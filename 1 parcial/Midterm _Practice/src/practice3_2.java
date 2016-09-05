//	me falta:
//		-todo, básicamente. Tengo que volver a leer el problema y seguirle
//		donde me quedé
import java.util.Arrays;

public class practice3_2<T>{
	private T[] element;
	private int size;
	
	public void removeNull(){
		int newSize=0;
		for(int i=0;i<this.element.length;i++){
			if(this.element[i]!=null){
				this.element[newSize++]=this.element[i];
			}
		}
		for(int i=newSize;i<this.element.length;i++){
			this.element[i]=null;
		}
		this.size=newSize;
		
		System.out.println("for:");
		for(int i=0;i<this.size;i++){
			System.out.println(this.element[i]);
		}
		System.out.println("one time:");
		System.out.println(Arrays.toString(this.element));
	}
	
	public static void main(String[] args) {
		practice3_2 o = new practice3_2();
		o.element = new Object[5];
		o.element[0]=1;
		o.element[1]="dos";
		o.element[2]=null;
		o.element[3]=3.0;
		o.element[4]=null;
		o.removeNull();
	}
}
