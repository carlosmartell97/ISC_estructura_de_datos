package database;

import java.util.HashMap;
import java.util.Map.Entry;

public class Database {
	protected static HashMap<String,User> users=new HashMap();
	
	public void addUser(String newName,String address){
		User user=new User(address);
		users.put(newName,user);
	}
	
	public void addInvoice(String name,Integer invoice,String item,Integer price){
		for(Entry<Integer,Invoice> search: users.get(name).invoices.entrySet()){
			if(invoice.equals(search.getKey())){
				throw new IllegalArgumentException("that invoice already exists");
			}
		}
		if(users.get(name).invoices.containsKey(invoice)){
			System.out.println("do");
			users.get(name).invoices.get(invoice).addArticle(item, price);
		}else{
		Invoice a=new Invoice(item,price);
		users.get(name).invoices.put(invoice, a);
		}
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
