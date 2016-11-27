package database;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Grafo {
	Map<String,Vertice> vertices;
	public static final double INFINITO=Double.MAX_VALUE;
	
	public Grafo(){
		this.vertices=new HashMap<String,Vertice>();
	}
	
	private Vertice getVertice(String nombre){
		if(this.vertices.containsKey(nombre)) return this.vertices.get(nombre);
		Vertice newVertice=new Vertice(nombre);
		this.vertices.put(nombre,newVertice);
		return newVertice;
	}
	
	public void addArista(String origen,String destino,double cost){
		Vertice v=getVertice(origen);
		Vertice w=getVertice(destino);
		v.adyacentes.add(new Arista(w, cost));
		v.adyacentes.add(new Arista(v, cost));
	}	
	
	public void reiniciaTodos(){
		for(Vertice v: vertices.values()){
			v.reinicia();
		}
	}
	
	public String breadthFirstSearch(String origen){
		String output="";
		Vertice origin=this.vertices.get(origen);
		for(Map.Entry<String,Vertice> v: this.vertices.entrySet()){
			Vertice vertice=v.getValue();
			vertice.marcado=0;
			vertice.distancia=this.INFINITO;
			vertice.anterior=null;
		}
		origin.marcado=1;
		origin.distancia=0;
		origin.anterior=null;
		
		Queue<Vertice> queue=new LinkedList<Vertice>();
		queue.add(origin);
		while(!queue.isEmpty()){
			Vertice u = queue.remove();
			output+=u.nombre;
			int size = u.adyacentes.size();
			for(int i = 0;i < size; i++){
				Vertice v = u.adyacentes.get(i).destino();
				if(v.marcado == 0){
					v.marcado = 1;
					v.distancia = u.distancia+1;
					v.anterior = u;
					queue.add(v);
				}
			}
			u.marcado=2;
		}
		return output;
	}
	
	public String DepthFirstSearch(String origen){
		String output="";
		
		Vertice origin = this.getVertice(origen);
		for(Map.Entry<String, Vertice> u: this.vertices.entrySet()){
			Vertice vertice = u.getValue();
			vertice.marcado = 0;
			vertice.distancia = this.INFINITO;
			vertice.anterior = null;
		}
		int time = 0;
		output+=DFSVisit(time,origin);
		
		return output;
	}
	
	private String DFSVisit(int time,Vertice u){
		String output = "";
		
		time = time+1;
		u.distancia = time;
		u.marcado = 1;
		int size = u.adyacentes.size();
		for(int i = 0;i < size; i++){
			Vertice v = u.adyacentes.get(i).destino();
			if(v.marcado==0){
				v.anterior=u;
				output+=DFSVisit(time,v);
			}
		}
		u.marcado = 2;
		time = time+1;
		u.distancia = time;
		output+=u.nombre;
		return output;
	}
}
