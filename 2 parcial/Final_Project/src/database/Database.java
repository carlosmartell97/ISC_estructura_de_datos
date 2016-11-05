package database;

import java.util.HashMap;

public class Database {
	protected static HashMap<String,User> users=new HashMap();
	
	public void addUser(String newName,String address){
		User user=new User(address);
		users.put(newName,user);
	}
	
	public void addInvoice(String name,Integer newInvoice,String newArticle,Integer newPrice){
		Invoice invoice=new Invoice(newArticle,newPrice);
		users.get(name).invoices.put(newInvoice, invoice);
	}
	
	public boolean contains(String name){
		return users.containsKey(name);
	}
	
	public String getAdress(String name){
		return users.get(name).address;
	}
	
	public int getInvoiceTotal(String name,Integer invoice){
		return users.get(name).invoices.get(invoice).total();
	}
	
	public static void main(String[] args) {
		
		Database database=new Database();
		database.addUser("Juan","Bugambilias");
		
		System.out.println("getAddress: "+database.getAdress("Juan"));
		System.out.println("contains: "+database.contains("Juan"));
		System.out.println("contains: "+database.contains("Pedro"));
		
		database.addInvoice("Juan", 0010, "Ketchup", 50);
		database.addInvoice("Juan", 0010, "Ketchup", 80);
		System.out.println("total: "+database.getInvoiceTotal("Juan",0010));
	}
}
