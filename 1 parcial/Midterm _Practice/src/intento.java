import java.util.ArrayList;

public class intento<Item> extends ArrayList<Item>{
	private int size;
	private ArrayList element;
	private int maxSize=100;
	public intento(){
		this.size=0;
		this.element=new ArrayList<Item>();
	}
	
	public static void main(String[] args) {
		intento<Integer> lista = new intento<Integer>();
		lista.add(0, 1);
		System.out.println(lista);
	}
}
