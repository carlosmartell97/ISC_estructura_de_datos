package database;

import java.util.HashMap;

public class User {
	protected String address;
	protected HashMap<Integer,Invoice> invoices=new HashMap();
	protected int userExpense;
	
	public User(String address){
		this.address=address;
	}
}
