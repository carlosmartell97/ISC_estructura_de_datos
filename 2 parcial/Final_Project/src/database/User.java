package database;

import java.util.HashMap;

public class User {
	String name;
	
	public User(String name){
		this.name=name;
	}
	public HashMap<Invoice,Integer> invoices;
}
