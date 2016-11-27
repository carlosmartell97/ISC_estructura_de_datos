package database;

import java.util.HashMap;
import java.util.Map.Entry;

public class Invoice {
	private int total;
	protected int invoiceRevenue;
	protected HashMap<Integer,AVLTree> articles=new HashMap();
	
	public Invoice(int newArticle,Integer newPrice){
		this.addArticle(newArticle,newPrice);
	}
	
	public void addArticle(int productCode,Integer newPrice){
		total+=newPrice;
		if(articles.containsKey(productCode)){
			articles.get(productCode).insert(newPrice);
		}
		else{
			AVLTree tree=new AVLTree();
			tree.insert(newPrice);
			articles.put(productCode,tree);
		}
	}
	
	public int total(){
		return total;
	}
}
