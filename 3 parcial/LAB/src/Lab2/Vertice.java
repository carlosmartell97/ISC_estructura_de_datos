package Lab2;

import java.util.LinkedList;
import java.util.List;

public class Vertice {
	String nombre;
	List<Arista> adyacentes;
	short marcado;	// 0 (no visitado),1 (ya está en el Queue) ó 2 (ya está en mi recorrido)
	double distancia;
	Vertice anterior;
	
	public Vertice(){
		
	}
	
	public Vertice(String nombre){
		this.adyacentes=new LinkedList();
		this.nombre=nombre;
	}
	
	public void reinicia(){
		this.marcado=0;
		this.anterior=null;
		this.distancia=Double.MAX_VALUE;
	}
}
