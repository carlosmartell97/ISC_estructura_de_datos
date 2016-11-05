package database;

import java.util.HashMap;

public class User {
	protected String address;
	protected HashMap<Integer,Invoice> invoices=new HashMap();
	
	public User(String address){
		this.address=address;
	}
}
