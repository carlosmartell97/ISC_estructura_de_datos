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
	
	public void addArista(String origen,String destino,double cost){
		Vertice v=getVertice(origen);
		Vertice w=getVertice(destino);
		Arista newArista=new Arista(w, cost);
		v.adyacentes.add(v.adyacentes.size(),newArista);
	}
	
	public void reiniciaTodos(){
		for(Vertice v: vertices.values()){
			v.reinicia();
		}
	}
	
	public String breadthFirstSearch(String origen){
		//	...
	}
	
	public String DepthFirstSearch(String origen){
		//	...
	}
}
