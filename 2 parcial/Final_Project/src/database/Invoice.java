package database;

import java.util.HashMap;
import java.util.Map.Entry;

public class Invoice {
	private int total;
	protected int invoiceRevenue;
	protected HashMap<Integer,AVLTree> articles=new HashMap(); //Hash map that stores multiple articles as an avl tree for rapid indexation when removing
	
	//Class constructor in case this is a new invoice, calls addArticle().
	public Invoice(int newArticle,Integer newPrice){
		this.addArticle(newArticle,newPrice);
	}
	
	public void addArticle(int productCode,Integer newPrice){
		total+=newPrice; //keeps track of invoice total expense
		if(articles.containsKey(productCode)){
			articles.get(productCode).insert(newPrice); //add an item when it already exists
		}
		else{
			AVLTree tree=new AVLTree(); //creation of item
			tree.insert(newPrice);		 	
			articles.put(productCode,tree);
		}
	}
	
	public int total(){
		return total; 
	}
}
