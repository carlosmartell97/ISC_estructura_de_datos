package Lab2;

import java.util.HashMap;
import java.util.Map;

public class Grafo {
	Map<String,Vertice> vertices;
	public static final double INFINITO=Double.MAX_VALUE;
	
	public Grafo(){
		this.vertices=new HashMap<String,Vertice>();
	}
	
	private Vertice getVertice(String nombre){
		if(this.vertices.containsKey(nombre)) return this.vertices.get(nombre);
		Vertice newVertice=new Vertice();
		this.vertices.put(nombre,newVertice);
		return newVertice;
	}
}
