import java.util.ArrayList;

public class intento<Item> extends ArrayList<Item>{
	
	public static void main(String[] args) {
		intento<Integer> lista = new intento<Integer>();
		lista.add(0, 1);
		lista.add(0, 5);
		System.out.println(lista);
	}
}
