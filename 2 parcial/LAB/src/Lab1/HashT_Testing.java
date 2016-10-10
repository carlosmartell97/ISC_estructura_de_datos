package Lab1;

import java.util.Iterator;

public class HashT_Testing {
	public static void main(String[] args) {
		HashT<String,Integer> table=new HashT<String,Integer>();
		
		table.add("dos + dos", 4); System.out.println("size: "+table.size());
		table.add("dos + cuatro", 6); System.out.println("size: "+table.size());
		table.add("ocho - uno", 7); System.out.println("size: "+table.size());
		table.add("cinco + tres", 8); System.out.println("size: "+table.size());
		System.out.println("remove: "+table.remove("dos + dos")); System.out.println("size: "+table.size());
		table.add("diez - cinco", 5); System.out.println("size: "+table.size());
		
		Iterator<String> key=table.getKeyIterator();
		System.out.println(key.next());
		if(key.hasNext()){
			System.out.println(key.next());
		}
		
		Iterator<Integer> value=table.getValueIterator();
		System.out.println(value.next());
		if(key.hasNext()){
		}
			System.out.println(value.next());
	}
}
