//	me falta:
//		-todo, básicamente. Tengo que volver a leer el problema y seguirle
//		donde me quedé
import java.util.Arrays;

public class practice3_2<T>{
	T[] element;
	public void removeNull(){
		System.out.println(Arrays.toString(element));
	}
	
	public static void main(String[] args) {
		practice3_2 o = new practice3_2();
		o.element = new Object[3];
		o.element[0]=1;
		o.element[1]="dos";
		o.element[2]=3.0;
		o.removeNull();
	}
}
