package database;

import java.util.HashMap;
import java.util.Map.Entry;

public class Database {
	protected static HashMap<String,User> users=new HashMap();
	protected static HashMap<Integer,String> invoices_names=new HashMap();
	
	public void addUser(String newName,String address){
		User user=new User(address);
		users.put(newName,user);
	}
	
	public void addInvoice(String name,int invoice,String item,int price){
		/*if(invoices_names.containsKey(invoice)){
			throw new IllegalArgumentException("that invoice already exists, you can try with: "+nextAvailableInvoice(invoice));
		}*/
		if(users.get(name).invoices.containsKey(invoice)){
			users.get(name).invoices.get(invoice).addArticle(item, price);
		}else{
			Invoice a=new Invoice(item,price);
			users.get(name).invoices.put(invoice, a);
			invoices_names.put(invoice, name);
		}
	}
	
	public void AddItem(Integer invoice,String item, Integer price){
		String name=invoices_names.get(invoice);
		if (!contains(name)){
			throw new IllegalArgumentException("that name isn't in your database");
		}
		this.addInvoice(name,invoice,item,price);
	}
	
	public void removeInvoice(int invoice){
		String name=invoices_names.get(invoice);
		if(invoices_names.containsKey(invoice)){
			users.get(name).invoices.remove(name);
			invoices_names.remove(invoice);
			return;
		}
		throw new IllegalArgumentException("that invoice isn't in your database");
	}
	
	public boolean contains(String name){
		return users.containsKey(name);
	}
	
	public String getAdress(String name){
		if(contains(name)){
			return users.get(name).address;
		}
		throw new IllegalArgumentException("that name isn't in your database");
	}
	
	public int getInvoiceTotal(String name,Integer invoice){
		if(!invoices_names.containsKey(invoice)){
			throw new IllegalArgumentException("that invoice doesn't exist, you can try with: "+nextTakenInvoice(invoice));
		}
		if(name==invoices_names.get(invoice)){
			return users.get(name).invoices.get(invoice).total();
		}
		throw new IllegalArgumentException("that name doesn't belong to that invoice.");
	}
	
	public int getInvoiceTotal(Integer invoice){
		String name=invoices_names.get(invoice);
		return getInvoiceTotal(name,invoice);
	}
	
	// this method's not returning the actual next available Invoice ID
	private int nextAvailableInvoice(int invoice){
		System.out.println("n:"+invoice);
		if(!invoices_names.isEmpty()){
			while(true){
				if(!invoices_names.containsKey(invoice)){
					return invoice;
				}
				invoice++;
			}
		}
		throw new IllegalArgumentException("database is empty");
	}
	
	private int nextTakenInvoice(int invoice){
		System.out.println("n:"+invoice);
		if(!invoices_names.isEmpty()){
			while(true){
				if(invoices_names.containsKey(invoice)){
					return invoice;
				}
				invoice++;
			}
		}
		System.out.println("you haven't added any elements to the database");
		return 0;
	}
	
	public static void main(String[] args) {
		
		Database database=new Database();
		database.addUser("Juan","Bugambilias");
		
		System.out.println("getAddress: "+database.getAdress("Juan"));
		System.out.println("contains: "+database.contains("Juan"));
		//System.out.println("getAddress: "+database.getAdress("Pedro"));
		System.out.println("contains: "+database.contains("Pedro"));
		
		database.addInvoice("Juan", 9, "Ketchup", 70); System.out.println("added 9");
		database.addInvoice("Juan", 10, "Ketchup", 80); System.out.println("added 10");
		database.addInvoice("Juan", 11, "Ketchup", 60); System.out.println("added 11");
		database.addInvoice("Juan", 11, "Ketchup", 23); System.out.println("added 11");

		database.addInvoice("Juan", 8, "Ketchup", 70); System.out.println("added 8");
		//database.addInvoice("Juan", 8, "Ketchup", 70); System.out.println("tried adding 8");
		
		database.addInvoice("Juan", 12, "Ketchup", 70); System.out.println("added 12");
		
		database.removeInvoice(11);
		//System.out.println("total: "+database.getInvoiceTotal("Johnny",123));
		//System.out.println("total: "+database.getInvoiceTotal(11));
	}
}
