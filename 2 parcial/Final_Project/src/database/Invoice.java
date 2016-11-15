package database;

import java.util.HashMap;
import java.util.Map.Entry;

public class Invoice {
	private int total;
	protected HashMap<String,AVLTree> articles=new HashMap();
	
	public Invoice(String newArticle,Integer newPrice){
		this.addArticle(newArticle,newPrice);
	}
	
	public void addArticle(String newArticle,Integer newPrice){
		total+=newPrice;
		AVLTree tree=new AVLTree();
		tree.insert(newPrice);
		articles.put(newArticle,tree);
	}
	
	public int total(){
		return total;
	}
}
