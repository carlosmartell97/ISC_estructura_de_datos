package linearList;

public class Testing {
	public static void main(String[] args) {
		Chain <String> lista = new Chain <String>();
		try{
			lista.add(0, "uno");
			lista.add(1, "dos");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println(lista);
		System.out.println(lista.indexOf("doss"));
		//System.out.println(lista.get(0));
		System.out.println("remove "+lista.remove(1));
		System.out.println(lista);
	}
}
