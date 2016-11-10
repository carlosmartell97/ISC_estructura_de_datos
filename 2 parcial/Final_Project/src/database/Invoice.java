package database;

import java.util.HashMap;
import java.util.Map.Entry;

public class Invoice {
	private int total;
	protected HashMap<String,Integer> articles=new HashMap();
	
	public Invoice(String newArticle,Integer newPrice){
		this.addArticle(newArticle,newPrice);
	}
	
	public void addArticle(String newArticle,Integer newPrice){
		total+=newPrice;
		articles.put(newArticle,newPrice);
	}
	
	public int total(){
		return total;
	}
}
