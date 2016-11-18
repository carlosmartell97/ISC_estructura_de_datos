package Lab2;

import java.util.LinkedList;
import java.util.List;

public class Vertice {
	String nombre;
	List<Arista> adyacentes;
	int marcado;	// 0,1 ó 2
	double distancia;
	Vertice anterior;
	
	public Vertice(){
		
	}
	
	public Vertice(String nombre){
		adyacentes=new LinkedList();
		this.nombre=nombre;
	}
	
	public void reinicia(){
		this.marcado=0;
		this.anterior=null;
		this.distancia=Double.MAX_VALUE;
	}
}
