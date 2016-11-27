package database;

import java.util.HashMap;
import java.util.Map.Entry;

public class Database {
	protected static HashMap<String,User> users=new HashMap();
	protected static HashMap<Integer,String> invoices_names=new HashMap();
	protected static HashMap<Integer,ChainLinearList> warehouse=new HashMap();
	private static int revenue,expenses;
	
	public Database(){
		updateWarehouse(153, "cake", 12, 26);
		updateWarehouse(275, "dehodorant", 7, 26);
		updateWarehouse(641, "cake", 10, 26);
	}
	
	public void addUser(String newName,String address){
		User user=new User(address);
		users.put(newName,user);
	}
	
	public void addInvoice(String name,int invoice,int productCode,int sellingPrice){
		/*if(invoices_names.containsKey(invoice)){
			throw new IllegalArgumentException("that invoice already exists, you can try with: "+nextAvailableInvoice(invoice));
		}*/
		if(warehouse.containsKey(productCode)){
			
			String productName=(String) warehouse.get(productCode).get(1);
			int realPrice=(int) warehouse.get(productCode).get(2);
			
			if(users.get(name).invoices.containsKey(invoice)){
				users.get(name).invoices.get(invoice).addArticle(productName, sellingPrice);
			}else{
					Invoice a=new Invoice(productName,sellingPrice);
					users.get(name).invoices.put(invoice, a);
					invoices_names.put(invoice, name);
			}
			this.revenue+=sellingPrice-realPrice;
		}
		else{
			throw new IllegalArgumentException("that productCode doesn't belong to any product in your product warehouse");
		}
	}
	
	public void AddItem(int invoice,int productCode,int sellingPrice){
		String name=invoices_names.get(invoice);
		if (!contains(name)){
			throw new IllegalArgumentException("that name isn't in your database");
		}
		this.addInvoice(name,invoice,productCode,sellingPrice);
	}
	
	public static void updateWarehouse(Integer productCode,String productName,int realPrice,int howManyProducts){
		ChainLinearList list=new ChainLinearList();
		list.add(0, productCode); list.add(1, productName); list.add(2, realPrice);
		list.add(3, howManyProducts);
		warehouse.put(productCode, list);
		expenses+=realPrice*howManyProducts;
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
		System.out.println("Welcome! This is how to manage your database:");
		System.out.println("Once a Database is instantiated, you can add users with addUser(name,address).");
		System.out.println("You coud then check if someone is in your databse with contains(name), or get someone's address with getAdress(name).");
		System.out.println("When someone buys something, you add invoices with addInvoice(customerName,invoiceNumber,productCode).");
		System.out.println("If someone buys multiple things, you can just add products to the Invoice you just created with addItem(invoiceNumber,productCode)");
		System.out.println("If someone wants to cancel their purchase, you use removeInvoice(invoiceNumber).");
		System.out.println();
		/////////////////////////////////////
		Database database=new Database();
		database.addUser("Juan","Bugambilias");
		
		System.out.println("getAddress: "+database.getAdress("Juan"));
		System.out.println("contains: "+database.contains("Juan"));
		//System.out.println("getAddress: "+database.getAdress("Pedro"));
		System.out.println("contains: "+database.contains("Pedro"));
		
		database.addInvoice("Juan", 9, 153, 62); System.out.println("added 9");
		//database.addInvoice("Juan", 10, 275, 45); System.out.println("added 10");
		//database.addInvoice("Juan", 11, 641, 50); System.out.println("added 11");
		//database.addInvoice("Juan", 11, 641, 42); System.out.println("added 11");

		//database.addInvoice("Juan", 8, 153, 41); System.out.println("added 8");
		//database.addInvoice("Juan", 7, 153); System.out.println("tried adding 8");
		
		//database.addInvoice("Juan", 12, 153, 40); System.out.println("added 12");
		
		//database.removeInvoice(11);
		System.out.println("expenses "+expenses);
		System.out.println("revenue "+revenue);
		
		//System.out.println("total: "+database.getInvoiceTotal("Johnny",123));
		//System.out.println("total: "+database.getInvoiceTotal(11));
	}
}
