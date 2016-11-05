package database;

import java.util.HashMap;

public class Database {
	protected static HashMap<String,User> users=new HashMap();
	
	public String getAdress(String name){
		return users.get(name).address;
	}
	
	public void add(String newName,String address){
		User user=new User(address);
		users.put(newName,user);
	}
	
	
	public boolean contains(String key){
		return users.containsKey(key);
	}
	
	public static void main(String[] args) {
		
		Database database=new Database();
		database.add("Juan","Bugambilias");
		
		System.out.println(database.getAdress("Juan"));
		System.out.println(database.contains("Juan"));
		System.out.println(database.contains("John"));
	}
}
