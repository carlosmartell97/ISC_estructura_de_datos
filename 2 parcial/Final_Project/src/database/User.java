package database;

import java.util.HashMap;

public class User {
	String address;
	
	public User(String address){
		this.address=address;
	}
	public HashMap<String,Invoice> invoices;
}
