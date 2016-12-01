package database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Database {
	protected static HashMap<String,User> users=new HashMap();			//Hash map storing user's name and an User object
	protected HashMap<Integer,String> invoices_names=new HashMap();			//Hash map with all the invoice numbers and who they belong to
	protected static HashMap<Integer,ChainLinearList> warehouse=new HashMap();	//Hash map with product codes and ChainLinearList with product information
	private static int revenue,expenses;						//Attributes to keep track of total revenue and expenses. Expenses=inversion made to buy products in warehouse. Revenue=total earnings after some sells have been made.
	protected Grafo userDifference;							//Graph with all users. All users are connected, and each link is the difference in expenses between 2 users.
	
	//Default constructor intializes our warehouse with predefined products
	public Database(){
		updateWarehouse(153, "cake", 12, 15);
		updateWarehouse(275, "dehodorant", 7, 11);
		updateWarehouse(641, "soda", 10, 12);
		updateWarehouse(831, "shoe", 22, 41);
		updateWarehouse(418, "laptop", 200, 5);
		updateWarehouse(796, "speakers", 50, 6);
		updateWarehouse(304, "ketchup", 10, 27);
		updateWarehouse(612, "bread", 14, 11);
		updateWarehouse(289, "backpack", 26, 29);
		updateWarehouse(491, "yoghurt", 4, 15);
		updateWarehouse(189, "milk", 20, 13);
	}
	
	//adds user to user's Hash map
	public void addUser(String newName,String address){
		User user=new User(address);
		users.put(newName,user);
	}
	
	public void addInvoice(String name,int invoice,int productCode,int sellingPrice){	//products can be sold for any price. Ideally, they would be sold at a higher price than their real price.
		if(invoices_names.containsKey(invoice)){
			throw new IllegalArgumentException("that invoice already exists");
		}
		if(!users.containsKey(name)){
			throw new IllegalArgumentException("that name doesn't exist"); //if user doesn't exist, throws exception
		}
		if(warehouse.containsKey(productCode)){
			if(warehouse.get(invoice).get(3).compareTo(new Integer(0))<=0){	// if that particular has been sold out
				throw new IllegalArgumentException("that product has been sold out");
			}
			int realPrice=(int) warehouse.get(productCode).get(2); //get data from warehouse
			if(users.get(name).invoices.containsKey(invoice)){
				users.get(name).invoices.get(invoice).addArticle(productCode, sellingPrice); //adds charge to selected invoice
				users.get(name).invoices.get(invoice).invoiceRevenue+=sellingPrice-realPrice; //sets revenue for particular invoice
			}else{
					Invoice a=new Invoice(productCode,sellingPrice); //create new invoice
					users.get(name).invoices.put(invoice, a);	 //add invoice to user's invoice Hash map
					invoices_names.put(invoice, name);		//add invoice to invoice-user relation
			}
			this.revenue+=sellingPrice-realPrice;		//update revenue
			
			//update warehouse to have 1 less product than before
			int howManyProducts=(int) warehouse.get(productCode).get(3)-1;
			String productName=(String) warehouse.get(productCode).get(1);
			updateWarehouse(productCode, productName, realPrice, howManyProducts);
		}
		else{
			throw new IllegalArgumentException("that productCode doesn't belong to any product in your product warehouse");
		}
	}
	
	//alternate method for adding products to an invoice
	public void AddItem(int invoice,int productCode,int sellingPrice){
		String name=invoices_names.get(invoice);
		if (!contains(name)){
			throw new IllegalArgumentException("that name isn't in your database");
		}
		this.addInvoice(name,invoice,productCode,sellingPrice);
	}
	
	//method that creates graph based on user differences for weights
	private void updateGraph(){
		userDifference= new Grafo();
		for(Map.Entry<String, User> userA: users.entrySet()){
			String a=userA.getKey();
			for(Map.Entry<String, User> userB: users.entrySet()){
				String b=userB.getKey();
				userDifference.addArista(a,b,Math.abs(getUserTotal(a)-getUserTotal(b)));
			}
		}
	}
	
	// updates the warehouse
	public static void updateWarehouse(Integer productCode,String productName,int realPrice,int howManyProducts){
		ChainLinearList list=new ChainLinearList(); 
		list.add(0, productCode); list.add(1, productName); list.add(2, realPrice); //sets linear list with product information
		list.add(3, howManyProducts);	//sets linear list with product information
		warehouse.put(productCode, list);	//adds item to warehouse
		expenses+=realPrice*howManyProducts;	//update expenses from database
		revenue-=realPrice*howManyProducts;		//update expenses from database
		try{	//adds new item to initialWarehouse.txt
		    BufferedWriter write=new BufferedWriter(new FileWriter("initialWarehouse.txt",true));
			write.write("Code:"+productCode+"\t"+"Name:"+productName+"\t"+"\t"+"realPrice:"+realPrice+"\t"+"Quantity:"+howManyProducts+"\t");
			write.newLine();
			write.close();
		} catch (IOException e) {
		   
		}
	}
	
	//if some users cancels their purchase and returns the products.
	public void removeInvoice(int invoice){
		String name=invoices_names.get(invoice);	// we retrieve the user's name
		if(invoices_names.containsKey(invoice)){
			revenue-=users.get(name).invoices.get(invoice).invoiceRevenue;	// update revenue
			for(Map.Entry<Integer, AVLTree> article: users.get(name).invoices.get(invoice).articles.entrySet()){	// we go through all products in the invoice
				//	retrieve information from each product
				int productCode=article.getKey();
				String productName=(String) warehouse.get(productCode).get(1);
				int realPrice=(int) warehouse.get(productCode).get(2);
				int howManyProducts=(int) warehouse.get(productCode).get(3);
				//	we add all products user bought back to our warehouse
				howManyProducts+=article.getValue().size;
				updateWarehouse(productCode, productName, realPrice, howManyProducts);
			}
			//	and finally, invoice is removed
			users.get(name).invoices.remove(invoice);
			invoices_names.remove(invoice);
			return;
		}
		throw new IllegalArgumentException("that invoice isn't in your database");
	}
	
	//method returns true iff user exists in user hashmap
	public boolean contains(String name){
		return users.containsKey(name);
	}
	
	//returns address asociated to user
	public String getAdress(String name){
		if(contains(name)){
			return users.get(name).address;
		}		
		throw new IllegalArgumentException("that name isn't in your database");
	}
	
	//method to get user total based on each user's total expenses
	public int getUserTotal(String name){
		int userTotal=0;
		for(Map.Entry<Integer, Invoice> invoice: users.get(name).invoices.entrySet()){
			userTotal+=getInvoiceTotal(name,invoice.getKey());
		}
		return userTotal;
	}
	
	//get specific invoice total
	public int getInvoiceTotal(String name,Integer invoice){
		if(!invoices_names.containsKey(invoice)){
			throw new IllegalArgumentException("that invoice doesn't exist, you can try with: "+nextTakenInvoice(invoice));
		}
		if(name==invoices_names.get(invoice)){
			return users.get(name).invoices.get(invoice).total();
		}
		throw new IllegalArgumentException("that name doesn't belong to that invoice.");
	}
	
	//	get weight of a certain edge from the Graph
	public int getUserDifference(String name1,String name2){
		//	rebuild graph
		updateGraph();
		int cost=userDifference.getCost(name1, name2);
		if(cost==-1){
			throw new IllegalArgumentException("please enter valid user names");
		}
		return cost;
	}
	
	//alternate method for invoice total
	public int getInvoiceTotal(Integer invoice){
		String name=invoices_names.get(invoice);
		return getInvoiceTotal(name,invoice);
	}
	
	public int getTotalExpenses(){
		return expenses;
	}
	
	public int getTotalEarnings(){
		return revenue;
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
		System.out.println("A file 'initialWarehouse.txt' has been generated with the initial products each Database has :)");
		System.out.println("First, go ahead and instantiate your Database");
		System.out.println("You had to pay your suppliers for all products in initialWarehouse.txt, you can check your expenses with getTotalExpenses()");
		System.out.println("You can add users with addUser(name,address)");
		System.out.println("You coud then check if someone is in your databse with contains(name), or get someone's address with getAdress(name)");
		System.out.println("When someone buys something, you add invoices with addInvoice(customerName,invoiceNumber,productCode)");
		System.out.println("If someone buys multiple things, you can just add products to the Invoice you just created with addItem(invoiceNumber,productCode)");
		System.out.println("If someone wants to cancel their purchase, you use removeInvoice(invoiceNumber)");
		System.out.println("At any time, you can see how much someone has spent on your store with getUserTotal(userName)");
		System.out.println("Or, get the total of just one Invoice with getInvoiceTotal(userName,invoiceNumber)");
		System.out.println("At any time, you can check how much earnings you have with getTotalEarnings()");
		System.out.println("To start this program all over again, remember to first delete initialWarehouse.txt");
		System.out.println();
		/////////////////////////////////////
		Database database=new Database();
		database.addUser("Juan","Bugambilias");
		database.addUser("Gerardo", "Puebla");
		
		System.out.println("getAddress: "+database.getAdress("Juan"));
		System.out.println("contains: "+database.contains("Juan"));
		//System.out.println("getAddress: "+database.getAdress("Pedro"));
		System.out.println("contains: "+database.contains("Pedro"));
		
		database.addInvoice("Juan", 9, 153, 62); System.out.println("added 9");
		database.addInvoice("Juan", 13, 275, 10);
		database.removeInvoice(13);
		System.out.println(database.getInvoiceTotal(13));
		database.addInvoice("Gerardo", 10, 275, 9); System.out.println("added 10");
		System.out.println("difference: "+database.getUserDifference("Juan", "Gerardo"));
		//database.addInvoice("Juan", 11, 641, 50); System.out.println("added 11");
		//database.addInvoice("Juan", 11, 641, 42); System.out.println("added 11");

		//database.addInvoice("Juan", 8, 153, 41); System.out.println("added 8");
		//database.addInvoice("Juan", 7, 153); System.out.println("tried adding 8");
		
		//database.addInvoice("Juan", 12, 153, 40); System.out.println("added 12");
		
		//database.removeInvoice(11);
		System.out.println("expenses: "+database.getTotalExpenses());
		System.out.println("earnings: "+database.getTotalEarnings());
		//System.out.println("total: "+database.getInvoiceTotal("Johnny",123));
		//System.out.println("total: "+database.getInvoiceTotal(11));
	}
}
