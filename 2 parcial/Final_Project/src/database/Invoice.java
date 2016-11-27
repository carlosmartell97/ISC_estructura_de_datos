package database;

import java.util.HashMap;
import java.util.Map.Entry;

public class Invoice {
	private int total;
	protected int invoiceRevenue;
	protected HashMap<String,AVLTree> articles=new HashMap();
	
	public Invoice(String newArticle,Integer newPrice){
		this.addArticle(newArticle,newPrice);
	}
	
	public void addArticle(String article,Integer newPrice){
		total+=newPrice;
		if(articles.containsKey(article)){
			articles.get(article).insert(newPrice);
		}
		else{
			AVLTree tree=new AVLTree();
			tree.insert(newPrice);
			articles.put(article,tree);
		}
	}
	
	public int total(){
		return total;
	}
}
