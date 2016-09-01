
public class intento<Item> extends ArrayLinearList<Item>{
	private int size;
	private Item[] element;
	private int maxSize=100;
	public intento(){
		this.size=0;
		this.element=(Item[]) new Object[maxSize];
	}
	
	public static void main(String[] args) {
		intento<Integer> lista = new intento<Integer>();
		lista.add(0, 1);
		System.out.println(lista);
	}
}
