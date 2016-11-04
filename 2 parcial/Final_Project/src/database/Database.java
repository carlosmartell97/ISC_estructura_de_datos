package database;

import java.util.HashMap;

public class Database {
	protected static HashMap<User,String> users=new HashMap();
	
	public String getAdress(String name){
		User test=new User(name);
		return users.get(name);
	}
	
	public void add(String newName,String address){
		User name=new User(newName);
		users.put(name, address);
	}
	
	
	public void contains(String key){
		
	}
	
	public static void main(String[] args) {
		
		Database database=new Database();
		database.add("Juan","Bugambilias");
		//System.out.println(database.getAdress("Juan"));
		System.out.println(database.getAdress("Juan"));
		
		/*User uno = new User("s");
		User dos = new User("a");
		System.out.println(uno.equals(dos));*/
	}
}
