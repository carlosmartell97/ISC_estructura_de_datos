/**
 *	Carlos Emmanuel Martell Avi�a A01225920
 *	Jes�s Alberto Alvarez Gomez A01039332
 */
package database;

import java.util.HashMap;

public class User {
	protected String address;
	protected HashMap<Integer,Invoice> invoices=new HashMap(); //Hash map that stores invoices belonging to a particular user
	
	//constructor, sets user address
	public User(String address){
		this.address=address;
	}
}
