package LinearList;

public class prueba {
	public static void main(String[] args) {
		ArrayLinearList<Integer> lista = new ArrayLinearList<Integer>(2);
		try{
			lista.add(0, 5);System.out.println("size:"+lista.size);
			lista.add(0, 1);System.out.println("size:"+lista.size);
			lista.add(0, 8);System.out.println("size:"+lista.size);
			lista.add(0, 9);System.out.println("size:"+lista.size);
			System.out.println("get:"+lista.get(0));
			System.out.println("output:"+lista.toString());
			System.out.println(lista.remove(9));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
