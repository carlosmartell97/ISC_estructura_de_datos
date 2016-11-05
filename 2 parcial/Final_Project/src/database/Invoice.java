package database;

import java.util.HashMap;
import java.util.Map.Entry;

public class Invoice {
	private int total;
	protected HashMap<String,Integer> articles=new HashMap();
	
	public Invoice(String newArticle,Integer newPrice){
		articles.put(newArticle,newPrice);
	}
	
	public int total(){
		for(Entry<String, Integer> article: articles.entrySet()){
			total+=article.getValue();
		}
		return total;
	}
}
