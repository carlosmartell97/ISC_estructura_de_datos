/**
 *	Carlos Emmanuel Martell Aviña A01225920
 *	Jesús Alberto Alvarez Gomez A01039332
 */
package database;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
	String nombre;
	List<Arista> adyacentes;
	short marcado;	// 0 (no visitado),1 (ya estÃ¡ en el Queue) Ã³ 2 (ya estÃ¡ en mi recorrido)
	double distancia;
	Vertice anterior;
	
	public Vertice(){
		
	}
	
	public Vertice(String nombre){
		this.adyacentes=new ArrayList<Arista>();
		this.nombre=nombre;
	}
	
	public void reinicia(){
		this.marcado=0;
		this.anterior=null;
		this.distancia=Double.MAX_VALUE;
	}
}
